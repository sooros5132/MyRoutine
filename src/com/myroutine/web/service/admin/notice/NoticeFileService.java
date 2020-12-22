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

import com.myroutine.web.dao.NoticeFileDao;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.dao.jdbc.jdbcNoticeFileDao;
import com.myroutine.web.entity.admin.notice.Notice;
import com.myroutine.web.entity.admin.notice.NoticeFile;

public class NoticeFileService {
	NoticeFileDao nfDao;
	public NoticeFileService() {
		nfDao = new jdbcNoticeFileDao();
	}
	//등록
	public int insert(NoticeFile noticeFile) {
	   return nfDao.insert(noticeFile);
	}
	
	//가져오기
	public NoticeFile get(int id) {
	    return nfDao.get(id);
		
}
	
	//삭제
	public int deleteNf(int id) {
		return nfDao.deleteNf(id);
	}

	public int deleteAllnf(int[] ids) {
		return nfDao.deleteAllnf(ids);
	}
	
}
