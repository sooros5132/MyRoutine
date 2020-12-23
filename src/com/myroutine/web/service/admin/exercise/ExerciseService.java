package com.myroutine.web.service.admin.exercise;

import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.dao.entity.ExerciseListView;
import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.dao.jdbc.JdbcExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class ExerciseService {
	private ExerciseDao exerciseDao;

	public ExerciseService() {
		exerciseDao = new JdbcExerciseDao();
		//이렇게 ExerciseService생성자에서 객체 선언하면
		//아래 모든 함수들에서 저 객체를 쓸수 있다.
	}
	
	// 운동 등록
	public int insert(Exercise exercise) {
		return exerciseDao.insert(exercise);
	}

	// 운동 수정
	public int update(Exercise exercise) {
		return exerciseDao.update(exercise);
	}
	
	public int delete(Exercise exercise) {
		return exerciseDao.delete(exercise);
	}

	// 운동 리스트 불러오기
	public List<Exercise> getList() {
//		exerciseDao = new JdbcExerciseDao(); 
		 List<Exercise> result = exerciseDao.getList();
		return result;
	}

	public List<Exercise> getList(String[] parts) {
		List<Exercise> result = exerciseDao.getList(parts);
		return result;
	}

	
	// 운동 정보 불러오기
	public Exercise get(int id) {
		Exercise result =exerciseDao.get(id); 
		System.out.println("=======운동서비스");
		return result;
	}
	
	public ExerciseView getView(int id) {
		ExerciseView result = exerciseDao.getView(id);
		
		System.out.println("겟 뷰");
		System.out.println("겟 뷰의 result : "+result);
		return result;
	}
	
	public List<ExerciseListView> getListView() {
		List<ExerciseListView> result = exerciseDao.getListView();

		return result;
	}
	
	public List<ExerciseListView> getAndListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getAndListView(parts);
		return result;
	}
	
	public List<ExerciseListView> getOrListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getOrListView(parts);
		return result;
	}

	public List<ExerciseListView> getHomeListView() {
		List<ExerciseListView> result = exerciseDao.getHomeListView();

		return result;
	}
	
	public List<ExerciseListView> getAndHomeListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getAndHomeListView(parts);
		return result;
	}
	
	public List<ExerciseListView> getOrHomeListView(String[] parts) {
		List<ExerciseListView> result = exerciseDao.getOrHomeListView(parts);
		return result;
	}
	
}

