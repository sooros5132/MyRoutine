package com.myroutine.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.NoticeView;
import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		NoticeService service = new NoticeService();
		Notice n = service.get(id);
		
		NoticeView nv = service.getView(id);
		
		Notice prev = service.getPrev(id);
		Notice next = service.getNext(id);

		
		request.setAttribute("n", n);
		request.setAttribute("nv", nv);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		Notice notice = new Notice(title, contents);
		notice.setId(id);
		
		NoticeService service= new NoticeService();
		service.update(notice);
		
		response.sendRedirect("detail?id="+id);
		
	}
	
	


}
