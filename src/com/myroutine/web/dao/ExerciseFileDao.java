package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.ExerciseFile;

public interface ExerciseFileDao {
	List<ExerciseFile> getFileList(int exerciseId) ;
	//���� �߰�
	int insert(ExerciseFile exfile);
	
	//���� ����
	int delete(String fileNameStr,int id);
	
	int delete(int id);
	
	
	//��� ���� ����
	int deleteAll(int id);
	
		
	//���� ����Ʈ ��������
	List<ExerciseFile> getList(int id);

}
