package com.myroutine.web.controller.admin.exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;
import com.myroutine.web.service.admin.exercise.ExerciseBodyPartService;
import com.myroutine.web.service.admin.exercise.ExerciseFileService;
import com.myroutine.web.service.admin.exercise.ExerciseService;

@WebServlet("/admin/exercise/edit")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 5, //5메가
		maxRequestSize = 1024 * 1024 * 5 * 5 //5메가
	)
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		

		ExerciseService exerciseService = new ExerciseService();
		Exercise exercise = exerciseService.get(id);
		System.out.println(exercise.toString());
		
		
		ExerciseBodyPartService exerciseBodyPartService = new ExerciseBodyPartService();
		List<ExerciseBodyPart> exerciseBodyPartList  = exerciseBodyPartService.getList(id); 
		System.out.println(exerciseBodyPartList);
		
		
		request.setAttribute("ex", exercise);
		request.setAttribute("ebpList", exerciseBodyPartList);
		

		// 0001,0011,0004
		{
			List<String> temp = new ArrayList<String>();
			
			for(ExerciseBodyPart ebp : exerciseBodyPartList) {
				if( ebp != null && ebp.getBodyPartId() != 0) {
					temp.add(String.format("%04d", ebp.getBodyPartId()));
				}
					
			}
			
			String ebps = String.join(",", temp);
			request.setAttribute("ebps", ebps);
		}
		
		
		
		//파일 셋팅
		ExerciseFileService exerciseFileService = new ExerciseFileService();
		List<ExerciseFile> exFileList = exerciseFileService.getList(id);
		System.out.println(exFileList);
		request.setAttribute("exFileList", exFileList);
		
		request.getRequestDispatcher("/admin/exercise/edit.jsp").forward(request, response);

	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int memberId  = (int) session.getAttribute("memberId");
		
		//운동정보 수정
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String engName = request.getParameter("eng-name");
		String recommend = request.getParameter("recommend");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		ExerciseService exerciseService = new ExerciseService();
		Exercise exercise = new Exercise(id, name, contents, engName, recommend, memberId, categoryId);
		System.out.println(exercise.toString());
		exerciseService.update(exercise);
		

		//운동 부위 수정(월래 정보 전부 삭제하고 다시 등록)
		ExerciseBodyPartService ebpService = new ExerciseBodyPartService();
		//1.운동 부위 삭제
		ebpService.delete(id);
		

		//2운동 부위 다시 추가
		String[] bodyParts_ = null;
		System.out.println(categoryId);
		if(categoryId ==1) {
			bodyParts_ = request.getParameterValues("body-part-re");
		}else if(categoryId ==2) {
			bodyParts_ = request.getParameterValues("body-part-ex");
		}
		System.out.println("bodyParts)_" + bodyParts_.length);
		
		//받은 부위 인트형 배열로 바꾸기
		int[] bodyParts = new int[bodyParts_.length];
		
		for(int i=0;i<bodyParts_.length; i++){ 
			bodyParts[i] = Integer.parseInt(bodyParts_[i]);
			System.out.println("운동부위 추가 : " + bodyParts[i]);
		}
		
		//받은 부위 객체 만들기 서비스로 보냄
		for (int bodyPart : bodyParts) {
			ExerciseBodyPart ebp = new ExerciseBodyPart(bodyPart, id);
			ebpService.insert(ebp);	
			System.out.println(ebp.toString());
		}
		
		
		
		//첨부파일 확인
		ExerciseFileService exerciseFileService = new ExerciseFileService();
		
		
		String[] fileNameArr = request.getParameterValues("file-name");
		
		
		
		//파일을 수정한 경우
		if(fileNameArr != null) {
			String fileNameStr = "";
			//String fileNameStr = String.join(",", fileNameArr);
			for (int i =0; i<fileNameArr.length; i++) {
				fileNameStr += "\'";
			    fileNameStr += fileNameArr[i];
			    fileNameStr += "\'";
			    if(fileNameArr.length > i+1) {
			    	fileNameStr += ", ";
			    }
			}				
			System.out.println(" fileNamestr : " + fileNameStr);
			exerciseFileService.delete(fileNameStr, id);	
		}else {
			exerciseFileService.delete(id);
		}
		
		
//		for (String fileName : fileNames) {
//			ExerciseFile exfile = new ExerciseFile(fileName, id);
//			exerciseFileService.delete(exfile);
//		}
//		System.out.println("fileNameArr to string : " + Arrays.toString(fileNameArr));
//		System.out.println(" fileNameArr:" + fileNameArr[0]);
//		if()
//		String 
//		for (String item:fileNameArr) {
//			item 
//		}
		
		
		
		
		//첨부파일 수정
		//글 수정시 업로드된 파일 가져오기
		String fs = File.separator; //파일 구분기호
		
		Collection<Part> fileParts = request.getParts(); 
		for (Part p : fileParts) {
			
			
			if(p.getName().equals("file") && !p.getSubmittedFileName().equals("")) {
				Part filePart = p;
				String fileName = filePart.getSubmittedFileName(); //파일이름 가져오기
				
				//실제 서비스의 물리경로
				String pathTemp = request.getServletContext().getRealPath(fs);
				System.out.println("pathTemp : " + pathTemp);
				
				//업로드 경로생성
				String filePath = pathTemp + fs + "image" + fs +"exercise" +fs+  fileName;
				System.out.println("filePath : " + filePath);
				
				String filePath2 = fs + "image" + fs + "exercise";
				System.out.println(filePath);
				
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
				
				ExerciseFile exerciseFile = new ExerciseFile(fileName, filePath2, id);
				System.out.println(exerciseFile.toString());
				exerciseFileService.insert(exerciseFile);
			}
		}
		
		
		response.sendRedirect("detail?id=" + id);
	}
}
