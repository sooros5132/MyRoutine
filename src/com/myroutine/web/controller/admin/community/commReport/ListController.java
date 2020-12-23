package com.myroutine.web.controller.admin.community.commReport;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.CommunityReport;
import com.myroutine.web.service.CommunityService;

@WebServlet("/admin/community/report/comment/list")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		CommunityService service = new CommunityService();
		List<CommunityReport> list= service.getCommentReportList();
		
		
		request.setAttribute("list", list);
		System.out.println(list);
		request.getRequestDispatcher("/admin/community/report/comment/list.jsp").forward(request, response);
	}

}
