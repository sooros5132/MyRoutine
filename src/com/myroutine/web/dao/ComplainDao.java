package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.Complain;
import com.myroutine.web.dao.entity.ComplainCategory;
import com.myroutine.web.dao.entity.ComplainReport;
import com.myroutine.web.dao.entity.ComplainView;


public interface ComplainDao {
	//3.등록 수정 삭제
	int insert(Complain Complain);
//	int update(String title, String contents);
	int delete(int id);
	

	//1.목록 검색
	List<Complain> getList(int startIndex, int endIndex);
//	List<Complain> getList(int startIndex);
//	List<ComplainView> getViewList();
//	List<Complain> getList(int page, String key, String value);
	List<ComplainView> getViewList(int startIndex,int endIndex);
	List<ComplainView> getViewList(int startIndex,int endIndex,String value);
	List<ComplainView> getViewList(int startIndex,int endIndex,int key,String value);
	//2.상세페이지 
	Complain getDetail(int id);
	int update(Complain m);
	
	List<ComplainCategory> getCategoryList();
	int getTotal(int categoryId);
//	Complain getListId();
	int getLast();
	int reportInsert(ComplainReport ComplainReport);
	int commReportInsert(ComplainReport ComplainReport);
	List<ComplainReport> getReportList();
	List<ComplainReport> getCommentReportList();
}
 
