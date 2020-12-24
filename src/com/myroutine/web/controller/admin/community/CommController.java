package com.myroutine.web.controller.admin.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.myroutine.web.dao.entity.CommunityComment;
import com.myroutine.web.service.CommentService;

@WebServlet("/admin/community/commentList")
public class CommController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");      
		response.setContentType("text/json; charset=UTF-8");
		int	id = 0;
		
		if(!request.getParameter("communityId").equals(null)) {
			
			id = Integer.parseInt(request.getParameter("communityId")) ;

			CommentService cService = new CommentService();
			List<CommunityComment> list = cService.getList(id);
			
			String s = new Gson().toJson(list);
			response.getWriter().println(s);
		}
	}
 
}
