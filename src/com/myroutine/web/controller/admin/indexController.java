package com.myroutine.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.service.CommunityService;
import com.myroutine.web.service.ComplainService;
import com.myroutine.web.service.admin.exercise.ExerciseService;
import com.myroutine.web.service.admin.member.MemberService;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/")
public class indexController extends  HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ExerciseService exService = new ExerciseService();
		MemberService memService = new MemberService();
		CommunityService comService = new CommunityService();
		ComplainService compService = new ComplainService();
		NoticeService nService = new NoticeService();
		
		int exerciseCount = exService.getCount();
		int memberCount = memService.totalCount();
		int communityCount = comService.getTotal(0);
		int complainCount = compService.getTotal(0);
		int noticeCount = nService.getCount2();
		
		List<Notice> noticeList = nService. getList("TITLE","",1,10);
		List<Community> communityList = comService. getList(1);
		
//		System.out.println(comunityList);
//		System.out.println(noticeList);
		
		req.setAttribute("exerciseCount", exerciseCount);
		req.setAttribute("memberCount", memberCount);
		req.setAttribute("communityCount", communityCount);
		req.setAttribute("complainCount", complainCount);
		req.setAttribute("noticeCount", noticeCount);
		req.setAttribute("noticeList", noticeList);
		req.setAttribute("communityList", communityList);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
}
