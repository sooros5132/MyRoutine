
package com.myroutine.web.controller.admin.exercise;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.ExerciseBodyPartView;
import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;
import com.myroutine.web.service.admin.exercise.ExerciseBodyPartService;
import com.myroutine.web.service.admin.exercise.ExerciseFileService;
import com.myroutine.web.service.admin.exercise.ExerciseService;

@WebServlet("/admin/exercise/detail")
public class DetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		ExerciseService service = new ExerciseService();
		ExerciseBodyPartService ebpService  = new ExerciseBodyPartService();
		ExerciseFileService fileService = new ExerciseFileService();
		
		Exercise ex =service.get(id);
		List<ExerciseBodyPartView> ebpv = ebpService.getViewBodyPartList(id);
		List<ExerciseFile> ef = fileService.getFileList(id);
		
		System.out.println("========디테일컨트롤러"+id);
		req.setAttribute("ex", ex);
		req.setAttribute("ebpv", ebpv);
		req.setAttribute("fileList", ef);
		System.out.println(ex);
		System.out.println(ebpv);
		System.out.println(ef);
		
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}
}
