package com.myroutine.web.dao.jdbc.user.chat;

import java.util.List;
import java.util.Set;

import com.myroutine.web.entity.user.chat.ChatFile;

public interface ChatFileDao {

	List<ChatFile> getList(int id);
	List<ChatFile> getList(int id, String query);
	List<ChatFile> getList(Set<String> id);
	
	int insert(ChatFile cf);
	int delete(int id);
	
}
