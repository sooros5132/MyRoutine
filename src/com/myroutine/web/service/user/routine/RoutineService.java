package com.myroutine.web.service.user.routine;

import com.myroutine.web.dao.RoutineDao;
import com.myroutine.web.dao.jdbc.JdbcRoutineDao;
import com.myroutine.web.entity.user.routine.Routine;

public class RoutineService {
	private RoutineDao routineDao;
	
	public RoutineService() {
		routineDao = new JdbcRoutineDao();
	}
	
	//루틴등록
	public int insert(Routine routine) {
		int result = routineDao.insert(routine);
		return result;
	}
	
}
