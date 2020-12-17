package com.myroutine.web.controller.api.friend;

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
import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.entity.user.chat.ChatFile;
import com.myroutine.web.entity.user.friend.Friend;
import com.myroutine.web.service.user.chat.ChatFileService;
import com.myroutine.web.service.user.chat.ChatViewService;
import com.myroutine.web.service.user.friend.FriendService;

@WebServlet("/api/friend/add")
public class AddController extends HttpServlet{

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
		String reqIdCheck = request.getParameter("reqId");
		String recIdCheck = request.getParameter("recId");
		
		if( reqIdCheck == null || recIdCheck == null ||
			reqIdCheck.equals("") || recIdCheck.equals("")) {
			out.print("{\"result\": \"fail\"}");
			return;
		}

		// SETTING --------------------------------------------------
		int result = 0;
		int reqId = Integer.parseInt(reqIdCheck);
		int recId = Integer.parseInt(recIdCheck);
		
		// GET ------------------------------------------------------
		FriendService service = new FriendService();
		List<FriendView> list = service.getList(reqId);

		if( list.isEmpty() ) {
			out.print("{\"result\": \"fail\"}");
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
			String jsonTemp = String.format("\"id\":%d,\"regMemberName\":\"%s\",\"requesterName\":\"%s\",\"contents\":\"%s\",\"registrantionDate\":\"%s\",",
					c.getId(), c.getRegMemberName(), c.getRequesterName(), c.getContents(), regDate);
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
