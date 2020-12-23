package com.myroutine.web.dao.entity;

import java.util.Date;

public class CommunityReport {
	private int id;
	private int memberId;
	private int communityId;
	private String contents;
	private Date regdate;
	private String nickname;
	
	public CommunityReport() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param memberId
	 * @param communityId
	 * @param contents
	 * @param regdate
	 * @param nickname
	 */
	public CommunityReport(int id, int memberId, int communityId, String contents, Date regdate, String nickname) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.communityId = communityId;
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

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
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
		return "CommunityReport [id=" + id + ", memberId=" + memberId + ", communityId=" + communityId + ", contents="
				+ contents + ", regdate=" + regdate + ", nickname=" + nickname + "]";
	}


	
	
	
}
