package com.myroutine.web.controller.admin.member;

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

@WebServlet("/admin/member/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int size = 20;
		int page = 1;
		int rule = 0;
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		String searchOption = request.getParameter("search_option");
		String temp;
		
		temp = request.getParameter("size");
		if( IsNumberService.isInteger(temp) )
			size = Integer.parseInt(temp);

		temp = request.getParameter("page");
		if( IsNumberService.isInteger(temp) )
			page = Integer.parseInt(temp);

		temp = request.getParameter("rule");
		if( IsNumberService.isInteger(temp) )
			rule = Integer.parseInt(temp);

		if( key == null )
			key = "";
		if( value == null )
			value = "";
		if( searchOption == null )
			searchOption = "";
		
		if(size < 1)
			size = 20;
		if(size > 100)
			size = 20;
		if(page < 1)
			page = 1;
		if( rule < 0 && 9 < rule)
			rule = 0;

		int start = size * page;
		int end = size * page + size;
		
		MemberService service = new MemberService();
		List<Member> memberList = service.getList(page, size, rule, key, value, searchOption);
		int totalCount = service.totalCount();
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("size", size);
		request.setAttribute("page", page);
		request.setAttribute("key", key);
		request.setAttribute("value", value);
		request.setAttribute("rule", rule);
		request.setAttribute("search_option", searchOption);
		request.setAttribute("totalCount", totalCount);
		

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
}
