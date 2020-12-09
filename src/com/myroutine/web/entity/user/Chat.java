package com.myroutine.web.entity.user;

import java.sql.Date;

public class Chat {
	
	private int id;
	private String centents;
	private int requester;
	private Date deleteDate;
    private Date registrantionDate;
    private int regMemberId;
	
    public Chat() {
		// TODO Auto-generated constructor stub
	}

	public Chat(int id, String centents, int requester, Date deleteDate, Date registrantionDate, int regMemberId) {
		this.id = id;
		this.centents = centents;
		this.requester = requester;
		this.deleteDate = deleteDate;
		this.registrantionDate = registrantionDate;
		this.regMemberId = regMemberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentents() {
		return centents;
	}

	public void setCentents(String centents) {
		this.centents = centents;
	}

	public int getRequester() {
		return requester;
	}

	public void setRequester(int requester) {
		this.requester = requester;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Date getRegistrantionDate() {
		return registrantionDate;
	}

	public void setRegistrantionDate(Date registrantionDate) {
		this.registrantionDate = registrantionDate;
	}

	public int getRegMemberId() {
		return regMemberId;
	}

	public void setRegMemberId(int regMemberId) {
		this.regMemberId = regMemberId;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", centents=" + centents + ", requester=" + requester + ", deleteDate=" + deleteDate
				+ ", registrantionDate=" + registrantionDate + ", regMemberId=" + regMemberId + "]";
	}
    
}
