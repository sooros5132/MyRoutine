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
		//�̷��� ExerciseService�����ڿ��� ��ü �����ϸ�
		//�Ʒ� ��� �Լ��鿡�� �� ��ü�� ���� �ִ�.
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
