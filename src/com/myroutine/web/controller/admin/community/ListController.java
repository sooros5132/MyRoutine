package com.myroutine.web.controller.admin.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.CommunityCategory;
import com.myroutine.web.dao.entity.CommunityView;
import com.myroutine.web.service.CommunityService;

@WebServlet("/admin/community/list")
public class ListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");      
//        response.setContentType("application/json; charset=UTF-8");
        response.setContentType("text/json; charset=UTF-8");
        
		int page = 1;
		int categoryId = 0;
		String value = "";

		
		if(request.getParameter("page")!=null)
			page =Integer.parseInt(request.getParameter("page")) ;
		
		if(request.getParameter("categoryId")!=null)
			categoryId= Integer.parseInt(request.getParameter("categoryId"));
		
		if(request.getParameter("value")!=null)
			value =request.getParameter("value"); 
		 
		System.out.println(categoryId);
				
		CommunityService service = new CommunityService(); 
		List<CommunityView> list = service.getViewList(page, categoryId, value);
		List<CommunityCategory> cList = service.getCategoryList();
		//카테고리 첫번째꺼 넣기.
		//CommunityCategory firstCategroy =new CommunityCategory(0,"=전체게시판=");
		//cList.add(firstCategroy);
		
		//페이지처리 리스트 토탈 값 가지고 오기
		int total = service.getTotal(categoryId);
		
		//	한페이지에 10개씩보여주고 5까지만 나오게
		int groupMax = 5;
		int group = (total % 10) > 0 ?  (total / 10) +1 : (total / 10);
		
		//이전페이지 
		int prevPage = (page-1)==0 ? 1 : page-1;
		
		//다음페이지
		int nextPage = (page == group) ? group: page+1;

		//
		if(group > groupMax)
			group = groupMax;
		
		if(total==0)
			group = 5;
				
		request.setAttribute("categoryId", categoryId);
		request.setAttribute("total", total );
		request.setAttribute("prevPage", prevPage );
		request.setAttribute("nextPage", nextPage );
		request.setAttribute("group", group );
		request.setAttribute("cList", cList);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/community/list.jsp").forward(request, response);


//		String json = new Gson().toJson(list);			
//		response.getWriter().println(json);

		
	}
}
