package com.myroutine.web.controller.api.friend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.service.user.friend.FriendService;

@WebServlet("/api/friend/reject")
public class RejectController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		

		// SETTING ---------------------------------------------------
		String memberId_ = request.getParameter("memberId");
		String otherMemberId_ = request.getParameter("otherMemberId");
		
		if( memberId_ == null || otherMemberId_ == null ||
			memberId_.equals("") || otherMemberId_.equals("")) {
			response.getWriter().print("{\"result\": \"fail\"}");
			return;
		}
		
		int memberId = Integer.parseInt(memberId_);
		int otherMemberId = Integer.parseInt(otherMemberId_);

		// GET ------------------------------------------------------
		int result = 0;
		FriendService service = new FriendService();
		result = service.delete(memberId, otherMemberId);
		
		// JSON OUT -------------------------------------------------
		PrintWriter out = response.getWriter();
		out.print("{");
		out.print("\"result\":\"sussess\",");
		out.print("\"datas\":[{");
		out.print("\"result\":" + result);
		out.print("}]");
		out.print("}");
		
	}
}
