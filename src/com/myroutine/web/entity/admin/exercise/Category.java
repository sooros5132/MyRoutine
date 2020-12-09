package com.myroutine.web.entity.admin.exercise;

public class Category {
	private int id;
    private int type;
    
    
    public Category() {
	}
    
	public Category(int id, int type) {
		this.id = id;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
    
    
    
}
