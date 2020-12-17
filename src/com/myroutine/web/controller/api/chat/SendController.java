package com.myroutine.web.controller.api.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.chat.Chat;
import com.myroutine.web.service.TimeService;
import com.myroutine.web.service.user.chat.ChatService;

// == /api/chat/send?content=등록 테스트 메시지~&reg_member_id=449&requester=448
@WebServlet("/api/chat/send")
public class SendController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String contents = request.getParameter("content");
		String regMemberIdTemp = request.getParameter("memberId");
		String requesterTemp = request.getParameter("otherMemberId");

		// DISCONNECT CHECK -----------------------------------------
		if( regMemberIdTemp == null || requesterTemp == null || contents == null ||
			regMemberIdTemp.equals("")|| requesterTemp.equals("") || contents.equals("") ) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		// SETTING --------------------------------------------------
		int result = 0;

		int regMemberId = Integer.parseInt(regMemberIdTemp);
		int requester = Integer.parseInt(requesterTemp);
		ChatService service = new ChatService();
		List<String> results = new ArrayList<String>();
		
//		List<Map<String, String>> list = new ArrayList<Map<String,String>>(); 
		
//		for(Map<String, String> chat : )
		
		// UPDATE --------------------------------------------
		Chat chat = new Chat(regMemberId, requester, contents);
		System.out.println(chat.toString());
		result = service.send(chat);

		// RESULT --------------------------------------------
		if( result == 0 ) {
			out.print("{\"result\": \"fail\"}");
			out.close();
			return;
		}
		out.print("{\"result\":\"sussess\", \"datas\":[{\"regDate\": \""+TimeService.getDate()+"\"}]}");
		out.close();
		
	}
	
}
