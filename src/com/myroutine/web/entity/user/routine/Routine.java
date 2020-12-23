package com.myroutine.web.entity.user.routine;

import java.util.Date;

public class Routine {
    int id;
    String name;
    Date regdate;
    Date executeDate;
    Date releaseDate;
    int regMemberId;
    String exerciseContents;

    public Routine() {
		// TODO Auto-generated constructor stub
	}
   
    
	public Routine(int id, String name, Date regdate, Date executeDate, Date releaseDate, int regMemberId,
			String exerciseContents) {
		this.id = id;
		this.name = name;
		this.regdate = regdate;
		this.executeDate = executeDate;
		this.releaseDate = releaseDate;
		this.regMemberId = regMemberId;
		this.exerciseContents = exerciseContents;
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



	public String getExerciseContents() {
		return exerciseContents;
	}



	public void setExerciseContents(String exerciseContents) {
		this.exerciseContents = exerciseContents;
	}



	@Override
	public String toString() {
		return "Routine [id=" + id + ", name=" + name + ", regdate=" + regdate + ", executeDate=" + executeDate
				+ ", releaseDate=" + releaseDate + ", regMemberId=" + regMemberId + ", exerciseContents="
				+ exerciseContents + "]";
	}
    
    
}
