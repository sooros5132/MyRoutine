package com.myroutine.web.controller.admin.exercise;

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

import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;
import com.myroutine.web.service.admin.exercise.ExerciseBodyPartService;
import com.myroutine.web.service.admin.exercise.ExerciseFileService;
import com.myroutine.web.service.admin.exercise.ExerciseService;

@WebServlet("/admin/exercise/add")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024,
	maxFileSize = 1024 * 1024 * 5, //5메가
	maxRequestSize = 1024 * 1024 * 5 * 5 //5메가
)

public class AddController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/admin/exercise/add.jsp");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberId  = 21; //임시로 고정 //String memberId = request.getParameter("memberId");
		
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String engName = request.getParameter("eng-name");
		String recommand = request.getParameter("recommand");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		
		ExerciseService exService = new ExerciseService();
		Exercise exercise = new Exercise(name, contents, engName, recommand, memberId, categoryId);
		System.out.println(exercise.toString());
		int id = exService.insert(exercise);
		
		
		//----------
		
		
		//(카테고리에 따라)부위 받아옴.
		String[] bodyParts_ = null;
		System.out.println(categoryId);
		if(categoryId ==1) {
			bodyParts_ = request.getParameterValues("body-part-re");
		}else if(categoryId ==2) {
			bodyParts_ = request.getParameterValues("body-part-ex");
		}
		
		//받은 부위 인트형 배열로 바꾸기
		int[] bodyParts = new int[bodyParts_.length];
		
		for(int i=0;i<bodyParts_.length; i++){ 
			bodyParts[i] = Integer.parseInt(bodyParts_[i]);
		}
		
		//받은 부위 객체 만들기 서비스로 보냄
		ExerciseBodyPartService ebpService = new ExerciseBodyPartService();
		for (int bodyPart : bodyParts) {
			ExerciseBodyPart ebp = new ExerciseBodyPart(bodyPart, id);
			ebpService.insert(ebp);	
			System.out.println(ebp.toString());
		}
		
		
		//----------
		
		//다중 파일  받아오기
		String fs = File.separator; //파일 구분기호
		ExerciseFileService exerciseFileService = new ExerciseFileService();
		Collection<Part> fileParts = request.getParts(); 
		for (Part p : fileParts) {
			
			
			if(p.getName().equals("file") && !p.getSubmittedFileName().equals("")) {
				Part filePart = p;
				String fileName = filePart.getSubmittedFileName(); //파일이름 가져오기
				
				//실제 서비스의 물리경로
				String pathTemp = request.getServletContext().getRealPath(fs + "exercise");
				System.out.println("pathTemp : " + pathTemp);
				
				//업로드 경로생성
				String filePath = pathTemp + fs + fileName;
				System.out.println("filePath : " + filePath);
				
				//업로드 폴더 만들기
				File path = new File(pathTemp);
					if(!path.exists())
						path.mkdirs();
				
				//파일 읽어오기
				InputStream fis = filePart.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while ((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);

				fos.close();
				fis.close();
				
				ExerciseFile exerciseFile = new ExerciseFile(fileName, filePath, id);
				System.out.println(exerciseFile.toString());
				exerciseFileService.insert(exerciseFile);
			}
		}		
		
		//목록페이지로 이동
		//response.sendRedirect("list");
	}
}