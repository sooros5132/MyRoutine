package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.exercise.ExerciseFile;
import com.myroutine.web.service.admin.exercise.ExerciseBodyPartService;
import com.myroutine.web.service.admin.exercise.ExerciseFileService;
import com.myroutine.web.service.admin.exercise.ExerciseService;

@WebServlet("/admin/exercise/delete")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("������Ʈ��");
		
	
		ExerciseBodyPartService ebpService = new ExerciseBodyPartService();
		ebpService.delete(id);
		
		
	
		ExerciseFileService exFileService = new ExerciseFileService();
		exFileService.deleteAll(id);
				
	
		ExerciseService exService = new ExerciseService();
		exService.delete(id);


		
		response.sendRedirect("list");
	}

}
