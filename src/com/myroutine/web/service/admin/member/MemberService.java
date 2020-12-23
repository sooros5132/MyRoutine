package com.myroutine.web.service.admin.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myroutine.web.dao.jdbc.admin.member.JdbcMemberDao;
import com.myroutine.web.dao.jdbc.admin.member.MemberDao;
import com.myroutine.web.entity.user.member.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}

	public List<Member> getList() {
		return getList(1, 20, 1, "", "", "");
	}

	public List<Member> getList(int startIndex, int endIndex) {
		return getList(startIndex, endIndex, 1, "", "", "");
	}

	public List<Member> getList(int startIndex, int endIndex, int rule) {
		return getList(startIndex, endIndex, rule, "", "", "");
	}

	public List<Member> getList(int startIndex, int endIndex, String key, String value, String searchOption) {
		return getList(1, 20, 1, key, value, searchOption);
	}
	
	public List<Member> getList(int page, int size, int rule, String key, String value, String searchOption) {
		List<Member> list = new ArrayList<>();
		
		int startIndex = 1 + (page - 1) * size;
		int endIndex = page * size;
		
		if(page <= 1) {
			startIndex = 1;
			endIndex = size;
		}
		
		list = memberDao.getList(startIndex, endIndex, rule, key, value, searchOption);
		
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

	public int updateAll(int id, Map<String, String> datas) {
		int result = 0;
		
		for (Map.Entry<String, String> data : datas.entrySet()) {
			result += memberDao.update(id, data.getKey(), data.getValue());
        }
		
		return result;
	}

	public int searchCount() {
		int result = 0;
		
		result = memberDao.searchCount();
		
		return result;
	}

	public int totalCount() {
		int result = 0;
		
		result = memberDao.totalCount();
		
		return result;
	}
	
}
