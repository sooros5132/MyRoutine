package com.myroutine.web.service;

import java.util.List;

import com.myroutine.web.dao.CommunityCommentDao;
import com.myroutine.web.dao.entity.CommunityComment;
import com.myroutine.web.dao.jdbc.JdbcCommunityCommentDao;

public class CommentService {
	
	private CommunityCommentDao commentDao;
	
	public CommentService() {
		commentDao = new JdbcCommunityCommentDao();
	}
	
	public List<CommunityComment> getList(int id){
		return commentDao.getList(id);
	}
	
	public int insert(CommunityComment comment) {
		return commentDao.insert(comment); 
	}
	public int delete(int id) {
		return commentDao.delete(id);
	}

	public  List<CommunityComment> getTotalCmtList(int id) {
		// TODO Auto-generated method stub
		return commentDao.getTotalCmtList(id);
	}
	
}
