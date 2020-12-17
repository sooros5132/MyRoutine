package com.myroutine.web.controller.api.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.user.member.MemberService;


@WebServlet("/api/account/dupCheck")
public class DupCheckController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		int result = 0;
		
		// 값 안오면 바로 리턴
		if( key == null || key.equals("") ||
			value == null || value.equals("")) {
			out.printf("{\"result\":%d}", result);
			return;
		}

		System.out.println("controller.user.account.MemberDupCheckController -> service() 에서 메시지\n 테스트 끝나고 service메소드 -> doPost로 바꾸기");
		
		MemberService service = new MemberService();
		result = service.dupCheck(key, value);

		out.printf("{\"result\":%d}", result);
		
	}
	
}
