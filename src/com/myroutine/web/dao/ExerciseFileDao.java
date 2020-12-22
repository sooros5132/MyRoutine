package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.ExerciseFile;

public interface ExerciseFileDao {
	//파일 추가
	int insert(ExerciseFile exfile);
	
	//파일 삭제
	int delete(String fileNameStr,int id);
	
	int delete(int id);
	
	
	//모든 파일 삭제
	int deleteAll(int id);
	
		
	//파일 리스트 가져오기
	List<ExerciseFile> getList(int id);
}
