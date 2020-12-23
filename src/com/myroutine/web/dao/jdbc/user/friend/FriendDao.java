package com.myroutine.web.dao.jdbc.user.friend;

import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.entity.user.friend.Friend;
import com.myroutine.web.entity.user.member.Member;

public interface FriendDao {

	Friend get(int reqId, int recId);
	List<Friend> getList(int reqId);
	List<Friend> getList(int reqId, int state);
	List<FriendView> getViewList(int reqId);
	List<FriendView> getViewList(int reqId, int state);
	List<FriendView> getViewList(int reqId, int state, int startIndex, int endIndex);
	List<Member> getAddAbleMemberList(int memberId, String nickname, int startIndex, int endIndex);
	
	int insert(int reqId, int recId, int state);
	int update(int reqId, int recId, int state);
	int delete(int reqId, int recId);
	int delete(int reqId, int recId, int state);
	
}
