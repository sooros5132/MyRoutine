package com.myroutine.web.service.user;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.admin.MemberDao;
import com.myroutine.web.dao.admin.jdbc.JdbcMemberDao;
import com.myroutine.web.entity.user.Member;

public class MemberService {


	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}

	public List<Member> getList() {
		return this.getList(20);
	}
	
	public List<Member> getList(int size) {
		List<Member> list = new ArrayList<>();
		
		list = memberDao.getList(size);
		
		return list;
	}
	
	public Member get(int id) {
		Member m = null;
		
		m = memberDao.get(id);
		
		return m;
	}
	
	public Member searchNickName(String nickname) {
		Member m = null;
		
		m = memberDao.searchNickName(nickname);
		
		return m;
	}
	
	public int put(Member m) {
		int result = 0;
		
		result = memberDao.put(m);
		
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		
		result = memberDao.delete(id);
		
		return result;
	}
	
	public int update(int id, String key, String value) {
		int result = 0;
		
		result = memberDao.update(id, key, value);
		
		return result;
	}
	
}
