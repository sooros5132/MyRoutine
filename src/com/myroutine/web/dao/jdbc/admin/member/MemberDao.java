package com.myroutine.web.dao.jdbc.admin.member;

import java.util.List;
import java.util.Map;

import com.myroutine.web.entity.user.member.Member;

public interface MemberDao {
	List<Member> getList();
	List<Member> getList(int startIndex, int endIndex);
	List<Member> getList(int startIndex, int endIndex, int rule);
	List<Member> getList(int startIndex, int endIndex, String key, String value, String searchOption);
	List<Member> getList(int startIndex, int endIndex, int rule, String key, String value, String searchOption);
	Member get(int id);

	int delete(int memberId);
	int update(int id, String key, String value);
	// int update(int id, Map<String, String> datas);
	int totalCount();
	int searchCount();
}
