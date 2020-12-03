package com.myroutine.web.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		NoticeService service = new NoticeService();
		List<Notice> list= service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
