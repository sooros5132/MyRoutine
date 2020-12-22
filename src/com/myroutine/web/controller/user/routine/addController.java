package com.myroutine.web.controller.user.routine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.routine.Routine;
import com.myroutine.web.service.user.routine.RoutineService;


@WebServlet("/user/routine/add")
public class addController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id -> regMemId
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String exerciseContent = request.getParameter("exercise-contents");
		
		System.out.println(exerciseContent);
		
		RoutineService routineServie = new RoutineService();
		Routine routine = new Routine();
		
		routineServie.insert(routine);
		
		
		
		
	}
}
