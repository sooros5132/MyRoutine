package com.myroutine.web.service.user;

import com.myroutine.web.dao.jdbc.user.chat.JdbcChatDao;
import com.myroutine.web.entity.user.Chat;

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
	
	
	
}
