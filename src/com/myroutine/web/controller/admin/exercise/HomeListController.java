package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.ExerciseListView;
import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBackup;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;
import com.myroutine.web.service.admin.exercise.ExerciseFileService;
import com.myroutine.web.service.admin.exercise.ExerciseService;
import com.myroutine.web.service.admin.exercise.ExerciseServiceBackup;
@WebServlet("/admin/exercise/homelist")
public class HomeListController extends HttpServlet{
	
	 
	//운동페이지 name 을 기준으로 페이지 띄우지?
	//name 하나만 받는거 get으로 받을거야
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] parts = req.getParameterValues("part");
		String option = req.getParameter("option");
		ExerciseService service = new ExerciseService();
		List<ExerciseListView> list =null;

		if (parts == null) {
			 list = service.getHomeListView();
			req.setAttribute("list", list);
		} else if (parts != null && !parts.equals("")) {
//			for (int i = 0; i < parts.length; i++)
//				System.out.println(parts[i]);
			if(option.equals("and")) {
				 list = service.getAndHomeListView(parts);
			}
			else if(option.equals("option")) {
				 list = service.getOrHomeListView(parts);
			}
			System.out.println(list);
			req.setAttribute("list", list);
		}
		
		req.getRequestDispatcher("/admin/exercise/homelist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("포스트");
	}


	
}
