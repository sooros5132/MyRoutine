package com.myroutine.web.dao.jdbc.user.friend;

import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.entity.user.friend.Friend;

public interface FriendDao {
	
	List<Friend> getList(int reqId);
	List<Friend> getList(int reqId, int state);
	List<FriendView> getViewList(int reqId);
	List<FriendView> getViewList(int reqId, int state);
	
	int insert(int reqId, int recId, int state);
	int update(int reqId, int recId, int state);
	int delete(int reqId, int recId, int state);
	
}
