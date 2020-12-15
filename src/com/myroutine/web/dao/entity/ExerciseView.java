package com.myroutine.web.dao.entity;

import java.util.Date;

import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseView extends Exercise{
	private String fileName;
	private String fileRoute;
	
	public ExerciseView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExerciseView(int id, String name, String contents, String recommend, Date regDate, String engName,
			int categoryId, int memberId) {
		super(id, name, contents, recommend, regDate, engName, categoryId, memberId);
		// TODO Auto-generated constructor stub
	}
	
	public ExerciseView(int id, String name, String contents, String recommend, Date regDate, String engName,
			int categoryId, int memberId,String fileName, String fileRoute) {
		super(id, name, contents, recommend, regDate, engName, categoryId, memberId);
		this.fileName=fileName;
		this.fileRoute=fileRoute;
	}
	
	
	
	
	
	
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRoute() {
		return fileRoute;
	}
	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}
	
	
}
