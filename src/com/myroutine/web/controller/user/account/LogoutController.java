package com.myroutine.web.controller.user.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/account/logout")
public class LogoutController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();

//		session.setAttribute("email", "");
//		session.setAttribute("memberId", "");
//		session.setAttribute("rule", "");
		
		session.invalidate();
		
		String referer = request.getHeader("referer");
		System.out.println(referer);
		if(referer != null && !referer.equals(""))
			response.sendRedirect(referer);
	}
	
}
