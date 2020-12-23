package com.myroutine.web.service.user.friend;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.dao.jdbc.user.friend.FriendDao;
import com.myroutine.web.dao.jdbc.user.friend.JdbcFriendDao;
import com.myroutine.web.entity.user.friend.Friend;
import com.myroutine.web.entity.user.member.Member;

public class FriendService {
	private FriendDao friendDao;
	
	public FriendService() {
		friendDao = new JdbcFriendDao();
	}
	
	public Friend get(int memberId, int otherMemberId) {
		return friendDao.get(memberId, otherMemberId);
	}
	
	// View List -------------------------------------------
	public List<Friend> getList(int reqId) {
		return friendDao.getList(reqId, 1);
	}
	
	public List<Friend> getList(int reqId, int state) {
		List<Friend> list = new ArrayList<Friend>();
		
		list = friendDao.getList(reqId, state);
		
		return list;
	}

	// View List -------------------------------------------
	public List<FriendView> getViewList(int reqId) {
		return friendDao.getViewList(reqId, 0);
	}

	public List<FriendView> getViewList(int reqId, int state) {
		List<FriendView> list = new ArrayList<FriendView>();
		
		list = friendDao.getViewList(reqId, state);
		
		return list;
	}
	public List<Member> getAddAbleMemberList(int memberId, String nickname, int page, int size){
		List<Member> list = new ArrayList<Member>();
		
		int startIndex = 1 + (page - 1) * size;
		int endIndex = page * size;
		
		list = friendDao.getAddAbleMemberList(memberId, nickname, startIndex, endIndex);
		
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

	public int delete(int reqId, int recId) {
		int result = 0;
		
		result = friendDao.delete(reqId, recId);
		
		return result;
	}
	public int delete(int reqId, int recId, int state) {
		int result = 0;
		
		result = friendDao.delete(reqId, recId, state);
		
		return result;
	}
	
}
