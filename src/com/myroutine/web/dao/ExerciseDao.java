package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.entity.admin.exercise.Exercise;

public interface ExerciseDao {
	
	//��߰�
	int insert(Exercise exercise);
	
	//�����
	int update(Exercise exercise);

	int delete(Exercise exercise);

	Exercise get(int id);

	List<Exercise> getList();
	
	List<Exercise> getList(String[] parts);
	
	List<ExerciseView> getViewList();
	
	List<ExerciseView> getViewList(String[] parts);
	
	List<ExerciseView> getViewList(String[] parts,String title,String query);
	

}
