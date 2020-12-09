package com.myroutine.web.entity.admin.exercise;

public class BodyPart {
	private int id;
    private String bodyPart;
    
    public BodyPart() {
		// TODO Auto-generated constructor stub
	}
    
	public BodyPart(int id, String bodyPart) {
		this.id = id;
		this.bodyPart = bodyPart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	
    
}
