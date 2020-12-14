package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseService {
	private ExerciseDao exerciseDao;
	
	//� ���
	public int insert(Exercise ex) {
		int result = 0;
		return result;
	}
	
	//� ����
		public int update(Exercise ex) {
			int result = 0;
			return result;
			
		}
		
	//� ����Ʈ �ҷ�����
	public List<Exercise> getList() {
		
		return exerciseDao.getList();
	}

	public Exercise get(int id) {
		return exerciseDao.get(id);
	}
	
	

}
