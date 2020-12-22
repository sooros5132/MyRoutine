package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.user.routine.Routine;

public interface RoutineDao {
	
	int insert(Routine routine);
	
	int update(Routine routine);
	
	int delete(int id);
	
	int get(int id);
	
	List<Routine> getList();
}
