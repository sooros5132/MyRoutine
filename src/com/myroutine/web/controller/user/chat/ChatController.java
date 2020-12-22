package com.myroutine.web.controller.user.chat;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.IsNumberService;
import com.myroutine.web.service.admin.member.MemberService;

@WebServlet("/chat")
public class ChatController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/user/chat/chat.jsp").forward(request, response);
	}
	
}
