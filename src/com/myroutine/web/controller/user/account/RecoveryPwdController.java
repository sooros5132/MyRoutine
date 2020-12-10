package com.myroutine.web.controller.user.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account/recoveryPwd")
public class RecoveryPwdController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setAttribute("putStatus", putStatus);
		request.getRequestDispatcher("recoveryPwd.jsp").forward(request, response);
		
	}
	
}
