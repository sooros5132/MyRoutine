package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseBodyPartDao;
import com.myroutine.web.dao.jdbc.JdbcExerciseBodyPartDao;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public class ExerciseBodyPartService {
	private ExerciseBodyPartDao exerciseBodyPartDao;
	
	
	public ExerciseBodyPartService() {
		exerciseBodyPartDao = new JdbcExerciseBodyPartDao();
	}
	
	//운동 부위 등록
	public int insert(ExerciseBodyPart exerciseBodyPart) {
		
		int result = exerciseBodyPartDao.insert(exerciseBodyPart);
		return result;
	}
	
	
	//운동 부위 삭제
	public int delete(int id) {
		int result = exerciseBodyPartDao.delete(id);
		return result;
	}

	
	
	//운동 부위 가져오기
	public List<ExerciseBodyPart> getList(int id) {
		List<ExerciseBodyPart> list = exerciseBodyPartDao.getList(id);
		return list;
	}

	//운동부위 수정
	//	public int update(ExerciseBodyPart ebp) {
	//		int result = exerciseBodyPartDao.update(ebp);
	//		return result;		
	//	}
}
