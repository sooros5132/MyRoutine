package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.Exercise;

public interface ExerciseDao {
//	int insert(Exercise exercise);

//	int update(Exercise exercise);

//	int delete(int id);

	Exercise get(int id);

	List<Exercise> getList();
}
