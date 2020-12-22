package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.service.admin.exercise.ExerciseService;


@WebServlet("/admin/exercise/edit")
public class EditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ExerciseService service = new ExerciseService();
		
		Exercise ex = service.get(id);
		
		request.setAttribute("ex", ex);
		request.getRequestDispatcher("/admin/exercise/edit.jsp").forward(request, response);
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String des = request.getParameter("des");
		String rec = request.getParameter("rec");
		String div1 = request.getParameter("div1");
		String[] div2_ = null;
		String[] files_ = request.getParameterValues("file");
		
		System.out.println(name);
		
		if(div1.equals("re")) {
			div1 ="재활운동";
			div2_ = request.getParameterValues("re-list");
			
		}else if(div1.equals("ex")) {
			div1 ="일반운동";
			div2_ = request.getParameterValues("ex-list");
		}
		
		
		String div2 =  Arrays.toString(div2_);
		div2 = div2.substring(1,div2.length()-1);
		System.out.println("1:" + div2);
		
		String files =Arrays.toString(files_);
		if(files == null) {
			
		}else {
			files = files.substring(1,files.length()-1);
		}
		
		Exercise ex = new Exercise(name, des, rec, div1, div2, files);
		ExerciseService service = new ExerciseService();
		service.update(ex);
	}
}
