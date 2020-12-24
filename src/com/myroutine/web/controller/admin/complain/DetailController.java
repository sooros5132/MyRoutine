package com.myroutine.web.controller.admin.complain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.Complain;
import com.myroutine.web.service.CommentService;
import com.myroutine.web.service.ComplainService;

@WebServlet("/admin/complain/detail")
public class DetailController extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���̵� ����Ҷ��� �ʿ�
		CommentService cService = new CommentService();
		int	id = Integer.parseInt(request.getParameter("id")) ;
		
		if(request.getMethod().equals("POST")) {

			int memberId= Integer.parseInt(request.getParameter("memberId"));
			int complainId= Integer.parseInt(request.getParameter("complainId"));
			String contents= request.getParameter("contents");
			String String= request.getParameter("String");
			
//			complainCommen comment = new complainComment(0,memberId,String, complainId, new Date() ,contents);
//			cService.insert(comment);
		}

		ComplainService service = new ComplainService();
		Complain m = service.getDetail(id);
		
//		TODO �ۼ��ڿ� �α����� ����� ��ġ�Ҷ��� HIT�� �ø��� �ʾƾ��Ѵ�..
		
		//��ȸ�� �ø���
//		int hit = service.hitUp(id);
		System.out.println("id : "+id);		
		

		request.setAttribute("m", m);

		request.getRequestDispatcher("/admin/complain/detail.jsp").forward(request, response);
	
	}	

}
