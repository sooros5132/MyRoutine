package com.myroutine.web.dao.jdbc.user.chat;

import java.util.List;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.entity.user.chat.Chat;

public interface ChatDao {

	List<ChatView> getList(int memberId, int otherMemberId);
	List<ChatView> getList(int memberId, int otherMemberId, int startIndex, int endIndex);
	List<ChatView> getList(int memberId, int otherMemberId, int startIndex, int endIndex, String query);
	
	int insert(Chat chat);
	int update(int id, String field, String query);
	int delete(int id);
	
	
}
