package com.myroutine.web.entity.admin.exercise;

import java.util.Date;

public class Exercise {
	private int id;
	private String name;
	private String contents;
	private Date regDate;
	private String engName;
	private String recommend;
	private int memberId;
	private int categoryId;
	
	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exercise(int id, String name, String contents, Date regDate, String engName, String recommend
			,int memberId,int categoryId) {
		this.id = id;
		this.name = name;
		this.contents = contents;
		this.regDate = regDate;
		this.engName = engName;
		this.recommend = recommend;
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
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", contents=" + contents + ", recomand=" + recommend
				+ ", regDate=" + regDate + ", engName=" + engName + ", categoryId=" + categoryId + ", memberId="
				+ memberId + "]";
	}

}
