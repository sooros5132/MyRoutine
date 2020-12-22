package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.dao.jdbc.JdbcExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;


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
		return null;
	}


	//운동 정보 불러오기
	public Exercise get(int id) {	
		Exercise exercise = exerciseDao.get(id);
		return exercise;

	}
}
