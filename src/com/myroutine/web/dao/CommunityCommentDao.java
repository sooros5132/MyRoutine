package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.CommunityComment;


public interface CommunityCommentDao {
	int insert(CommunityComment comment);
	List<CommunityComment> getList(int id);
	int delete(int id);

}
