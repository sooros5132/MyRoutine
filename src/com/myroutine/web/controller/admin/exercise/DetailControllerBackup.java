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
//	운동페이지 name 을 기준으로 페이지 띄우지? 
//	name 하나만 받는거 get으로 받을거야
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
