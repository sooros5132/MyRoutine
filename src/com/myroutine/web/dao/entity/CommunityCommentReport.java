package com.myroutine.web.dao.entity;

import java.sql.Date;

public class CommunityCommentReport {
	private int id;
	private int commentId;
	private int memberId;
	private Date regdate;
	private String contents;
	
	public CommunityCommentReport() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param commentId
	 * @param memberId
	 * @param regdate
	 * @param contents
	 */
	public CommunityCommentReport(int id, int commentId, int memberId, Date regdate, String contents) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.memberId = memberId;
		this.regdate = regdate;
		this.contents = contents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "CommunityCommentReport [id=" + id + ", commentId=" + commentId + ", memberId=" + memberId + ", regdate="
				+ regdate + ", contents=" + contents + "]";
	}

	
}
