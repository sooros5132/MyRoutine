package com.myroutine.web.dao;

import com.myroutine.web.entity.user.waterPlan.WaterPlan;

public interface WaterPlanDao {
    int insert(WaterPlan waterPlan);
	int update(WaterPlan waterPlan);
	int delete(int id);
}
