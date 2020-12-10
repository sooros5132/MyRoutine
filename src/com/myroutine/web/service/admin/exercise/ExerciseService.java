package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseService {
	private ExerciseDao exerciseDao;
	
	
	
	//운동 등록
	public int insert(Exercise ex) {
		int result = 0;
		return result;
	}
	
	//운동 수정
		public int update(Exercise ex) {
			int result = 0;
			return result;
			
		}
		
	//운동 리스트 불러오기
	public List<Exercise> getList() {
		
		return exerciseDao.getList();
	}

	//운동 정보 불러오기
	public Exercise get(int id) {
		return exerciseDao.get(id);
	}
	
	

}
