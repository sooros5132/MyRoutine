package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.dao.entity.ExerciseListView;
import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.dao.jdbc.JdbcExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;



public class ExerciseService {
	private ExerciseDao exerciseDao;

	public ExerciseService() {
		exerciseDao = new JdbcExerciseDao();
	}

	//운동 등록
	public int insert(Exercise exercise) {
		int result = exerciseDao.insert(exercise);
		int id = exerciseDao.getLast();
		
		return id;
	}

	//운동 수정
	public int update(Exercise exercise) {
		int result = exerciseDao.update(exercise);
		return result;
		
	}
	
	//운동 삭제
	public int delete(int id) {
		int result = exerciseDao.delete(id);
		return result;
	}
	


	//운동 리스트 불러오기
	public List<Exercise> getList() {

		 List<Exercise> result = exerciseDao.getList();
		return result;
	}

	
	// 운동 정보 불러오기(디테일)
	public Exercise get(int id) {
		Exercise result =exerciseDao.get(id); 
		return result;
	}
	//운동 개수
	public int getCount() {
		int result = exerciseDao.getCount();
		return result;
	}
	
	public List<ExerciseListView> getListView() {
		List<ExerciseListView> result = exerciseDao.getListView();

		return result;
	}
	
	public List<ExerciseListView> getAndListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getAndListView(parts);
		return result;
	}
	
	public List<ExerciseListView> getOrListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getOrListView(parts);
		return result;
	}

	public List<ExerciseListView> getHomeListView() {
		List<ExerciseListView> result = exerciseDao.getHomeListView();

		return result;
	}
	
	public List<ExerciseListView> getAndHomeListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getAndHomeListView(parts);
		return result;
	}
	
	public List<ExerciseListView> getOrHomeListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getOrHomeListView(parts);
		return result;
	}
	

}

