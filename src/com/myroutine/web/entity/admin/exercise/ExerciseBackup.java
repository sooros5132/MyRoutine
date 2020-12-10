package com.myroutine.web.entity.admin.exercise;

import java.util.Date;

public class ExerciseBackup {
	private String name;
	private String des;
	private String rec;
	private String div1;
	private String div2;
	private Date regDate;
	private String files;
	private String engName;
	
	public ExerciseBackup() {
		
	}
	public ExerciseBackup(String name, String des, String rec, String div1, String div2,Date regDate, String files,String engName) {
		super();
		this.name = name;
		this.des = des;
		this.rec = rec;
		this.div1 = div1;
		this.div2 = div2;
		this.regDate= regDate;
		this.files=files;
		this.engName=engName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getRec() {
		return rec;
	}
	public void setRec(String rec) {
		this.rec = rec;
	}
	public String getDiv1() {
		return div1;
	}
	public void setDiv1(String div1) {
		this.div1 = div1;
	}
	public String getDiv2() {
		return div2;
	}
	public void setDiv2(String div2) {
		this.div2 = div2;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	@Override
	public String toString() {
		return "Exercise [name=" + name + ", des=" + des + ", rec=" + rec + ", div1=" + div1 + ", div2=" + div2
				+ ", regDate=" + regDate + ", files=" + files + ", engName=" + engName + "]";
	}
	
	
	
}
