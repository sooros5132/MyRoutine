package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.dao.entity.CommunityCategory;
import com.myroutine.web.dao.entity.CommunityReport;
import com.myroutine.web.dao.entity.CommunityView;

public interface CommunityDao {
	//3.등록 수정 삭제
	int insert(Community community);
//	int update(String title, String contents);
	int delete(int id);
	

	//1.목록 검색
	List<Community> getList(int startIndex, int endIndex);
//	List<Community> getList(int startIndex);
//	List<CommunityView> getViewList();
//	List<Community> getList(int page, String key, String value);
	List<CommunityView> getViewList(int startIndex,int endIndex);
	List<CommunityView> getViewList(int startIndex,int endIndex,String value);
	List<CommunityView> getViewList(int startIndex,int endIndex,int key,String value);
	//2.상세페이지 
	Community getDetail(int id);
	int update(Community m);
	
	List<CommunityCategory> getCategoryList();
	int getTotal(int categoryId);
//	Community getListId();
	int getLast();
	int reportInsert(CommunityReport communityReport);
	int commReportInsert(CommunityReport communityReport);
	List<CommunityReport> getReportList();
	List<CommunityReport> getCommentReportList();
}
 
