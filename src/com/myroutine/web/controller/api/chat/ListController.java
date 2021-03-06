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
		
		int page = 1;
		int size = 20;
		String page_ = request.getParameter("page");
		String size_ = request.getParameter("size");
		
		if( page_ != null && size_ != null &&
			!page_.equals("") && !size_.equals("")) {
			page = Integer.parseInt(page_);
			size = Integer.parseInt(size_);
		}
		
		// GET ------------------------------------------------------
		ChatService service = new ChatService();
		List<ChatView> list = service.getList(memberId, otherMemberId, page, size);
		
		if( list.isEmpty() ) {
			out.print("{\"result\": \"empty\"}");
			out.close();
			return;
		}
		
		Set<String> idList = new HashSet<String>();
		ChatFileService fileService = new ChatFileService();
		
		for(ChatView c : list)
			idList.add(Integer.toString(c.getId()));

//		System.out.println(String.join(",", idList));
		
		List<ChatFile> fileList = fileService.getList(idList);
		
//		out.println(list);
//		out.println(fileList);
		
		// OUT SETTING -------------------------------------------------
		
		// ???????????? ????????? chat????????? ?????? ?????? ????????? ??????
		// fileList.removeIf( )
		// {1, 1, 3} -> 3 ?????? -> {1, 1}
		// {1, 1} -> 2 ?????? ?????? -> {1, 1}
		// {1, 1} -> 1, 1 ?????? -> 0??? -> {}
		
		List<String> results = new ArrayList<String>();
		for(ChatView c : list) {
			List<String> fileJsonTemp = new ArrayList<String>();
			SimpleDateFormat formatter1 = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
			SimpleDateFormat formatter2 = new SimpleDateFormat ( "HH:mm:ss", Locale.KOREA );
			String regDate = formatter1.format ( c.getRegistrantionDate() ) + "T" + formatter2.format ( c.getRegistrantionDate() );
			String deleteDate = "";

			fileList.removeIf( cf -> {
				if( c.getId() == cf.getChatId() ) {
					fileJsonTemp.add(String.format("{\"id\":%d,\"name\":\"%s\",\"route\":\"%s\",\"chatId\":%d}",
							cf.getId(), cf.getName(), cf.getRoute(), cf.getChatId()));
					return true;
				}
				return false;
			});
			
			String jsonTemp = "";

			// chat ????????? ??????
			// chat File ????????? ?????????
			
			if( c.getDeleteDate() == null || c.getDeleteDate().equals("") ) {
				jsonTemp = String.format("\"id\":%d,\"regMemberId\":\"%s\",\"requester\":\"%s\",\"regMemberName\":\"%s\",\"requesterName\":\"%s\",\"contents\":\"%s\",\"registrantionDate\":\"%s\",",
						c.getId(), c.getRegMemberId(), c.getRequester(), c.getRegMemberName(), c.getRequesterName(), c.getContents(), regDate);
				jsonTemp += "\"files\":[" + String.join(",", fileJsonTemp) + "]";
			} else {
				deleteDate = formatter1.format ( c.getDeleteDate() ) + "T" + formatter2.format ( c.getDeleteDate() );
				jsonTemp = String.format("\"id\":%d,\"regMemberId\":\"%s\",\"deleteDate\":\"%s\"",
						c.getId(), c.getRegMemberId(), deleteDate);	
			}
			
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
