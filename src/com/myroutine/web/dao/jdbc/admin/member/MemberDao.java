package com.myroutine.web.dao.jdbc.admin.member;

import java.util.List;

import com.myroutine.web.entity.Member;

public interface MemberDao {
	List<Member> getList(int size, int page, String key, String value, int rule, String searchOption);
	Member get(int id);

	int delete(int memberId);
	int update(int memberId, String key, String value);
	int totalCount();
}