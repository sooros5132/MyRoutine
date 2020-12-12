package com.myroutine.web.service.admin.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;


public class ExerciseService {
	private ExerciseDao exerciseDao;
	
	public List<Exercise> getList() {
		
		return exerciseDao.getList();
	}
	
	
	public Exercise get(int id) {
		
		return exerciseDao.get(id);
	}

	
	
}
