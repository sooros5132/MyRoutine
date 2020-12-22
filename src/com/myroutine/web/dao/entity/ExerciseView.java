package com.myroutine.web.dao.entity;

import java.util.Date;

import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseView extends Exercise {
	
	public ExerciseView(int id, String name, String contents, Date regdate, String engName, String recommend, int categoryId,
			int memberId) {
		super(id, name, contents, regdate, engName, recommend, categoryId, memberId);
	}
	
}
