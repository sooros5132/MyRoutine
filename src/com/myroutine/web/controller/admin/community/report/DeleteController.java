package com.myroutine.web.controller.admin.community.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.ComplainService;

@WebServlet("/admin/community/reportDel")
public class DeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ComplainService service = new ComplainService();
		service.delete(id);
		
		response.sendRedirect("/admin/complain/list");
		
	}
}
