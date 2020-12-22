package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.ExerciseListView;
import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.entity.admin.exercise.Exercise;

public interface ExerciseDao {
	
	//운동추가
	int insert(Exercise exercise);
	
	//운동수정
	int update(Exercise exercise);

	int delete(Exercise exercise);

	Exercise get(int id);

	List<Exercise> getList();
		
	List<Exercise> getList(String[] parts);
	
	ExerciseView getView(int id);
	
	List<ExerciseView> getViewList();
	
	List<ExerciseView> getViewList(String[] parts);
	
	List<ExerciseView> getViewList(String[] parts,String[] files);
	
	List<ExerciseView> getViewList(String[] parts,String[] files, String[] routes);
	
	List<ExerciseView> getViewList(String[] parts,String[] files, String[] routes, String title, String query);

	List<ExerciseListView> getListView();
	
	List<ExerciseListView> getListView(String[] parts);
}
