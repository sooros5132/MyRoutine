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

@WebServlet("/admin/community/reg")
@MultipartConfig(
    fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, 
    maxRequestSize=1024*1024*5*5)
public class RegController extends HttpServlet{
	
	private CommunityService service;
	
	public RegController() {
		service = new CommunityService(); 
	}
//���	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//���..������ �޾ƿͼ�.. �������� �ֱ� get������� post �������
		//�Ķ���� �޾Ƽ� REG���;��ϴϱ� .GET
		System.out.println(request.getMethod());
		
		if(request.getMethod().equals("GET")){
			
			List<CommunityCategory> cList = service.getCategoryList();

			request.setAttribute("cList", cList);

			request.getRequestDispatcher("reg.jsp").forward(request, response);
			
		}else if(request.getMethod().equals("POST")){
	//���޹��� �����͵��� �ѱ�鼭 ���
			String title = request.getParameter("title");
			int memberId =  Integer.parseInt(request.getParameter("memberId"));
			String writerName = request.getParameter("writerName");
			String contents = request.getParameter("contents");
			String categoryType = request.getParameter("categoryType");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));

			//==============��¥����=========================================================
			SimpleDateFormat formatter =new SimpleDateFormat("yyyy");
//			SimpleDateFormat formatter1 =new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			Date date = new Date();
			String currentYear =formatter.format(date);
			
			//=============================================================================

			//============== ���ϵ�� =========================================================			
			Collection<Part> fileParts = request.getParts();//���������϶� ��ü�� �޾ƾ��ؼ� ���ƾ��Ѵ�.
	         String fileNames = "";
			 for(Part p:fileParts) {
				 if(p.getName().equals("file") && p.getSize() > 0) {
					 //p.getSize() > 0 �����߰� ���������� �߰�
					 Part filePart = p;
					 String fileName = filePart.getSubmittedFileName();
					 System.out.println(fileName);
//					 fileNames += fileName;
//					 fileNames +=",";
					 int newId = service.getListId() +1; 
					 
					 String pathTemp = "/static/community/"+currentYear+"/"+newId;
					//���������ϱ�
					String realPathTemp = request.getServletContext().getRealPath(pathTemp);
					File path=new File(realPathTemp);
					//������ ������ �ִ��� Ȯ���Ѵ�.
					if(!path.exists())
						path.mkdirs();
					
					//String filePath = pathTemp +"\\"+filePart.getSubmittedFileName(); 
					//��α����ڸ� �����Ѵ�. File.separator ������� ���������� ��ο� �°� �ٲ��ش�.
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

					//���ϵ��
					CommunityFile communityFile = new CommunityFile(0,fileName, pathTemp + File.separator , newId);
					System.out.println(communityFile);
					
					int result = service.fileInsert(communityFile);
					
					fos.close();
					fis.close();
				 
				 }
			 }
		
				//=============���========================================================	
				CommunityService service = new CommunityService();
				
				
				Community community = new Community(0, memberId,  writerName,title, 0, date,contents, categoryId, categoryType,"","","");

				int newCommunityId = service.insert(community);
				//=======================================================================	
			 
			 //����������� �̵�
			response.sendRedirect("/admin/community/list");
		}
	}

}
