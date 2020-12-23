package com.myroutine.web.entity.admin.notice;

import java.util.Date;

public class Notice {
   private int id;
   private String title;
   private String contents;
   private boolean openInfo;
   private int hit;
   private String memberId;
   private Date regdate;
   
   public Notice() {
	// TODO Auto-generated constructor stub
}






public Notice(int id, String title, String contents, boolean openInfo, int hit, String memberId, Date regdate) {
	
	this.id = id;
	this.title = title;
	this.contents = contents;
	this.openInfo = openInfo;
	this.hit = hit;
	this.memberId = memberId;
	this.regdate = regdate;
}






public Notice(String title, String contents) {
	
	this.title = title;
	this.contents =contents;
	
}





public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContents() {
	return contents;
}

public void setContents(String contents) {
	this.contents = contents;
}








public boolean isOpenInfo() {
	return openInfo;
}






public void setOpenInfo(boolean openInfo) {
	this.openInfo = openInfo;
}






public int getHit() {
	return hit;
}

public void setHit(int hit) {
	this.hit = hit;
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}


public Date getRegdate() {
	return regdate;
}



public void setRegdate(Date regdate) {
	this.regdate = regdate;
}






@Override
public String toString() {
	return "Notice [id=" + id + ", title=" + title + ", contents=" + contents + ", openInfo=" + openInfo + ", hit="
			+ hit + ", memberId=" + memberId + ", regdate=" + regdate + "]";
}








   
}