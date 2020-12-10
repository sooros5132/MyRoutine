package com.myroutine.web.dao.admin;

import java.util.List;

import com.myroutine.web.entity.user.Member;

public interface MemberDao {
	
	List<Member> getList(int size);
	Member get(int id);
	
	Member searchNickName(String nickname);
	int put(Member m);
	int delete(int id);
	int update(int id, String key, String value);
}
