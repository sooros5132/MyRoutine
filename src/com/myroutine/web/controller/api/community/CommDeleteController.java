package com.myroutine.web.controller.api.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.CommentService;

@WebServlet("/api/community/commentDel")
public class CommDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int detailId = Integer.parseInt(request.getParameter("detailId"));
		CommentService service = new CommentService();
		service.delete(id);
		
		response.sendRedirect("/admin/community/detail?id="+detailId);
	}
}
