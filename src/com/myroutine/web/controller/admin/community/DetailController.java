package com.myroutine.web.controller.admin.community;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.dao.entity.CommunityComment;
import com.myroutine.web.service.CommentService;
import com.myroutine.web.service.CommunityService;

@WebServlet("/admin/community/detail")
public class DetailController extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 등록할때도 필요
		CommentService cService = new CommentService();
		int	id = Integer.parseInt(request.getParameter("id")) ;
		
		if(request.getMethod().equals("POST")) {
			//댓글 저장했을때 쿼리등록..페이지 다시열기..

			int memberId= Integer.parseInt(request.getParameter("memberId"));
			int communityId= Integer.parseInt(request.getParameter("communityId"));
			String contents= request.getParameter("contents");
			String String= request.getParameter("String");
			
			CommunityComment comment = new CommunityComment(0,memberId,String, communityId, new Date() ,contents);
			cService.insert(comment);
		}

		CommunityService service = new CommunityService();
		Community m = service.getDetail(id);
		
//		TODO 작성자와 로그인한 사람이 일치할때는 HIT수 올리지 않아야한다..
		
		//조회수 올리기
		int hit = service.hitUp(id);
		System.out.println("id : "+id);		
		
		List<CommunityComment> list = cService.getList(id);
		request.setAttribute("m", m);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/community/detail.jsp").forward(request, response);
	
	}	
	//임시주석
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//상세페이지와 목록 받아오기
//		String	id = request.getParameter("id") ;
//		
//		CommunityService service = new CommunityService();
//		Community m = service.get(id);
//		
//		CommentService cService = new CommentService();
//		List<Comment> list = cService.getList(id);
//		
//		request.setAttribute("m", m);
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("/admin/community/communityDetail.jsp").forward(request, response);
//	}
//	
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//댓글등록할때 실행
//		String	id = request.getParameter("id") ;
//		String comments= request.getParameter("comments");
//
//		CommentService service = new CommentService();
//		Comment comment = new Comment(id,comments);
//		
//		service = new CommentService();
//		service.insert(comment);
//		댓글리스트 다시받아와야함....화면에서 글 추가후 다시 되돌리기. 화면꿈뻑거리지 않게
//		response.sendRedirect("communityDetail?id="+id);
//	}
}
