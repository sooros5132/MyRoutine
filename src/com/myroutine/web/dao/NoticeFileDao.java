package com.myroutine.web.dao;

import com.myroutine.web.entity.admin.notice.NoticeFile;

public interface NoticeFileDao {

	int insert(NoticeFile noticeFile);

	NoticeFile get(int id);

	int deleteNf(int id);

	int deleteAllnf(int[] ids);

}
