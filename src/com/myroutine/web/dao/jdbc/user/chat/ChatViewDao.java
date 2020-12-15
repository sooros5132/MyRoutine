package com.myroutine.web.dao.jdbc.user.chat;

import java.util.List;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.entity.user.Chat;

public interface ChatViewDao {

	List<ChatView> getList();
	List<ChatView> getList(int startIndex, int endIndex);
	List<ChatView> getList(int startIndex, int endIndex, String query);
	
}
