package com.myroutine.web.service.admin.member;

import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.jdbc.admin.member.JdbcMemberDao;
import com.myroutine.web.dao.jdbc.admin.member.MemberDao;
import com.myroutine.web.entity.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}
	
	public List<Member> getList() {
		return getList(20, 1, "", "", 0, "");
	}
	
	public List<Member> getList(int size) {
		return getList(size, 1, "", "", 0, "");
	}

	public List<Member> getList(int size, String key, String value) {
		return getList(size, 1, key, value, 0, "");
	}
	
	public List<Member> getList(int size, int page, String key, String value, int rule, String searchOption) {
		List<Member> list = new ArrayList<>();
		
		list = memberDao.getList(size, page, key, value, rule, searchOption);
		
		return list;
	}
	
	public Member get(int id) {
		Member m = null;
		
		m = memberDao.get(id);
		
		return m;
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

	public int totalCount() {
		int result = 0;
		
		result = memberDao.totalCount();
		
		return result;
	}
	
}
