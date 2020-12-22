package com.myroutine.web.dao.entity;

public class ExerciseListView {
	private int id;
	private String name;
	private String efName;
	private String efRoute;
	
	
	public ExerciseListView(int id, String name, String efName, String efRoute) {
		super();
		this.id = id;
		this.name = name;
		this.efName = efName;
		this.efRoute = efRoute;
	}
	@Override
	public String toString() {
		return "ExerciseListView [id=" + id + ", name=" + name + ", efName=" + efName + ", efRoute=" + efRoute + "]";
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
	
	
}
