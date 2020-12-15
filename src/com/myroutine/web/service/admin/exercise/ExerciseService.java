package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseService {
	private ExerciseDao exerciseDao;

	// 운동 등록
	public int insert(Exercise exercise) {
		return exerciseDao.insert(exercise);
	}

	// 운동 수정
	public int update(Exercise exercise) {
		return exerciseDao.update(exercise);
	}
	
	public int delete(Exercise exercise) {
		return exerciseDao.delete(exercise);
	}

	// 운동 리스트 불러오기
	public List<Exercise> getList() {

		return exerciseDao.getList();
	}

	public List<Exercise> getList(String[] parts) {

		return exerciseDao.getList(parts);
	}

	
	// 운동 정보 불러오기
	public Exercise get(int id) {
		return exerciseDao.get(id);
	}
	

}
