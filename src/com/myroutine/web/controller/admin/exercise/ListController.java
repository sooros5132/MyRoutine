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
@WebServlet("/admin/exercise/list")
public class ListController extends HttpServlet{
	
	 
	//운동페이지 name 을 기준으로 페이지 띄우지?
	//name 하나만 받는거 get으로 받을거야
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] parts = req.getParameterValues("part");
		
		ExerciseService service = new ExerciseService();
//		ExerciseFileService fileService = new ExerciseFileService();
		System.out.println("두겟");
		
		
		if(parts==null) {
			List<ExerciseListView> list = service.getListView();
			req.setAttribute("list", list);
		}
		else if(parts!=null || !parts.equals("")) {
			for(int i=0; i<parts.length;i++)
				System.out.println(parts[i]);
			List<ExerciseListView> list = service.getListView(parts);
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
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ExerciseService service = new ExerciseService();
//		List<Exercise> list = service.getList();
//
//		System.out.println("=====리스트 컨트롤러");
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/admin/exercise/list.jsp").forward(req, resp);
//		super.service(req, resp);
//	}

	
}
