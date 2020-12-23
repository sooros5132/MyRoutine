package com.myroutine.web.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.admin.notice.NoticeFileService;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/del")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		NoticeFileService nfservice = new NoticeFileService();
		int result2 = nfservice.deleteNf(id);
		
		NoticeService service = new NoticeService();
		int result = service.delete(id);
		
		//货肺款 其捞瘤 夸没
		response.sendRedirect("list");
	}
	

	
}
