package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.BodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public interface ExerciseBodyPartDao {
	//운동 부위 추가
	int insert(ExerciseBodyPart exerciseBodyPart);
		
	//운동 부위 수정
	//int update(ExerciseBodyPart ebp);
	
	//운동 부위 삭제
	int delete(int id);
	

	//운동부위 가져오기
	List<ExerciseBodyPart> getList(int id);
	
	


	

}
