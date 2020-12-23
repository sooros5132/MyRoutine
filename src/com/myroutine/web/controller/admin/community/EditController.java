package com.myroutine.web.controller.admin.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.dao.entity.CommunityCategory;
import com.myroutine.web.dao.entity.CommunityFile;
import com.myroutine.web.service.CommunityService;

@WebServlet("/admin/community/edit")
@MultipartConfig(
	    fileSizeThreshold=1024*1024, 
	    maxFileSize=1024*1024*5, 
	    maxRequestSize=1024*1024*5*5)
public class EditController extends HttpServlet {
	
	private CommunityService service;
	
	public EditController() {
		service = new CommunityService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//id받아서 페이지 전환
		int id = Integer.parseInt(request.getParameter("id"));

		CommunityService service = new CommunityService();

		List<CommunityCategory> cList = service.getCategoryList();
		List<CommunityFile> fList = service.getFileList(id);
		Community m = service.getDetail(id);

		
		
		//카테고리
		request.setAttribute("cList", cList);
		//상세
		request.setAttribute("m", m);
		//파일
		request.setAttribute("fList", fList);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//데이터받아서 쿼리실행후 디테일페이지로
		int id=Integer.parseInt(request.getParameter("id"));
		String title =request.getParameter("title");
		String contents =request.getParameter("contents");
		int hit=Integer.parseInt(request.getParameter("hit"));
		int categoryId =Integer.parseInt(request.getParameter("categoryId"));
		String categoryType =request.getParameter("categoryType");
		String oldfile = request.getParameter("oldFile").equals(null) ? "" : request.getParameter("oldFile");
//		String filePath =request.getParameter("filePath");
//		String fileId = request.getParameter("fileId");
	
		CommunityService service = new CommunityService();
		
		//==============날짜포멧=========================================================
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy");
		Date date = new Date();
		String currentYear =formatter.format(date);
		
		//화면에서 지운 파일 삭제=============================================================================
		if(!oldfile.equals("")) {
		
			String[] oldfileIds = oldfile.split(",");
			for(int i=0; i< oldfileIds.length; i++) {
				int fileId = Integer.parseInt(oldfileIds[i]);
				//지운파일들..삭제
				service.fileDelete(fileId);

			}
		}
		
		//파일등록===================================================================
		Collection<Part> fileParts =request.getParts();
		
		for(Part filePart:fileParts)
		{
			if(filePart.getName().equals("file") && filePart.getSize() > 0 ) {
				
				String fileName= filePart.getSubmittedFileName();
				//수정이라..커뮤니티 아이디 필요함..
//				int newId =  service.getListId()+1;

				String pathTemp =  "/static/community/"+currentYear+"/"+id;
				
				//파일저장하기
				String realPathTemp = request.getServletContext().getRealPath(pathTemp);
				
				File path = new File(realPathTemp);
				
				if(!path.exists())
					path.mkdirs();
				//String filePath = pathTemp +"\\"+filePart.getSubmittedFileName(); 
				//경로구분자를 얻어야한다. File.separator 윈도우즈나 리눅스등의 경로에 맞게 바꿔준다.
				String filePath = realPathTemp + File.separator + fileName;

				//File submittedFile = new File("/static/community/2020/5/"+filePart.getSubmittedFileName());
				InputStream fis = filePart.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				byte[] buf = new byte[1024];
				int size = 0;
//				while( size != -1) {
//					size = fis.read(buf);
//					fos.write(buf,0,size);
//				}
				while((size = fis.read(buf)) !=-1)
					fos.write(buf,0,size);
				

				//파일등록
				CommunityFile communityFile= new CommunityFile(0, fileName, pathTemp+File.separator, id); 
				service.fileInsert(communityFile);
				System.out.println(communityFile);
				
				fos.close();
				fis.close();
			}
			
		}
		


		//수정등록
		Community m = new Community(id, 0, "", title, hit, date, contents, categoryId,categoryType, "","","");
		service.update(m);
		
		//detail페이지	
		response.sendRedirect("/admin/community/detail?id="+id);	
	}
	
}
