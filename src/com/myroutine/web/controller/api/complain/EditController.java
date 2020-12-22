package com.myroutine.web.controller.api.complain;

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

import com.myroutine.web.dao.entity.Complain;
import com.myroutine.web.dao.entity.ComplainCategory;
import com.myroutine.web.dao.entity.ComplainFile;
import com.myroutine.web.service.ComplainService;

@WebServlet("/api/complain/edit")
@MultipartConfig(
	    fileSizeThreshold=1024*1024, 
	    maxFileSize=1024*1024*5, 
	    maxRequestSize=1024*1024*5*5)
public class EditController extends HttpServlet {
	
	private ComplainService service;
	
	public EditController() {
		service = new ComplainService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//id�޾Ƽ� ������ ��ȯ
		int id = Integer.parseInt(request.getParameter("id"));

		ComplainService service = new ComplainService();

		List<ComplainCategory> cList = service.getCategoryList();
		List<ComplainFile> fList = service.getFileList(id);
		Complain m = service.getDetail(id);

		
		
		//ī�װ�
		request.setAttribute("cList", cList);
		//��
		request.setAttribute("m", m);
		//����
		request.setAttribute("fList", fList);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//�����͹޾Ƽ� ���������� ��������������
		int id=Integer.parseInt(request.getParameter("id"));
		String title =request.getParameter("title");
		String contents =request.getParameter("contents");
		int hit=Integer.parseInt(request.getParameter("hit"));
		int categoryId =Integer.parseInt(request.getParameter("categoryId"));
		String categoryType =request.getParameter("categoryType");
		String oldfile = request.getParameter("oldFile").equals(null) ? "" : request.getParameter("oldFile");
//		String filePath =request.getParameter("filePath");
//		String fileId = request.getParameter("fileId");
	
		ComplainService service = new ComplainService();
		
		//==============��¥����=========================================================
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy");
		Date date = new Date();
		String currentYear =formatter.format(date);
		
		//ȭ�鿡�� ���� ���� ����=============================================================================
		if(!oldfile.equals("")) {
		
			String[] oldfileIds = oldfile.split(",");
			for(int i=0; i< oldfileIds.length; i++) {
				int fileId = Integer.parseInt(oldfileIds[i]);
				//�������ϵ�..����
				service.fileDelete(fileId);

			}
		}
		
		//���ϵ��===================================================================
		Collection<Part> fileParts =request.getParts();
		
		for(Part filePart:fileParts)
		{
			if(filePart.getName().equals("file") && filePart.getSize() > 0 ) {
				
				String fileName= filePart.getSubmittedFileName();
				//�����̶�..Ŀ�´�Ƽ ���̵� �ʿ���..
//				int newId =  service.getListId()+1;

				String pathTemp =  "/static/complain/"+currentYear+"/"+id;
				
				//���������ϱ�
				String realPathTemp = request.getServletContext().getRealPath(pathTemp);
				
				File path = new File(realPathTemp);
				
				if(!path.exists())
					path.mkdirs();
				//String filePath = pathTemp +"\\"+filePart.getSubmittedFileName(); 
				//��α����ڸ� �����Ѵ�. File.separator ������� ���������� ��ο� �°� �ٲ��ش�.
				String filePath = realPathTemp + File.separator + fileName;

				//File submittedFile = new File("/static/complain/2020/5/"+filePart.getSubmittedFileName());
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
				

				//���ϵ��
				ComplainFile complainFile= new ComplainFile(0, fileName, pathTemp+File.separator, id); 
				service.fileInsert(complainFile);
				System.out.println(complainFile);
				
				fos.close();
				fis.close();
			}
			
		}
		


		//�������
		Complain m = new Complain(id, 0, "", title, hit, date, contents, categoryId,categoryType, "","","");
		service.update(m);
		
		//detail������	
		response.sendRedirect("/admin/complain/detail?id="+id);	
	}
	
}
