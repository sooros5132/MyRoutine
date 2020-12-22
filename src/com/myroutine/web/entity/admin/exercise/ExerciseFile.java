package com.myroutine.web.entity.admin.exercise;

public class ExerciseFile {
	private int id;
	private String name;
	private String route;
	private int exerciseId;
	
	public ExerciseFile() {
	}
	
	public ExerciseFile(String fileName, int exerciseId) {
		this(0, fileName, null, exerciseId);
	}
	
	public ExerciseFile(String name, String route, int exerciseId) {
		this(0, name, route, exerciseId);
	}
	public ExerciseFile(int id, String name, String route, int exerciseId) {
		this.id = id;
		this.name = name;
		this.route = route;
		this.exerciseId = exerciseId;
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
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", route=" + route + ", exerciseId=" + exerciseId + "]";
	}
	
	
	
}
