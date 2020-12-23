package com.myroutine.web.controller.admin.complain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.ComplainService;

@WebServlet("/admin/complain/fileDel")
public class FileDeleteController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//�����͹޾Ƽ� ���������� ��������������
		int id=Integer.parseInt(request.getParameter("id"));

		ComplainService service = new ComplainService();
		service.fileDelete(id);

		//detail������	
		response.sendRedirect("/admin/complain/edit?id="+id);	
	}
	
}
