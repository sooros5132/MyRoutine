package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.Exercise;
import com.myroutine.web.entity.admin.exercise.BodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.entity.admin.exercise.File;
import com.myroutine.web.service.admin.exercise.ExerciseService;

@WebServlet("/admin/exercise/add")
public class AddController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String engName = request.getParameter("eng-name");
		String recommand = request.getParameter("recommand");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		
		String[] bodyPart_ = null;
		if(categoryId ==1) {
			bodyPart_ = request.getParameterValues("body-part-re");
		}else if(categoryId ==2) {
			bodyPart_ = request.getParameterValues("body-part-ex");
		}
		
		int[] bodyPart = new int[bodyPart_.length];
		
		for(int i=0;i<bodyPart_.length; i++){ 
//			bodyPart[i] = Integer.parseInt(bodyPart_[i]);
		}
		
		
		
		int memberId  = 1; //임시 고정 //String memberId = request.getParameter("memberId");
		int bodyPart = 1;
		
		String[] files= request.getParameterValues("file");
		
		
		ExerciseService exService = new ExerciseService();
		Exercise ex = new Exercise(name, contents, engName, recommand, memberId, categoryId );
		
	
		ExerciseBodyPart ebp2 = new ExerciseBodyPart(bodyPart, id);
		ExerciseBodyPart ebp2 = new ExerciseBodyPart(bodyPart, id);
		
		List<ExerciseBodyPart> ebps = new ArrayList<ExerciseBodyPart>();
		
		ExerciseBodyPart ebp = new ExerciseBodyPart(bodyPart, id);
		ebps.add(ebp);
		
		ex.bodyPartInsert(ebps);
		
		exService.insert(ex);
		
		
		
//CVS	
//String files = Arrays.toString(files_);
//files = files.substring(1,files.length()-1);
		

		
		//목록페이지로 이동
//		response.sendRedirect("list");
	}
}