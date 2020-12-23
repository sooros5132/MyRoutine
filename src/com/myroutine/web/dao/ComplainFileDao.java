package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.ComplainFile;


public interface ComplainFileDao {
	int insert(ComplainFile complainFile);
	int delete(int id);
	
	List<ComplainFile> getList(int id);
}
