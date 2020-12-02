package com.myroutine.web.controller.admin.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.Member;
import com.myroutine.web.service.user.MemberService;

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int size = 20;
		String temp = request.getParameter("size");
		if( temp != null && temp != "")
			size = Integer.parseInt(temp);
		
		MemberService service = new MemberService();
		List<Member> memberList = service.getList(size);
		
		request.setAttribute("memberList", memberList);

		request.getRequestDispatcher("/admin/member/list.jsp").forward(request, response);
	}
	
}
