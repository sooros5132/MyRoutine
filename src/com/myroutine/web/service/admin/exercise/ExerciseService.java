package com.myroutine.web.service.admin.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.Exercise;

public class ExerciseService {
	private ExerciseDao exerciseDao;
	
	
	
	//운동 등록
	public int insert(Exercise ex) {
		int result = 0;
		return result;
	}
	
	//운동 정보 불러오기
	public Exercise get(int id) {
		return exerciseDao.get(id);
	}
	
	//운동 수정
	public int update(Exercise ex) {
		int result = 0;
		return result;
		
	}

}
