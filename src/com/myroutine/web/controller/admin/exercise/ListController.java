package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
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

@WebServlet("/admin/exercise/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] parts = req.getParameterValues("part");
		String option = req.getParameter("option");
		ExerciseService service = new ExerciseService();
		List<ExerciseListView> list =null;

//		ExerciseFileService fileService = new ExerciseFileService();
		System.out.println("두겟");
		System.out.println(option);
//		if (option.equals("and")) {
//			if (parts == null) {
//				List<ExerciseListView> list = service.getListView();
//				req.setAttribute("list", list);
//			} else if (parts != null || !parts.equals("")) {
//				for (int i = 0; i < parts.length; i++)
//					System.out.println(parts[i]);
//				List<ExerciseListView> list = service.getAndListView(parts);
//				req.setAttribute("list", list);
//			}
//		}
//		else if(option.equals("or")){
//			if (parts == null) {
//				List<ExerciseListView> list = service.getListView();
//				req.setAttribute("list", list);
//			} else if (parts != null || !parts.equals("")) {
//				for (int i = 0; i < parts.length; i++)
//					System.out.println(parts[i]);
//				List<ExerciseListView> list = service.getOrListView(parts);
//				req.setAttribute("list", list);
//			}
//		}
//		else {
//				List<ExerciseListView> list = service.getListView();
//				req.setAttribute("list", list);
//			}
		
		if (parts == null) {
			 list = service.getListView();
			req.setAttribute("list", list);
		} else if (parts != null && !parts.equals("")) {
//			for (int i = 0; i < parts.length; i++)
//				System.out.println(parts[i]);
			if(option.equals("and")) {
				 list = service.getAndListView(parts);
			}
			else if(option.equals("option")) {
				 list = service.getOrListView(parts);
			}
			System.out.println(list);
			req.setAttribute("list", list);
		}
		
//		List<Exercise> list = service.getList(part);
//		List<ExerciseFile> ef = fileService.getFileList(part);

		req.getRequestDispatcher("/admin/exercise/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("포스트");
	}

}
