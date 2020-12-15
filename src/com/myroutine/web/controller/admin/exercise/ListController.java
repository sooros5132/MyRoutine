package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBackup;
import com.myroutine.web.service.admin.exercise.ExerciseService;
import com.myroutine.web.service.admin.exercise.ExerciseServiceBackup;
@WebServlet("/admin/exercise/list")
public class ListController extends HttpServlet{
	
	 
	//운동페이지 name 을 기준으로 페이지 띄우지? 
	//name 하나만 받는거 get으로 받을거야
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = req.getParameter("name");
//		ExerciseService service = new ExerciseService();
//		List<Exercise> list = service.getList();
//	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ExerciseService service = new ExerciseService();
		List<Exercise> list = service.getList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("/admin/exercise/list.jsp").forward(req, resp);
	}

	
}
