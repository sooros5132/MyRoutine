package com.myroutine.web.dao.user;

import java.util.List;

import com.myroutine.web.entity.user.Member;

public interface MemberDao {
	
	int insert(Member member);
	int login(String email, String pwd);
	int recoveryPwd(String email);
	int emailCheck(String email);
}
