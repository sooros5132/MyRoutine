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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("昏力牧飘费");
		
		
		// 款悼格废昏力
		ExerciseBodyPartService ebpService = new ExerciseBodyPartService();
		ebpService.delete(id);
		
		
		// 梅何颇老 昏力
		ExerciseFileService exFileService = new ExerciseFileService();
		exFileService.deleteAll(id);
				
		// 款悼昏力
		ExerciseService exService = new ExerciseService();
		exService.delete(id);


		
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}

}
