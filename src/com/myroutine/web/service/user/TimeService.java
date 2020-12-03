package com.myroutine.web.service.user;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeService {
	private SimpleDateFormat formatter;
	private Date currentTime;
	private String dTime;
	
	public TimeService() {
		
	}

	// 2020-12-03 16:47:41
	public String getDate() {
		formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
		currentTime = new Date(System.currentTimeMillis());
		dTime = formatter.format ( currentTime );
		return dTime;
	}
}
