package com.myroutine.web.dao.jdbc.user.member;

import java.util.List;

import com.myroutine.web.entity.Member;

public interface MemberDao {
	
	int put(Member member);
	int login(String email, String pwd);
	int recoveryPwd(String email);
	int dupCheck(String key, String value);
}
