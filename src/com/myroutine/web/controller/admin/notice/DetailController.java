package com.myroutine.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/detail")
public class DetailController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		NoticeService service = new NoticeService();
		Notice n = service.get(id);
		
		request.setAttribute("n", n);
		request.getRequestDispatcher("detail.jsp").forward(request, response);

	}

}
