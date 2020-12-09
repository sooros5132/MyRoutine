package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.achievement.Achievement;

public interface AchievementDao {
	int insert(Achievement ach);

	int update(Achievement ach);

	int delete(int id);

	int get(int id);

	List<Achievement> getList();
}