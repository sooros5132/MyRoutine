package com.myroutine.web.controller.api.community;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.CommunityReport;
import com.myroutine.web.service.CommunityService;


@WebServlet("/api/community/report")
public class ReportController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)throws ServletException, IOException {
		String contents = request.getParameter("contents");
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		int communityId = Integer.parseInt(request.getParameter("communityId"));
		String nickname ="";
		Date date = new Date();
		
		CommunityService service = new CommunityService();
		CommunityReport communityReport = new CommunityReport(0,memberId,communityId,contents, date,nickname);
		
		int result = service.reportInsert(communityReport);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식은...데이터 
//		String dataJson = request.getReader().lines().collect(Collectors.joining());
	
	}
	


}
