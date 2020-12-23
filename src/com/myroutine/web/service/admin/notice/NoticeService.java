package com.myroutine.web.service.admin.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myroutine.web.dao.NoticeDao;
import com.myroutine.web.dao.entity.NoticeView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.dao.jdbc.JdbcNoticeDao;
import com.myroutine.web.entity.admin.notice.Notice;

public class NoticeService {
	private NoticeDao noticeDao;

	public NoticeService() {
		noticeDao = new JdbcNoticeDao();
	}
	
	public Notice get(int id) {

		return noticeDao.get(id);

	}

	public NoticeView getView(int id) {
		
		return noticeDao.getView(id);
	}
	
	
	
	public int insert(Notice notice) {

		return noticeDao.insert(notice);

	}

	public int update(Notice notice) {

		return noticeDao.update(notice);
	}

	public int delete(int id) {

		return noticeDao.delete(id);
	}
	
	public List<Notice> getList() {

		return noticeDao.getList();
	}
	public List<Notice> getList(int page) {

		return noticeDao.getList(page);
	}


	public List<Notice> getList(int page, int size) {

		return noticeDao.getList(page, size);
	}


	public List<Notice> getList(String field, String query, int page, int size) {

		return noticeDao.getList(field, query, page, size);
	}

	

	public Notice getPrev(int id) {

		return noticeDao.getPrev(id);
	}

	public Notice getNext(int id) {

		return noticeDao.getNext(id);
	}

	public int getLastId() {
		Notice n = noticeDao.getLast();

		return n.getId();
	}

	public int getCount() {
		return noticeDao.getCount();
	}




	public int hitUp(int id) {
       Notice notice = noticeDao.get(id);
        
		notice.setHit(notice.getHit()+1);
		int result = noticeDao.updateHit(notice);
		System.out.println(id);
		return result;
		
	}




	public int deleteAll(int[] ids) {
	     int result = noticeDao.deleteAll(ids);
	     return result;
	}









	

}
