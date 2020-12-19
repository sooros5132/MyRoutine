package com.myroutine.web.controller.api.friend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.user.friend.FriendService;
import com.myroutine.web.service.user.member.MemberService;

@WebServlet("/api/friend/search")
public class SearchController extends HttpServlet {

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
		

		// SETTING ---------------------------------------------------
		int page = 1;
		int size = 20;
		int memberId = 0;

		String memberId_ = request.getParameter("memberId");
		String page_ = request.getParameter("page");
		String size_ = request.getParameter("size");
		
		if( memberId_ != null && page_ != null && size_ != null &&
			!memberId_.equals("") && !page_.equals("") && !size_.equals("")) {
			memberId = Integer.parseInt(memberId_);
			page = Integer.parseInt(page_);
			size = Integer.parseInt(size_);
		}
		String nickname = request.getParameter("nickname");

		// GET ------------------------------------------------------
		FriendService service = new FriendService();
		List<Member> list = service.getAddAbleMemberList(memberId, nickname, page, size);
		
		if( list.isEmpty() ) {
			out.print("{\"result\": \"empty\"}");
			out.close();
			return;
		}
		
		// OUT SETTING -------------------------------------------------
		List<String> results = new ArrayList<String>();
		for(Member m : list) {
			
			String jsonTemp = String.format(
					"\"id\":%d,\"nickname\":\"%s\"",
					m.getId(), m.getNickname());
			
			results.add(jsonTemp); 
		}
		
		// JSON OUT -------------------------------------------------
		out.print("{");
		out.print("\"result\":\"sussess\",");
		out.print("\"datas\":[{");
			out.print(String.join("},{",results));
			out.print("}]");
		out.print("}");
		
//		out.println(new Gson().toJson(list));
	}
	
}
