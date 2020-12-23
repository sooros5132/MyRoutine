package com.myroutine.web.controller.api.community;

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

@WebServlet("/api/community/reg")
@MultipartConfig(
    fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, 
    maxRequestSize=1024*1024*5*5)
public class RegController extends HttpServlet{
	
	private CommunityService service;
	
	public RegController() {
		service = new CommunityService(); 
	}
//등록	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//등록..컨텐츠 받아와서.. 쿼리문에 넣기 get방식인지 post 방식인지
		//파라메터 받아서 REG들어와야하니까 .GET
		System.out.println(request.getMethod());
		
		if(request.getMethod().equals("GET")){
			
			List<CommunityCategory> cList = service.getCategoryList();

			request.setAttribute("cList", cList);

			request.getRequestDispatcher("reg.jsp").forward(request, response);
			
		}else if(request.getMethod().equals("POST")){
	//전달받은 데이터들을 넘기면서 사용
			String title = request.getParameter("title");
			String writerName = request.getParameter("writerName");
			String contents = request.getParameter("contents");
			String categoryType = request.getParameter("categoryType");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));

			//==============날짜포멧=========================================================
			SimpleDateFormat formatter =new SimpleDateFormat("yyyy");
//			SimpleDateFormat formatter1 =new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			Date date = new Date();
			String currentYear =formatter.format(date);
			
			//=============================================================================

			//============== 파일등록 =========================================================			
			Collection<Part> fileParts = request.getParts();//여러파일일때 전체를 받아야해서 돌아야한다.
	         String fileNames = "";
			 for(Part p:fileParts) {
				 if(p.getName().equals("file") && p.getSize() > 0) {
					 //p.getSize() > 0 파일추가 안했을때도 추가
					 Part filePart = p;
					 String fileName = filePart.getSubmittedFileName();
					 System.out.println(fileName);
//					 fileNames += fileName;
//					 fileNames +=",";
					 int newId = service.getListId() +1; 
					 
					 String pathTemp = "/static/community/"+currentYear+"/"+newId;
					//파일저장하기
					String realPathTemp = request.getServletContext().getRealPath(pathTemp);
					File path=new File(realPathTemp);
					//지정된 파일이 있는지 확인한다.
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
					
//					while( size != -1) {
//						size = fis.read(buf);
//						fos.write(buf,0,size);
//					}

					while((size = fis.read(buf)) !=-1)
						fos.write(buf,0,size);

//					fileNames = fileNames.substring(0, fileNames.lastIndexOf(","));
//					System.out.println(fileNames);

					//파일등록
					CommunityFile communityFile = new CommunityFile(0,fileName, pathTemp + File.separator , newId);
					System.out.println(communityFile);
					
					int result = service.fileInsert(communityFile);
					
					fos.close();
					fis.close();
				 
				 }
			 }
		
				//=============등록========================================================	
				CommunityService service = new CommunityService();
				
				//파일테이블에 등록..System.currentTimeMillis()
				
				Community community = new Community(0, 22,  writerName,title, 0, date,contents, categoryId, categoryType,"","","");

				//등록후 아이디 가져와서 처리했으나 오류남..다시 등록을 아래로 내림	
				//TODO 다시해보기
				int newCommunityId = service.insert(community);
				//=======================================================================	
			 
			 //목록페이지로 이동
			response.sendRedirect("/admin/community/list");
		}
	}

}
