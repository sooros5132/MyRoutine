package com.myroutine.web.controller.api.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.entity.user.chat.ChatFile;
import com.myroutine.web.service.user.chat.ChatFileService;
import com.myroutine.web.service.user.chat.ChatService;

// == /api/chat/get?memberId=449
@WebServlet("/api/chat/get")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSON SETTING ---------------------------------------------
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		

		// DISCONNECT CHECK -----------------------------------------
		String idCheck = request.getParameter("memberId");
		String otherIdCheck = request.getParameter("otherMemberId");
		
		if( idCheck == null || otherIdCheck == null ||
			idCheck.equals("") || otherIdCheck.equals("") ||
			idCheck.equals(otherIdCheck)) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		// SETTING --------------------------------------------------
		int memberId = Integer.parseInt(idCheck);
		int otherMemberId= Integer.parseInt(otherIdCheck);
		
		// GET ------------------------------------------------------
		ChatService service = new ChatService();
		List<ChatView> list = service.getList(memberId, otherMemberId);
		
		if( list.isEmpty() ) {
			out.print("{\"result\": \"empty\"}");
			out.close();
			return;
		}
		
		Set<String> idList = new HashSet<String>();
		ChatFileService fileService = new ChatFileService();
		
		for(ChatView c : list)
			idList.add(Integer.toString(c.getId()));

		System.out.println(String.join(",", idList));
		
		List<ChatFile> fileList = fileService.getList(idList);
		
//		out.println(list);
//		out.println(fileList);
		
		// OUT SETTING -------------------------------------------------
		
		// 아이디가 맞으면 chat파일들 담고 해당 인덱스 삭제
		// fileList.removeIf( )
		// {1, 1, 3} -> 3 삭제 -> {1, 1}
		// {1, 1} -> 2 없음 통과 -> {1, 1}
		// {1, 1} -> 1, 1 삭제 -> 0개 -> {}
		
		List<String> results = new ArrayList<String>();
		for(ChatView c : list) {
			List<String> fileJsonTemp = new ArrayList<String>();
			SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
			String regDate = formatter.format ( c.getRegistrantionDate() );

			fileList.removeIf( cf -> {
				if( c.getId() == cf.getChatId() ) {
					fileJsonTemp.add(String.format("{\"id\":%d,\"name\":\"%s\",\"route\":\"%s\",\"chatId\":%d}",
							cf.getId(), cf.getName(), cf.getRoute(), cf.getChatId()));
					return true;
				}
				return false;
			});
			

			// chat 정보들 담기
			String jsonTemp = String.format("\"id\":%d,\"regMemberId\":\"%s\",\"requester\":\"%s\",\"regMemberName\":\"%s\",\"requesterName\":\"%s\",\"contents\":\"%s\",\"registrantionDate\":\"%s\",",
					c.getId(), c.getRegMemberId(), c.getRequester(), c.getRegMemberName(), c.getRequesterName(), c.getContents(), regDate);
			// chat File 정보들 합치기
			jsonTemp += "\"files\":[" + String.join(",", fileJsonTemp) + "]";
			
			results.add(jsonTemp); 
		}
//		for(ChatFile cf : fileList) {
//			results.add(String.format("{\"id\":%d,\"name\":\"%s\",\"route\":\"%s\",\"chatId\":\"%d\"}",
//					cf.getId(), cf.getName(), cf.getRoute(), cf.getChatId()));
//		}
		
//		// JSON OUT -------------------------------------------------
		out.print("{");
		out.print("\"result\":\"sussess\",");
		out.print("\"datas\":[{");
			out.print(String.join("},{",results));
			out.print("}]");
		out.print("}");
		
	}
	
}
