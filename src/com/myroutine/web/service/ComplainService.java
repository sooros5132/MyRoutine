package com.myroutine.web.service;

import java.util.List;

import com.myroutine.web.dao.ComplainDao;
import com.myroutine.web.dao.ComplainFileDao;
import com.myroutine.web.dao.entity.Complain;
import com.myroutine.web.dao.entity.ComplainCategory;
import com.myroutine.web.dao.entity.ComplainFile;
import com.myroutine.web.dao.entity.ComplainReport;
import com.myroutine.web.dao.entity.ComplainView;
import com.myroutine.web.dao.jdbc.JdbcComplainDao;
import com.myroutine.web.dao.jdbc.JdbcComplainFileDao;


public class ComplainService {
	
	private ComplainDao ComplainDao;
	private ComplainFileDao ComplainFileDao; 
	
	public ComplainService() {
		ComplainDao = new JdbcComplainDao();
		ComplainFileDao = new JdbcComplainFileDao();
		
	}
	
	public List<Complain> getList(int page) {
		
		int startIndex = 1+(page-1)*10;//1,11,21,31
		int endIndex = page*10;//10,20,30
		System.out.println("startIndex :"+startIndex+" endIndex : "+ endIndex);
		return ComplainDao.getList(startIndex, endIndex);
	}
	public List<ComplainView> getViewList(int page, int key, String value) {
		
		int startIndex = 1+(page-1)*10;//1,11,21,31
		int endIndex = page*10;//10,20,30
		
		System.out.println(key);
		
		if(key==0 && value=="")
			return ComplainDao.getViewList(startIndex, endIndex);
		else if(key==0 || value!="")
			return ComplainDao.getViewList(startIndex, endIndex, value);
		else
			return ComplainDao.getViewList(startIndex, endIndex, key, value);
	}
	
	 public Complain getDetail(int id) {
		 return ComplainDao.getDetail(id);
	}
	 
	public int insert(Complain Complain) {
		int result = ComplainDao.insert(Complain);
		//insert 후 파일업로드에 id값 전달 
		return result;
	}
	
	public int update(Complain Complain) {
		int result = 0;
		result = ComplainDao.update(Complain);
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		result = ComplainDao.delete(id); 
		return result;
	}

	public List<ComplainCategory> getCategoryList() {
		return ComplainDao.getCategoryList();
	}

	public int getTotal(int categoryId) {
		
		return ComplainDao.getTotal(categoryId);
	}

	public int hitUp(int id) {
		//상세페이지에 내용가지고 와서 hit추가하고 업데이트
		Complain Complain = ComplainDao.getDetail(id);
		
		Complain.setHit(Complain.getHit()+1);
		System.out.println(Complain);
		
		int result = ComplainDao.update(Complain);
		
		return result;
	}

	public int getListId() { 
		return ComplainDao.getLast();
	}

	public int fileInsert(ComplainFile ComplainFile) {
		int result = ComplainFileDao.insert(ComplainFile);
		
		return result; 
	}

	public int fileDelete(int id) {
		int result =ComplainFileDao.delete(id);
		return result;
	}

	public List<ComplainFile> getFileList(int id) {
		return ComplainFileDao.getList(id);
	}

	public int reportInsert(ComplainReport ComplainReport) {
		// TODO Auto-generated method stub
		return ComplainDao.reportInsert(ComplainReport);
	}

	public int commReportInsert(ComplainReport ComplainReport) {
		// TODO Auto-generated method stub
		return ComplainDao.commReportInsert(ComplainReport);
	}

	public List<ComplainReport> getReportList() {
	
		return ComplainDao.getReportList();
	}

	public List<ComplainReport> getCommentReportList() {

		return ComplainDao.getCommentReportList();
	}
}
