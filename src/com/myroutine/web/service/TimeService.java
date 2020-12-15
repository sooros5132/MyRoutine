package com.myroutine.web.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeService {
	private static Date currentTime;
	
	static{
		currentTime = new Date(System.currentTimeMillis());
	}

	// 2020-12-03 16:47:41
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	// 20201203164741
	public static String getDateNoSeparator() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMddHHmmss", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static void setNowDate() {
		currentTime = new Date(System.currentTimeMillis());
	}
}
