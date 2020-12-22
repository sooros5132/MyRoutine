package com.myroutine.web.controller.api.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.chat.Chat;
import com.myroutine.web.service.TimeService;
import com.myroutine.web.service.user.chat.ChatService;

@WebServlet("/api/chat/delete")
public class DelController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");

		String chatId_ = request.getParameter("chatId");

		// DISCONNECT CHECK -----------------------------------------
		if( chatId_ == null || chatId_.equals("") ) {
			response.getWriter().print("{\"result\": \"fail\"}");
			return;
		}

		// SETTING --------------------------------------------------
		int result = 0;
		int chatId = 0;
		chatId = Integer.parseInt(chatId_);
		
		if( chatId == 0 ) {
			response.getWriter().print("{\"result\": \"fail\"}");
			return;
		}
		ChatService service = new ChatService();
		
		// UPDATE --------------------------------------------
		result = service.deleteMsg(chatId, "DELETE_DATE", "DELETE");

		// RESULT --------------------------------------------
		PrintWriter out = response.getWriter();
		if( result == 0 ) {
			out.print("{\"result\": \"fail\"}");
			out.close();
			return;
		}
		out.print("{\"result\":\"sussess\", \"datas\":[{\"id\":"+chatId+",\"deleteDate\": \""+TimeService.getFullDate()+"\"}]}");
		out.close();
		
	}
	
}
