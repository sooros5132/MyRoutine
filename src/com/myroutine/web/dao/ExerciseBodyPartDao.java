package com.myroutine.web.dao;

import java.util.List;
import com.myroutine.web.entity.admin.exercise.BodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.dao.entity.ExerciseBodyPartView;

public interface ExerciseBodyPartDao {
	//운동 부위 추가
	int insert(ExerciseBodyPart exerciseBodyPart);
		
	//운동 부위 수정
	//int update(ExerciseBodyPart ebp);
	
	//운동 부위 삭제
	int delete(int id);
	

	//운동부위 가져오기
	List<ExerciseBodyPart> getList(int id);
	
	List<ExerciseBodyPart> getBodyPartList(int exerciseId);
	
	List<ExerciseBodyPartView> getViewBodyPartList(int exerciseId);
	
}
