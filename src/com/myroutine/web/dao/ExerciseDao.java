package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.Exercise;

public interface ExerciseDao {
	
	//운동추가
	int insert(Exercise exercise);
	
	//운동수정
	int update(Exercise exercise);

//	int delete(int id);

	Exercise get(int id);

	List<Exercise> getList();
}
