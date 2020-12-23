package com.myroutine.web.service;

import java.util.List;

import com.myroutine.web.dao.CommunityDao;
import com.myroutine.web.dao.CommunityFileDao;
import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.dao.entity.CommunityCategory;
import com.myroutine.web.dao.entity.CommunityFile;
import com.myroutine.web.dao.entity.CommunityReport;
import com.myroutine.web.dao.entity.CommunityView;
import com.myroutine.web.dao.jdbc.JdbcCommunityDao;
import com.myroutine.web.dao.jdbc.JdbcCommunityFileDao;


public class CommunityService {
	
	private CommunityDao communityDao;
	private CommunityFileDao communityFileDao; 
	
	public CommunityService() {
		communityDao = new JdbcCommunityDao();
		communityFileDao = new JdbcCommunityFileDao();
		
	}
	
	public List<Community> getList(int page) {
		
		int startIndex = 1+(page-1)*10;//1,11,21,31
		int endIndex = page*10;//10,20,30
		System.out.println("startIndex :"+startIndex+" endIndex : "+ endIndex);
		return communityDao.getList(startIndex, endIndex);
	}
	public List<CommunityView> getViewList(int page, int key, String value) {
		
		int startIndex = 1+(page-1)*10;//1,11,21,31
		int endIndex = page*10;//10,20,30
		
		System.out.println(key);
		
		if(key==0 && value=="")
			return communityDao.getViewList(startIndex, endIndex);
		else if(key==0 || value!="")
			return communityDao.getViewList(startIndex, endIndex, value);
		else
			return communityDao.getViewList(startIndex, endIndex, key, value);
	}
	
	 public Community getDetail(int id) {
		 return communityDao.getDetail(id);
	}
	 
	public int insert(Community community) {
		int result = communityDao.insert(community);
		//insert 후 파일업로드에 id값 전달 
		return result;
	}
	
	public int update(Community community) {
		int result = 0;
		result = communityDao.update(community);
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		result = communityDao.delete(id); 
		return result;
	}

	public List<CommunityCategory> getCategoryList() {
		return communityDao.getCategoryList();
	}

	public int getTotal(int categoryId) {
		
		return communityDao.getTotal(categoryId);
	}

	public int hitUp(int id) {
		//상세페이지에 내용가지고 와서 hit추가하고 업데이트
		Community community = communityDao.getDetail(id);
		
		community.setHit(community.getHit()+1);
		System.out.println(community);
		
		int result = communityDao.update(community);
		
		return result;
	}

	public int getListId() { 
		return communityDao.getLast();
	}

	public int fileInsert(CommunityFile communityFile) {
		int result = communityFileDao.insert(communityFile);
		
		return result; 
	}

	public int fileDelete(int id) {
		int result =communityFileDao.delete(id);
		return result;
	}

	public List<CommunityFile> getFileList(int id) {
		return communityFileDao.getList(id);
	}

	public int reportInsert(CommunityReport communityReport) {
		// TODO Auto-generated method stub
		return communityDao.reportInsert(communityReport);
	}

	public int commReportInsert(CommunityReport communityReport) {
		// TODO Auto-generated method stub
		return communityDao.commReportInsert(communityReport);
	}

	public List<CommunityReport> getReportList() {
	
		return communityDao.getReportList();
	}

	public List<CommunityReport> getCommentReportList() {

		return communityDao.getCommentReportList();
	}
}
