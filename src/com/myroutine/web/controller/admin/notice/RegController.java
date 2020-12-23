package com.myroutine.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.myroutine.web.dao.entity.NoticeView;
import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.entity.admin.notice.NoticeFile;
import com.myroutine.web.service.admin.notice.NoticeFileService;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/reg")
@MultipartConfig(
   
    fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, 
    maxRequestSize=1024*1024*5*5)

public class RegController extends HttpServlet {
	private NoticeService service;
	
	public RegController() {
           service = new NoticeService();  
	}
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.getRequestDispatcher("reg.jsp").forward(request, response);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	String title = request.getParameter("title");
	//String file = request.getParameter("file");
	
	
	String contents = request.getParameter("contents");
	String isOpen = request.getParameter("open");
	
	Notice notice = new Notice(title,contents);
	
	//Part filePart = request.getPart("file"); //단일 파일
	Collection <Part> fileParts = request.getParts();
	
	String fileNames ="";
	//StringBuilder builder = new StringBuilder();
	String pathTemp ="";
	
	for(Part p: fileParts) {
		if(p.getName().equals("files")&& p.getSize()>0) {
			Part filePart = p;
			
			String fileName = filePart.getSubmittedFileName();
			fileNames += fileName;
			fileNames += ",";
			//builder.append(fileName);
			//builder.append(",");
			  
			   //System.out.println(file);
			   
			  //int newId = service.getLastId()+1;
			   
			  
			  pathTemp = request.getServletContext().getRealPath("/static/notice/2020/");
			  System.out.println(pathTemp);     
			  
			  File path = new File(pathTemp);
			  
			  if(!path.exists())
				  path.mkdirs();
			  
			  String filePath = pathTemp +File.separator+ fileName;
			  System.out.println(filePath);//경로+파일명
			  
			  
			  InputStream fis = filePart.getInputStream();
			  FileOutputStream fos = new FileOutputStream(filePath);
			  
			  byte[] buf = new byte[1024];
			  int size =0;
			  while((size = fis.read(buf))!=-1) //반환한 결과값이 -1이 아니면
				  fos.write(buf,0,size);   // 0번째부터 사이즈 개수만큼 돌면서 출력
			   
			  
			  fos.close();
			  fis.close();
			 
			
		}
	}
	
	
	   
	   //데이터입력
	   
	    boolean openInfo = false;
	    
	    switch(isOpen) {
	      case "공개":
	    	  if(isOpen !=null)
	    	  openInfo = true;
	    	  break;
	      case "비공개":
	    	  openInfo = false;
	    
	    }
//	    if(isOpen !=null)
//	    	openInfo= true;
	
	   notice.setMemberId("admin");
	   notice.setOpenInfo(openInfo);
	   
	   
	   
	   NoticeService service = new NoticeService();
	   service.insert(notice);
	    
	   
	   //builder.delete(builder.length()-1, builder.length());
	   
	   
	   NoticeFile noticeFile= new NoticeFile();
	   noticeFile.setName(fileNames);
	   //noticeFile.setName(builder.toString());
	   noticeFile.setRoute(pathTemp);
	   System.out.println(pathTemp);
	   
	   int id = service.getLastId(); 
	   noticeFile.setNoticeId(id);
	   
	   
	   NoticeFileService nfservice = new NoticeFileService();
	   nfservice.insert(noticeFile);
	   
	  
	   
	   //페이지 이동
	   response.sendRedirect("list");
	
	}

}
