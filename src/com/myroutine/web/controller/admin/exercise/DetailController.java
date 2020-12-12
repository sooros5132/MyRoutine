package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.service.admin.exercise.ExerciseService;

@WebServlet("/admin/exercise/detail")
public class DetailController extends HttpServlet{
//	운동페이지 name 을 기준으로 페이지 띄우지? 
//	name 하나만 받는거 get으로 받을거야
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ExerciseService service = new ExerciseService();
		Exercise ex =service.get(id);
		
		System.out.println(id);
		req.setAttribute("ex", ex);
		
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}
}
