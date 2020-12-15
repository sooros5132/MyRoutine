package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseService {
	private ExerciseDao exerciseDao;

	// � ���
	public int insert(Exercise exercise) {
		return exerciseDao.insert(exercise);
	}

	// � ����
	public int update(Exercise exercise) {
		return exerciseDao.update(exercise);
	}
	
	public int delete(Exercise exercise) {
		return exerciseDao.delete(exercise);
	}

	// � ����Ʈ �ҷ�����
	public List<Exercise> getList() {

		return exerciseDao.getList();
	}

	public List<Exercise> getList(String[] parts) {

		return exerciseDao.getList(parts);
	}
	
	// � ���� �ҷ�����
	public Exercise get(int id) {
		return exerciseDao.get(id);
	}
}
