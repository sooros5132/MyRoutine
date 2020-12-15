package com.myroutine.web.dao.jdbc.user.chat;

import java.util.List;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.entity.Member;
import com.myroutine.web.entity.user.Chat;

public class JdbcChatViewDao implements ChatViewDao{

	@Override
	public List<ChatView> getList() {
		return getList(1, 20, "");
	}

	@Override
	public List<ChatView> getList(int startIndex, int endIndex) {
		return getList(startIndex, endIndex, "");
	}

	@Override
	public List<ChatView> getList(int startIndex, int endIndex, String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
