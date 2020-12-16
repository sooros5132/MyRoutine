package com.myroutine.web.service.user;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.dao.jdbc.user.chat.JdbcChatDao;
import com.myroutine.web.dao.jdbc.user.chat.JdbcChatViewDao;
import com.myroutine.web.entity.user.Chat;

public class ChatViewService {

	private JdbcChatViewDao chatViewDao;

	public ChatViewService() {
		chatViewDao = new JdbcChatViewDao();
	}
	
	public List<ChatView> getList(int id) {
		return getList(id, 1, 20, "");
	}

	public List<ChatView> getList(int id, int startIndex, int endIndex) {
		return getList(id, startIndex, endIndex, "");
	}
	
	public List<ChatView> getList(int memberId, int startIndex, int endIndex, String query) {
		List<ChatView> list = new ArrayList<ChatView>();
		
		list = chatViewDao.getList(memberId, startIndex, endIndex, query);
		
		return list;
	}
	
}
