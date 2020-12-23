package com.myroutine.web.dao.entity;

public class ExerciseListView {
	private int id;
	private String name;
	private int categoryId;
	private String efName;
	private String efRoute;
	
	
	
	public ExerciseListView(int id, String name, int categoryId, String efName, String efRoute) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId=categoryId;
		this.efName = efName;
		this.efRoute = efRoute;
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



	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public String getEfName() {
		return efName;
	}



	public void setEfName(String efName) {
		this.efName = efName;
	}



	public String getEfRoute() {
		return efRoute;
	}



	public void setEfRoute(String efRoute) {
		this.efRoute = efRoute;
	}



	@Override
	public String toString() {
		return "ExerciseListView [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", efName=" + efName
				+ ", efRoute=" + efRoute + "]";
	}
	
}
