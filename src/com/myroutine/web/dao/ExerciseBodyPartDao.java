package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.ExerciseBodyPartView;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public interface ExerciseBodyPartDao {
	List<ExerciseBodyPart> getBodyPartList(int exerciseId);
	
	List<ExerciseBodyPartView> getViewBodyPartList(int exerciseId);
}
