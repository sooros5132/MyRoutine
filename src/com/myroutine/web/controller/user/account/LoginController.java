package com.myroutine.web.controller.user.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.user.member.MemberService;

@WebServlet("/account/login")
public class LoginController extends HttpServlet {

	private MemberService service;
	
	public LoginController() {
		service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnURL = request.getParameter("return-url");
		String referer = "";
		
		try {
			referer = new URI(request.getHeader("referer")).getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		if( returnURL != null && !returnURL.equals("") ) {
			request.setAttribute("returnUrl", returnURL);
		} else if ( !referer.equals("")) {
			request.setAttribute("returnUrl", referer);
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String returnURL = request.getParameter("return-url");
//		System.out.printf("email: %s, pwd: %s\n", email, pwd);
		HttpSession session = request.getSession();
		

		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		
		// DISCONNECT CHECK -----------------------------------------
		if(email == null || pwd == null ||
		   email.equals("") || pwd.equals("")) {
			response.getWriter().print("{\"result\": \"fail\"}");
			return;
		}
		
		// GET ------------------------------------------------------
		MemberService service = new MemberService();
		Member m = service.get("email", email);
		
		// CHECK ----------------------------------------------------
		PrintWriter out = response.getWriter();
		if( m != null && !email.equals("") && pwd.equals(m.getPwd())) {
			session.setAttribute("email", email);
			session.setAttribute("memberId", m.getId());
			session.setAttribute("rule", m.getRule());

//			if( returnURL != null && !returnURL.equals("") ) {
//				response.sendRedirect(returnURL);
//				return;
//			} else {
//				response.sendRedirect("/");	
//			}
			out.print("{\"result\": \"sussess\"}");
			out.close();
		} else {
			out.print("{\"result\": \"fail\"}");
			out.close();
			return;
		}
	}
}
