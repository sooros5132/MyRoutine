package com.myroutine.web.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.NoticeView;
import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.service.admin.notice.NoticeFileService;
import com.myroutine.web.service.admin.notice.NoticeService;

@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] dels = request.getParameterValues("del-id");
		
		
		int[] ids = new int[dels.length]; //담을 배열 공간 생성
		for(int i=0; i<ids.length;i++) {
			ids[i] =  Integer.parseInt(dels[i]);
			System.out.println(ids[i]);
		}
		
		NoticeFileService nfservice = new NoticeFileService();
		int result2 = nfservice.deleteAllnf(ids);
		
		NoticeService service= new NoticeService();
		int result= service.deleteAll(ids);
		
	    response.sendRedirect("list");
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		
		String field_ = request.getParameter("f");
	    String query_ = request.getParameter("q");
		
	    String field = "title";
	    if(field_ != null && !field_.equals(""))
	    	field = field_;
	    
	    String query = "";
	    if(query_!=null&& !query_.equals("") )
	    	query = query_;
	    
	    
		String p_ = request.getParameter("p");
		
		int p =1;
		
		if(p_!=null && !p_.equals(""))
	         p = Integer.parseInt(p_);		
		
		NoticeService service = new NoticeService();
		List<Notice> list= service.getList(field,query,p,10);
		
		
		int count = service.getCount();
		
		
		
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
