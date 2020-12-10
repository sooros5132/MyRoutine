package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.exercise.ExerciseBackup;
import com.myroutine.web.service.admin.exercise.ExerciseServiceBackup;
@WebServlet("/admin/exercise/detailBackup")
public class DetailControllerBackup extends HttpServlet{
//	������� name �� �������� ������ �����? 
//	name �ϳ��� �޴°� get���� �����ž�
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		ExerciseServiceBackup service = new ExerciseServiceBackup();
		ExerciseBackup ex =service.get(name);
		
		System.out.println(name);
		req.setAttribute("ex", ex);
		
		req.getRequestDispatcher("detailBackup.jsp").forward(req, resp);
	}
	
}
