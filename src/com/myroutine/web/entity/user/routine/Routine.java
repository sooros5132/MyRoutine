package com.myroutine.web.entity.user.routine;

import java.util.Date;

public class Routine {
    private int id;
    private String name;
    private Date regdate;
    private Date executeDate;
    private Date releaseDate;
    private int regMemberId;
    
    public Routine() {
	}
    
	public Routine(int id, String name, Date regdate, Date executeDate, Date releaseDate, int regMemberId) {
		this.id = id;
		this.name = name;
		this.regdate = regdate;
		this.executeDate = executeDate;
		this.releaseDate = releaseDate;
		this.regMemberId = regMemberId;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getExecuteDate() {
		return executeDate;
	}
	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getRegMemberId() {
		return regMemberId;
	}
	public void setRegMemberId(int regMemberId) {
		this.regMemberId = regMemberId;
	}
    
    
    
}
