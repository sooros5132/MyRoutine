package com.myroutine.web.entity.admin.exercise;

public class ExerciseBodyPart {
	private int bodyPartId;
	private int exerciseId;
	
	
	public ExerciseBodyPart() {
		// TODO Auto-generated constructor stub
	}
	
	public ExerciseBodyPart(int bodyPartId, int exerciseId) {
		this.bodyPartId = bodyPartId;
		this.exerciseId = exerciseId;
	}

	public int getBodyPartId() {
		return bodyPartId;
	}

	public void setBodyPartId(int bodyPartId) {
		this.bodyPartId = bodyPartId;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	@Override
	public String toString() {
		return "ExerciseBodyPart [bodyPartId=" + bodyPartId + ", exerciseId=" + exerciseId + "]";
	}
}
