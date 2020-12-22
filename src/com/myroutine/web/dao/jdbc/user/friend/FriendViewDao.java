package com.myroutine.web.dao.jdbc.user.friend;

import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.entity.user.friend.Friend;

public interface FriendViewDao {
	
	FriendView get(int reqId);
	List<FriendView> getList(int reqId);
	
}
