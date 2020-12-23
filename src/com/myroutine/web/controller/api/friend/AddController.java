package com.myroutine.web.controller.api.friend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.entity.user.friend.Friend;
import com.myroutine.web.service.user.friend.FriendService;

@WebServlet("/api/friend/add")
public class AddController extends HttpServlet{

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
		

		// DISCONNECT CHECK -----------------------------------------
		String memberId_ = request.getParameter("memberId");
		String otherMemberId_ = request.getParameter("otherMemberId");
		
		if( memberId_ == null || otherMemberId_ == null ||
			memberId_.equals("") || otherMemberId_.equals("")) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		int memberId = Integer.parseInt(memberId_);
		int otherMemberId = Integer.parseInt(otherMemberId_);
		if(	memberId == 0 || otherMemberId == 0 || 
			memberId == otherMemberId ) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		FriendService service = new FriendService();
		Friend friendCheck = service.get(memberId, otherMemberId);
		System.out.println(friendCheck);
		if( friendCheck == null || 
			friendCheck.getReceiver() != 0 ||
			friendCheck.getRequester() != 0 ) {
			out.print("{\"result\": \"exist\"}");
			return;
		}
		
		// GET ------------------------------------------------------
		int result = service.insert(memberId, otherMemberId, 2);

		
//		// JSON OUT -------------------------------------------------
		out.print("{");
		out.print("\"result\":\"sussess\",");
		out.print("\"datas\":[{");
		out.print("\"result\":" + result);
		out.print("}]");
		out.print("}");
	}
}
