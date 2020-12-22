package com.myroutine.web.service.user.member;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.jdbc.user.member.JdbcMemberDao;
import com.myroutine.web.dao.jdbc.user.member.MemberDao;
import com.myroutine.web.entity.user.member.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}
	
	public int put(Member m) {
		int result = 0;
		result = memberDao.insert(m);
		return result;
	}

	public Member get(int id) {
		return memberDao.get(id);
	}
	
	// login, dupCheck, recoveryPwd, recoveryEmail
	public Member get(String key, String value) {
		return memberDao.get(key, value);
	}

	public List<Member> getList(String field, String query) {
		return memberDao.getList(1, 20, field, query);
	}

	public List<Member> getList(int page, int size, String field, String query) {
		List<Member> list = new ArrayList<Member>();
		
		int startIndex = 1 + (page - 1) * size;
		int endIndex = page * size;
		
		list = memberDao.getList(startIndex, endIndex, field, query);
		
		return list;
	}
	
	public int login(String email, String pwd) {
		int result = 0;
		
		String resultEmail = memberDao.get("email", email).getEmail();
		String resultPwd = memberDao.get("email", email).getPwd();
		
		if( !resultEmail.equals("") )
			result++;
		if( !resultPwd.equals("") )
			result++;
		
		return result;
	}

	public int dupCheck(String key, String value) {
		int result = 0;
		
		Member m = memberDao.get(key, value);

		if( m != null )
			result++;

		return result;
	}
	
}
