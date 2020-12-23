package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.dao.entity.ExerciseListView;
import com.myroutine.web.dao.entity.ExerciseView;
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
	
	//모든 운동 개수 가지고오기
	int getCount();
	
	//운동리스트
	List<Exercise> getList();

	//운동 아이디 얻기
	int getLast();

	//운동 리스트 불러오는 함수들 다 기능이 다름
	//재활
	List<ExerciseListView> getListView();
	
	List<ExerciseListView> getAndListView(String[] parts);
	
	List<ExerciseListView> getOrListView(String[] parts);

	//홈트
	List<ExerciseListView> getHomeListView();
	
	List<ExerciseListView> getAndHomeListView(String[] parts);
	
	List<ExerciseListView> getOrHomeListView(String[] parts);

	
	
	
	}
