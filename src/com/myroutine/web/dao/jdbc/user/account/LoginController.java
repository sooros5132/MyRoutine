package com.myroutine.web.dao.jdbc.user.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.user.member.MemberService;

@WebServlet("/api/account/login")
public class LoginController extends HttpServlet{

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
			out.print("{\"result\": \"sussess\", \"datas\":[{\"memberId\": "+m.getId()+"}]}");
			out.close();
		} else {
			out.print("{\"result\": \"fail\"}");
			out.close();
			return;
		}
	}
}
