package com.myroutine.web.dao.entity;

import java.util.Date;

public class ComplainReport {
	private int id;
	private int memberId;
	private int ComplainId;
	private String contents;
	private Date regdate;
	private String nickname;
	
	public ComplainReport() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param memberId
	 * @param ComplainId
	 * @param contents
	 * @param regdate
	 * @param nickname
	 */
	public ComplainReport(int id, int memberId, int ComplainId, String contents, Date regdate, String nickname) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.ComplainId = ComplainId;
		this.contents = contents;
		this.regdate = regdate;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getComplainId() {
		return ComplainId;
	}

	public void setComplainId(int ComplainId) {
		this.ComplainId = ComplainId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "ComplainReport [id=" + id + ", memberId=" + memberId + ", ComplainId=" + ComplainId + ", contents="
				+ contents + ", regdate=" + regdate + ", nickname=" + nickname + "]";
	}


	
	
	
}
