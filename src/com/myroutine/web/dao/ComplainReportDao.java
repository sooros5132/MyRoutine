package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.Community;


public interface ComplainReportDao {
	int insert(Community community);
	int update(Community community);
	int delete(int id);
	
	Community get(int id);
	List<Community> getList();
}
