package com.myroutine.web.dao;

import com.myroutine.web.entity.admin.Exercise;

public interface ExerciseDao {
	
	//운동추가
	int insert(Exercise exercise);
	
	//운동수정
	int update(Exercise exercise);

	Exercise get(int id);
}
