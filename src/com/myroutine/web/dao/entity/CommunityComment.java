package com.myroutine.web.dao.entity;

import java.util.Date;

public class CommunityComment {
	private int id;
	private int memberId;
	private String writerName;	
	private int communityId;
	private Date regdate;
    private String contents;
    
    public CommunityComment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param memberId
	 * @param writerName
	 * @param communityId
	 * @param regdate
	 * @param contents
	 */
	public CommunityComment(int id, int memberId, String writerName, int communityId, Date regdate, String contents) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.writerName = writerName;
		this.communityId = communityId;
		this.regdate = regdate;
		this.contents = contents;
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

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
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
		return "CommunityComment [id=" + id + ", memberId=" + memberId + ", writerName=" + writerName + ", communityId="
				+ communityId + ", regdate=" + regdate + ", contents=" + contents + "]";
	}

    
}
