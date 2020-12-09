package com.myroutine.web.entity.admin;

import java.util.Date;

public class Exercise {
	private int id;
	private String name;
	private String contents;
	private Date regdate;
	private String engName;
	private String recommeand;
	private int bodyPart;
	private int memberId;
	private int categoryId;
	
	
	public Exercise() {
		// TODO Auto-generated constructor stub
	}
	public Exercise(int id, String name, String contents, Date regdate, String engName, String recommeand, int bodyPart,
			int memberId, int categoryId) {
		this.id = id;
		this.name = name;
		this.contents = contents;
		this.regdate = regdate;
		this.engName = engName;
		this.recommeand = recommeand;
		this.bodyPart = bodyPart;
		this.memberId = memberId;
		this.categoryId = categoryId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getRecommeand() {
		return recommeand;
	}
	public void setRecommeand(String recommeand) {
		this.recommeand = recommeand;
	}
	public int getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(int bodyPart) {
		this.bodyPart = bodyPart;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	

	


	

	
}
