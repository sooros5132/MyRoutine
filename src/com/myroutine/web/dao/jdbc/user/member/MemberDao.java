package com.myroutine.web.dao.jdbc.user.member;

import java.util.List;

import com.myroutine.web.entity.Member;

public interface MemberDao {
	
	int insert(Member member);
	// login, dupCheck, recoveryPwd, recoveryEmail
	Member get(int id);
	Member get(String field, String query);
	Member get(int id, String field, String query);
}
