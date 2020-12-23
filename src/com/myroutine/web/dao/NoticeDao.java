package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.NoticeView;
import com.myroutine.web.entity.admin.notice.Notice;

public interface NoticeDao {
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	int getCount();
	
	Notice get(int id);
	NoticeView getView(int id);
	
	
   List<Notice>getList();
   List<Notice> getList(int startIndex);
   List<Notice> getList(int page, int size);
   List<Notice> getList(String field, String query,int startIndex, int endIndex );
 
   
   Notice getPrev(int id);
   Notice getNext(int id);
   
   
	Notice getLast();
	
	
	int updateHit(Notice notice);
	int deleteAll(int[] ids);
	
	int getCount2();
	
	




}
