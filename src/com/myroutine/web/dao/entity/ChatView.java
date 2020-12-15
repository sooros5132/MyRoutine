package com.myroutine.web.dao.entity;

import java.sql.Date;

public class ChatView {

	private int id;
	private String centents;
	private int requester;
	private Date deleteDate;
    private Date registrantionDate;
    private int regMemberId;
	private String fileName;
	private String fileRoute;
	
	public ChatView() {
		// TODO Auto-generated constructor stub
	}

	public ChatView(int id, String centents, int requester, Date deleteDate, Date registrantionDate, int regMemberId,
			String fileName, String fileRoute) {
		super();
		this.id = id;
		this.centents = centents;
		this.requester = requester;
		this.deleteDate = deleteDate;
		this.registrantionDate = registrantionDate;
		this.regMemberId = regMemberId;
		this.fileName = fileName;
		this.fileRoute = fileRoute;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRoute() {
		return fileRoute;
	}

	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}

	@Override
	public String toString() {
		return "ChatView [id=" + id + ", centents=" + centents + ", requester=" + requester + ", deleteDate="
				+ deleteDate + ", registrantionDate=" + registrantionDate + ", regMemberId=" + regMemberId
				+ ", fileName=" + fileName + ", fileRoute=" + fileRoute + "]";
	}
	
}
