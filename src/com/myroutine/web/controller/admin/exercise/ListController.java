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
	
	 
	//������� name �� �������� ������ �����? 
	//name �ϳ��� �޴°� get���� �����ž�
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
