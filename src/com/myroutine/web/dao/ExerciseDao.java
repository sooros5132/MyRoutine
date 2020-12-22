package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.BodyPart;
import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;


public interface ExerciseDao {
	

	//운동추가

	int insert(Exercise exercise);
	

	//운동수정

	int update(Exercise exercise);

	//운동삭제
	int delete(int id);
	
	//운동 상세보기

	Exercise get(int id);
	
	//운동리스트
	List<Exercise> getList();
	

	//운동 아이디 얻기
	int getLast();

}
