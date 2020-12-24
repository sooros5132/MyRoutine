package com.myroutine.web.controller.admin.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.CommunityComment;
import com.myroutine.web.dao.entity.CommunityFile;
import com.myroutine.web.service.CommentService;
import com.myroutine.web.service.CommunityService;

@WebServlet("/admin/community/del")
public class DeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id =Integer.parseInt(request.getParameter("id"));
		CommunityService service = new CommunityService();
		CommentService cmtService = new CommentService();
		
		
		//파일있는지 검사 후 삭제
		//service.getFileList(id);
		int fCount =0;
		List<CommunityFile> fids = service.getTotalFileList(id);
		
		for(CommunityFile t:fids) {
			 service.fileDelete(t.getId());
			 fCount++;
		}
		
		System.out.println("-======total=========="+fids);
		
		
		//댓글있는지 검사 후 삭제 
		int cmtCount=0;
		List<CommunityComment> cmtIds  = cmtService.getTotalCmtList(id);
		for(CommunityComment t:cmtIds) {
			service.fileDelete(t.getId());
			cmtService.delete(t.getId());
			cmtCount++;
		}
		System.out.println("-======cnt=========="+cmtIds);
		
	
		if(fCount > 0 || cmtCount > 0)
			service.delete(id);
		
		response.sendRedirect("/admin/community/list");
		
	}
}
