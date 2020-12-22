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
import com.myroutine.web.service.user.friend.FriendService;

@WebServlet("/api/friend/list")
public class ListController extends HttpServlet {

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
		String reqIdCheck = request.getParameter("reqId");
		
		if( reqIdCheck == null || reqIdCheck.equals("") ) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		// SETTING --------------------------------------------------
		int result = 0;
		int reqId = Integer.parseInt(reqIdCheck);
		
		String temp = request.getParameter("state");
		int state = 0;
		if( temp != null && !temp.equals("") ) {
			state = Integer.parseInt(temp);
		}
		
		
		// GET ------------------------------------------------------
		FriendService service = new FriendService();
		List<FriendView> list = service.getViewList(reqId, state);
		System.out.println(list);
		if( list.isEmpty() ) {
			out.print("{\"result\": \"fail\"}");
			out.close();
			return;
		}
		
		// OUT SETTING -------------------------------------------------
		List<String> results = new ArrayList<String>();
		for(FriendView f : list) {
			
			String jsonTemp = String.format(
				"\"id\":%d,\"nickname\":\"%s\",\"state\":\"%s\"",
				f.getId(), f.getNickname(), f.getState());
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
