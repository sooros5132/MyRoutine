package com.myroutine.web.dao;

import com.myroutine.web.entity.admin.Exercise;

public interface ExerciseDao {
	
	//��߰�
	int insert(Exercise exercise);
	
	//�����
	int update(Exercise exercise);

	Exercise get(int id);
}
