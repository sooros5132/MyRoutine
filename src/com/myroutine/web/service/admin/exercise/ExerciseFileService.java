package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.dao.ExerciseFileDao;
import com.myroutine.web.dao.jdbc.JdbcExerciseDao;
import com.myroutine.web.dao.jdbc.JdbcExerciseFileDao;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;

public class ExerciseFileService {
	private ExerciseFileDao exerciseFileDao;

	
	public ExerciseFileService() {
		//exerciseFileDao = new JdbcExerciseFileDao();
		//이렇게 ExerciseService생성자에서 객체 선언하면
		//아래 모든 함수들에서 저 객체를 쓸수 있다.
	}
	
	
	public List<ExerciseFile>getFileList(int exerciseId) {
		exerciseFileDao = new JdbcExerciseFileDao();
		List<ExerciseFile> result = exerciseFileDao.getFileList(exerciseId); 
		return result;
	}


	public List<ExerciseFile> getFileList(String part) {
		exerciseFileDao = new JdbcExerciseFileDao();
//		List<ExerciseFile> result = exerciseFileDao.getFileList(part); 
		return null;
	}
}
