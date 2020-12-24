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
		//���̵� ����Ҷ��� �ʿ�
		CommentService cService = new CommentService();
		int	id = Integer.parseInt(request.getParameter("id")) ;
		
		if(request.getMethod().equals("POST")) {
			//��� ���������� �������..������ �ٽÿ���..

			int memberId= Integer.parseInt(request.getParameter("memberId"));
			int communityId= Integer.parseInt(request.getParameter("communityId"));
			String contents= request.getParameter("contents");
			String String= request.getParameter("String");
			
			if(!request.getParameter("contents").equals(null) && !request.getParameter("contents").equals("")) {
				CommunityComment comment = new CommunityComment(0,memberId,String, communityId, new Date() ,contents);
				cService.insert(comment);
			}
			
		}

		CommunityService service = new CommunityService();
		Community m = service.getDetail(id);
		
//		TODO �ۼ��ڿ� �α����� ����� ��ġ�Ҷ��� HIT�� �ø��� �ʾƾ��Ѵ�..
		
		//��ȸ�� �ø���
		int hit = service.hitUp(id);
		System.out.println("id : "+id);		
		
		List<CommunityComment> list = cService.getList(id);
		request.setAttribute("m", m);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/community/detail.jsp").forward(request, response);
	
	}	
	//�ӽ��ּ�
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//���������� ��� �޾ƿ���
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
//		//��۵���Ҷ� ����
//		String	id = request.getParameter("id") ;
//		String comments= request.getParameter("comments");
//
//		CommentService service = new CommentService();
//		Comment comment = new Comment(id,comments);
//		
//		service = new CommentService();
//		service.insert(comment);
//		��۸���Ʈ �ٽù޾ƿ;���....ȭ�鿡�� �� �߰��� �ٽ� �ǵ�����. ȭ��޻��Ÿ��� �ʰ�
//		response.sendRedirect("communityDetail?id="+id);
//	}
}
