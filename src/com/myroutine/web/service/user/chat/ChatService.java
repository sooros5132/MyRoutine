package com.myroutine.web.service.user.chat;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.dao.jdbc.user.chat.JdbcChatDao;
import com.myroutine.web.entity.user.chat.Chat;

public class ChatService {

	private JdbcChatDao chatDao;

	public ChatService() {
		chatDao = new JdbcChatDao();
	}
	
	public int send(Chat chat) {
		int result = 0;
		
		result = chatDao.insert(chat);
		
		return result;
	}
	
	public int deleteMsg(int id, String field, String query) {
		int result = 0;
		
		result = chatDao.update(id, field, query);
		
		return result;
	}
	
	public List<ChatView> getList(int memberId, int otherMemberId) {
		return getList(memberId, otherMemberId, 1, 20, "");
	}

	public List<ChatView> getList(int memberId, int otherMemberId, int startIndex, int endIndex) {
		return getList(memberId, otherMemberId, startIndex, endIndex, "");
	}
	
	public List<ChatView> getList(int memberId, int otherMemberId, int startIndex, int endIndex, String query) {
		List<ChatView> list = new ArrayList<ChatView>();
		
		list = chatDao.getList(memberId, otherMemberId, startIndex, endIndex, query);
		
		return list;
	}
	
}
