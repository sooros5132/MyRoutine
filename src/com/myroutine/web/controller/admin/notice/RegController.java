package com.myroutine.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/reg")
public class RegController extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.getRequestDispatcher("reg.jsp").forward(request, response);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String title = request.getParameter("title");
	   String content = request.getParameter("content");
	   Notice notice = new Notice(title,content);
	   
	   //�������Է�
	   NoticeService service = new NoticeService();
	   service.insert(notice);
	   
	   //������ �̵�
	   response.sendRedirect("list");
	
	}

}
