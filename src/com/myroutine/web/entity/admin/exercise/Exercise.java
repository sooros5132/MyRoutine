package com.myroutine.web.entity.admin.exercise;

import java.util.Date;

public class Exercise {
	private int id;
	private String name;
	private String contents;
	private Date regdate;
	private String engName;
	private String recommend;
	private int memberId;
	private int categoryId;
	
	public Exercise() {
		// TODO Auto-generated constructor stub
	}

	//운동 등록시 사용
	public Exercise(String name, String contents, String engName, String recommend, int memberId,
			int categoryId) {
		this(0, name, contents, null, engName, recommend, memberId, categoryId);
	}
	
	
	//운동 수정시 사용
	public Exercise(int id, String name, String contents, String engName, String recommend, int memberId, int categoryId) {
		this(id, name, contents, null, engName, recommend, memberId, categoryId);
	}

	
	public Exercise(int id, String name, String contents, Date regdate, String engName, String recommend, int memberId,
			int categoryId) {
		this.id = id;
		this.name = name;
		this.contents = contents;
		this.regdate = regdate;
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

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
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


	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", contents=" + contents + ", regdate=" + regdate
				+ ", engName=" + engName + ", recommend=" + recommend + ", memberId=" + memberId + ", categoryId="
				+ categoryId + "]";
	}
	
	
	
}