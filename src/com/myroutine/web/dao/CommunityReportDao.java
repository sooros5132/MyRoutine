package com.myroutine.web.dao;

public interface CommunityReportDao {
	int insertReport(int communityId, int memberId,String contents);
}
