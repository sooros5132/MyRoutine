package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.CommunityFile;



public interface CommunityFileDao {
	int insert(CommunityFile communityFile);
	int delete(int id);
	
	List<CommunityFile> getList(int id);
	List<CommunityFile> getTotalFileList(int id);
}
