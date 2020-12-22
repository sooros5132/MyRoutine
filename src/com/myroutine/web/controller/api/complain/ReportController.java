package com.myroutine.web.controller.api.complain;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.ComplainReport;
import com.myroutine.web.service.ComplainService;


@WebServlet("/api/complain/report")
public class ReportController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)throws ServletException, IOException {
		String contents = request.getParameter("contents");
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		int complainId = Integer.parseInt(request.getParameter("complainId"));
		String nickname ="";
		Date date = new Date();
		
		ComplainService service = new ComplainService();
		ComplainReport complainReport = new ComplainReport(0,memberId,complainId,contents, date,nickname);
		
		int result = service.reportInsert(complainReport);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식은...데이터 
//		String dataJson = request.getReader().lines().collect(Collectors.joining());
	
	}
	


}
