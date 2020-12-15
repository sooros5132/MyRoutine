package com.myroutine.web.controller.user.account;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.Member;
import com.myroutine.web.service.user.member.MemberService;


@WebServlet("/account/signUp")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// GET이면 회원가입 페이지 -> forward signUp.jsp 
		request.getRequestDispatcher("signUp.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// POST면 가입받기 -> forward put.jsp
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		
		int result = 0;
		
//		System.out.printf("com.myroutine.web.controller.user.account."
//						+ "SignUpController.java 에서의 로그\n%s, %s, %s, %s\n",
//							email, name, nickname, pwd);
		
		if( email != null && name != null &&
			nickname != null && pwd != null &&
			!email.equals("") && !name.equals("") &&
			!nickname.equals("") && !pwd.equals("") ) {

			MemberService service = new MemberService();
			Member m = new Member(email, name, nickname, pwd);
			
			
			// ===================================
			// 시퀸스 배우기 전 테스트용 랜덤 아이디
//			Random rand = new Random();
//			int num = rand.nextInt(99900)+21;
//			m.setId(num);
			// ===================================
			
			result = service.put(m);
			request.setAttribute("m", m);
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("put.jsp").forward(request, response);
	}
}
