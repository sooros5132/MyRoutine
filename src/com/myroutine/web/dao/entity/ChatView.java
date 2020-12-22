package com.myroutine.web.dao.entity;

import java.sql.Date;

public class ChatView {

	private int id;
	private String contents;
	private String regMemberName;
	private String requesterName;
    private int regMemberId;
    private int requester;
    private Date registrantionDate;
	private Date deleteDate;
	
	public ChatView() {
		// TODO Auto-generated constructor stub
	}
	
	public ChatView(String contents, String regMemberName, String requesterName, Date registrantionDate, Date deleteDate) {
		this.contents = contents;
		this.regMemberName = regMemberName;
		this.requesterName = requesterName;
		this.registrantionDate = registrantionDate;
		this.deleteDate = deleteDate;
	}

	public ChatView(int id, String contents, String regMemberName, String requesterName, int regMemberId, int requester,
			Date registrantionDate, Date deleteDate) {
		super();
		this.id = id;
		this.contents = contents;
		this.regMemberName = regMemberName;
		this.requesterName = requesterName;
		this.regMemberId = regMemberId;
		this.requester = requester;
		this.registrantionDate = registrantionDate;
		this.deleteDate = deleteDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegMemberName() {
		return regMemberName;
	}

	public void setRegMemberName(String regMemberName) {
		this.regMemberName = regMemberName;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}

	public int getRegMemberId() {
		return regMemberId;
	}

	public void setRegMemberId(int regMemberId) {
		this.regMemberId = regMemberId;
	}

	public int getRequester() {
		return requester;
	}

	public void setRequester(int requester) {
		this.requester = requester;
	}

	public Date getRegistrantionDate() {
		return registrantionDate;
	}

	public void setRegistrantionDate(Date registrantionDate) {
		this.registrantionDate = registrantionDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	@Override
	public String toString() {
		return "ChatView [id=" + id + ", contents=" + contents + ", regMemberName=" + regMemberName + ", requesterName="
				+ requesterName + ", regMemberId=" + regMemberId + ", requester=" + requester + ", registrantionDate="
				+ registrantionDate + ", deleteDate=" + deleteDate + "]";
	}

}
