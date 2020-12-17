package com.myroutine.web.service.user.friend;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.dao.jdbc.user.friend.FriendDao;
import com.myroutine.web.dao.jdbc.user.friend.JdbcFriendDao;
import com.myroutine.web.entity.user.friend.Friend;

public class FriendService {
	private FriendDao friendDao;
	
	public FriendService() {
		friendDao = new JdbcFriendDao();
	}
	// View List -------------------------------------------
	public List<Friend> getList(int reqId) {
		return getList(reqId, 1);
	}
	
	public List<Friend> getList(int reqId, int state) {
		List<Friend> list = new ArrayList<Friend>();
		
		list = friendDao.getList(reqId, state);
		
		return list;
	}

	// View List -------------------------------------------
	public List<FriendView> getViewList(int reqId) {
		return getViewList(reqId, 1);
	}

	public List<FriendView> getViewList(int reqId, int state) {
		List<FriendView> list = new ArrayList<FriendView>();
		
		list = friendDao.getViewList(reqId, state);
		
		return list;
	}

	public int insert(int reqId, int recId, int state) {
		int result = 0;
		
		result = friendDao.insert(reqId, recId, state);
		
		return result;
	}

	public int update(int reqId, int recId, int state) {
		int result = 0;
		
		result = friendDao.update(reqId, recId, state);
		
		return result;
	}

	public int delete(int reqId, int recId, int state) {
		int result = 0;
		
		result = friendDao.delete(reqId, recId, state);
		
		return result;
	}
	
}
