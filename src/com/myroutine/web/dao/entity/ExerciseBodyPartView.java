package com.myroutine.web.dao.entity;

import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public class ExerciseBodyPartView extends ExerciseBodyPart{
	private String bodyPartName;

	public ExerciseBodyPartView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExerciseBodyPartView(int bodyPartId, int exerciseId,String bodyPartName) {
		super(bodyPartId, exerciseId);
		this.bodyPartName = bodyPartName;
	}

	public ExerciseBodyPartView(String bodyPartName) {
		super();
		this.bodyPartName = bodyPartName;
	}

	public String getBodyPartName() {
		return bodyPartName;
	}

	public void setBodyPartName(String bodyPartName) {
		this.bodyPartName = bodyPartName;
	}

	@Override
	public String toString() {
		return "ExerciseBodyPartView [bodyPartName=" + bodyPartName + "]";
	}
	
	
}
