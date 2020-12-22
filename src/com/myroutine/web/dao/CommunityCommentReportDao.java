package com.myroutine.web.dao;

import com.myroutine.web.dao.entity.Community;

public interface CommunityCommentReportDao {
	int insert(Community community);

	Community get(int id);

}
