package com.myroutine.web.service.user.chat;

import java.util.List;
import java.util.Set;

import com.myroutine.web.dao.jdbc.user.chat.JdbcChatFileDao;
import com.myroutine.web.entity.user.chat.ChatFile;

public class ChatFileService {

	private JdbcChatFileDao chatFileDao;

	public ChatFileService() {
		chatFileDao = new JdbcChatFileDao();
	}

	public List<ChatFile> getList(int id) {
		return getList(id, "");
	}
	
	public List<ChatFile> getList(int id, String query) {
		
		return chatFileDao.getList(id, query);
		
	}
	public List<ChatFile> getList(Set<String> idList) {
		
		return chatFileDao.getList(idList);
		
	}

	public int insert(ChatFile cf) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
