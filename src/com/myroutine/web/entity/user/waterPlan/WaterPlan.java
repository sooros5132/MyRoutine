package com.myroutine.web.entity.user.waterPlan;

import java.util.Date;

public class WaterPlan {
   private int id;
   private String title;
   private String intake_rate;
   private String goal;
   private String writer_id;
   private Date regdate;
   
public WaterPlan() {
	// TODO Auto-generated constructor stub
}

public WaterPlan(int id, String title, String intake_rate, String goal, String writer_id, Date regdate) {
	super();
	this.id = id;
	this.title = title;
	this.intake_rate = intake_rate;
	this.goal = goal;
	this.writer_id = writer_id;
	this.regdate = regdate;
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

public String getIntake_rate() {
	return intake_rate;
}

public void setIntake_rate(String intake_rate) {
	this.intake_rate = intake_rate;
}

public String getGoal() {
	return goal;
}

public void setGoal(String goal) {
	this.goal = goal;
}

public String getWriter_id() {
	return writer_id;
}

public void setWriter_id(String writer_id) {
	this.writer_id = writer_id;
}

public Date getRegdate() {
	return regdate;
}

public void setRegdate(Date regdate) {
	this.regdate = regdate;
}

@Override
public String toString() {
	return "WaterPlan [id=" + id + ", title=" + title + ", intake_rate=" + intake_rate + ", goal=" + goal
			+ ", writer_id=" + writer_id + ", regdate=" + regdate + "]";
}


   

}
