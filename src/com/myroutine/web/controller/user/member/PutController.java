package com.myroutine.web.controller.user.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.Member;
import com.myroutine.web.service.user.MemberService;

@WebServlet("/account/put")
public class PutController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// null은 없고 ""만 검사하게
		String email = request.getParameter("userEmail");
		String name = request.getParameter("userName");
		String nickname = request.getParameter("userNickName");
		String pwd = request.getParameter("userPwd");
		boolean putStatus = false;
		System.out.printf("com.myroutine.web.controller.user.member.PutController.java 에서의 로그\n%s, %s, %s, %s\n", email, name, nickname, pwd);
		if( email != null && name != null &&
			nickname != null && pwd != null &&
			!email.equals("") && !name.equals("") &&
			!nickname.equals("") && !pwd.equals("") ) {

			MemberService service = new MemberService();
			Member m = new Member(email, name, nickname, pwd);
			
			putStatus = service.putMember(m);
		} else {
			putStatus = false;
		}
		request.setAttribute("putStatus", putStatus);
		request.getRequestDispatcher("put.jsp").forward(request, response);
	}
	
}
