package com.myroutine.web.service.admin.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.ExerciseBodyPartDao;
import com.myroutine.web.dao.entity.ExerciseBodyPartView;
import com.myroutine.web.dao.jdbc.JdbcExerciseBodyPartDao;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public class ExerciseBodyPartService  {

	private ExerciseBodyPartDao exerciseBodyPartDao;
	public ExerciseBodyPartService() {
		exerciseBodyPartDao= new JdbcExerciseBodyPartDao();
	}
	
	
	public List<ExerciseBodyPart> getBodyPartList(int exerciseId) {
		List<ExerciseBodyPart> result = exerciseBodyPartDao.getBodyPartList(exerciseId);
		return result;
	}
	
	public List<ExerciseBodyPartView> getViewBodyPartList(int exerciseId) {
		List<ExerciseBodyPartView> result = exerciseBodyPartDao.getViewBodyPartList(exerciseId);
		return result;
	}
}
