package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseFileDao;
import com.myroutine.web.dao.jdbc.JdbcExerciseFileDao;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;



public class ExerciseFileService {
	private ExerciseFileDao exerciseFileDao;
	
	public List<ExerciseFile>getFileList(int exerciseId) {
		exerciseFileDao = new JdbcExerciseFileDao();
		List<ExerciseFile> result = exerciseFileDao.getFileList(exerciseId); 
		return result;
	}

	public List<ExerciseFile> getFileList(String part) {
		exerciseFileDao = new JdbcExerciseFileDao();
		return null;
	}
	
	public ExerciseFileService() {
		exerciseFileDao = new JdbcExerciseFileDao();
	}
	
	
	//���ϵ��
	public int insert(ExerciseFile exerciseFile) {
		int result = exerciseFileDao.insert(exerciseFile);
		return result;
	}
	
	//���� ����
	public int delete(String fileNameStr, int id) {
		int result = exerciseFileDao.delete(fileNameStr, id);
		return result;
	}
	
	public int delete(int id) {
		int result = exerciseFileDao.delete(id);
		return result;
	}
	
	//��� ���� ����
	public int deleteAll(int id) {
		exerciseFileDao = new JdbcExerciseFileDao();
		int result = exerciseFileDao.deleteAll(id);
		return result;
	}

	public List<ExerciseFile> getList(int id) {
		exerciseFileDao = new JdbcExerciseFileDao();
		List<ExerciseFile> exerciseFileList= exerciseFileDao.getList(id);
		
		return exerciseFileList;
	}
}
