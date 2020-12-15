package com.myroutine.web.dao.jdbc.user.chat;

import com.myroutine.web.entity.user.Chat;

public interface ChatDao {

	int insert(Chat chat);
	int update(int id, String field, String query);
	int delete(int id);
	
}
