package com.myroutine.web.controller.api.chat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.myroutine.web.entity.user.chat.Chat;
import com.myroutine.web.entity.user.chat.ChatFile;
import com.myroutine.web.service.TimeService;
import com.myroutine.web.service.user.chat.ChatFileService;
import com.myroutine.web.service.user.chat.ChatService;

@WebServlet("/api/chat/upload")
@MultipartConfig(
    fileSizeThreshold = 1024*1024,
    maxFileSize = 1024*1024*10, //10메가
    maxRequestSize = 1024*1024*10*5 // 10메가 5개까지
)
public class UploadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String contents = request.getParameter("content");
		String regMemberIdTemp = request.getParameter("memberId");
		String requesterTemp = request.getParameter("otherMemberId");

		// DISCONNECT CHECK -----------------------------------------
		if( regMemberIdTemp == null || requesterTemp == null || contents == null ||
			regMemberIdTemp.equals("")|| requesterTemp.equals("") || contents.equals("") ) {
		}
		
		String memberId_ = request.getParameter("memberId");
		if(memberId_ == null || memberId_.equals("")) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		// FILE SAVE --------------------------------------------------
		int memberId = 0;
		memberId = Integer.parseInt(memberId_);
		
		Collection<Part> fileParts = request.getParts();
		ChatFileService service = new ChatFileService();
		List<ChatFile> uploadedFiles = new ArrayList<ChatFile>();
		
		for(Part p : fileParts) {
			if( p.getName().equals("files") && p.getSize() > 0) {
	            Part filePart = p;
	
	            // 파일 저장
	            String fileName = filePart.getSubmittedFileName();
	            
	            // 파일명은 "CF" + "멤버아이디" + "시간" + "확장자명"
	            // "CF" + "449" + "20201203164741"
	            TimeService.setDate(new Date(System.currentTimeMillis()));
	    		String year = TimeService.getYear();
	    		String month = TimeService.getMonth();
	    		String date = TimeService.getDate();
	    		String timeMillisecond = TimeService.getTimeMillisecond();
	    		
	    		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
	    		String uploadName = "cf" + memberId + timeMillisecond + "." + fileExt; 
	    		
	    		String path_ = String.format("/static/chat/%s/%s/%s", year, month, date);
	            String pathTemp = request.getServletContext().getRealPath(path_);
	                        
	            File path = new File(pathTemp);
	            if(!path.exists())
	               path.mkdirs();
	            
	            String filePath = pathTemp + File.separator + uploadName;
	            
	            InputStream fis = filePart.getInputStream();
	            FileOutputStream fos = new FileOutputStream(filePath);
	            
	            byte[] buf = new byte[1024];
	            int size = 0;
	            while((size = fis.read(buf)) != -1)
	               fos.write(buf, 0, size);
	            
	            fos.close();
	            fis.close();
	            

	            // DB전송 ====================================
				ChatFile cf = new ChatFile();
				cf.setName(fileName);
				cf.setRoute(path_ + "/" + uploadName);
				
				// 결과 ====================================
				// 아이디값을 리턴받음
				int result = service.insert(cf);
				if( result > 0) {
					cf.setChatId(result);
					uploadedFiles.add(cf);
				}
			}
		}
		if(uploadedFiles.isEmpty()) {
			out.print("{\"result\": \"fail\"}");
			return;
		}
		
		// JSON SETTING --------------------------------------------------
		List<String> results = new ArrayList<String>();
		
		for(ChatFile cf : uploadedFiles) {
			String jsonTemp = String.format("\"id\":%d,\"name\":\"%s\",\"route\":\"%s\"",
					cf.getChatId(), cf.getName(), cf.getRoute());	
			results.add(jsonTemp);
		}

		// JSON OUT -------------------------------------------------
		out.print("{");
		out.print("\"result\":\"sussess\",");
		out.print("\"datas\":[{");
			out.print(String.join("},{",results));
			out.print("}]");
		out.print("}");
		
	}
}
