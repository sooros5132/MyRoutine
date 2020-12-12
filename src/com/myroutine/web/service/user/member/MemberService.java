package com.myroutine.web.service.user.member;

import com.myroutine.web.dao.jdbc.user.member.JdbcMemberDao;
import com.myroutine.web.dao.jdbc.user.member.MemberDao;
import com.myroutine.web.entity.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}
	
	public int put(Member m) {
		int result = 0;
		
		result = memberDao.put(m);
		
		return result;
	}
	
	public int dupCheck(String key, String value) {
		int result = 0;
		
		result = memberDao.dupCheck(key, value);
		
		return result;
	}
	
}
