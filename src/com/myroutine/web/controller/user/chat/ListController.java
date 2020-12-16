package com.myroutine.web.controller.user.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.entity.user.ChatFile;
import com.myroutine.web.service.TimeService;
import com.myroutine.web.service.user.ChatFileService;
import com.myroutine.web.service.user.ChatViewService;

@WebServlet("/chat/get")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		

		// DISCONNECT CHECK -----------------------------------------
		String idCheck = request.getParameter("memberId");
		
		if( idCheck == null || idCheck.equals("") ) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		// SETTING --------------------------------------------------
		int result = 0;
		int memberId = Integer.parseInt(idCheck);
		
		// GET ------------------------------------------------------
		ChatViewService service = new ChatViewService();
		List<ChatView> list = service.getList(memberId);

		if( list.isEmpty() ) {
			out.print("{\"result\": \"fail\"}");
			out.close();
			return;
		}
		
		Set<String> idList = new HashSet<String>();
		ChatFileService fileService = new ChatFileService();
		
		for(ChatView c : list)
			idList.add(Integer.toString(c.getId()));

		System.out.println(String.join(",", idList));
		
		List<ChatFile> fileList = fileService.getList(idList);
		
//		out.println(list);
//		out.println(fileList);
		
		// OUT SETTING -------------------------------------------------
		List<String> results = new ArrayList<String>();
		
		for(ChatView c : list) {
			SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
			String regDate = formatter.format ( c.getRegistrantionDate() );
			results.add(String.format("\"id\":%d,\"regMemberName\":\"%s\",\"requesterName\":\"%s\",\"contents\":\"%s\",\"registrantionDate\":\"%s\"",
					c.getId(), c.getRegMemberName(), c.getRequesterName(), c.getContents(), regDate));
		}
//		
//		// JSON OUT -------------------------------------------------
		out.print("{");
		out.print("\"result\":\"sussess\",");
		out.print("\"datas\":[{");
			out.print(String.join("},{",results));
			out.print("}]");
		out.print("}");
		
	}
	
}
