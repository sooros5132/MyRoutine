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
	public static String getFullDate() {
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
	
	//152834803
	public static String getTimeMillisecond() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "HHmmssSSS", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static String getYear() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static String getMonth() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "MM", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "dd", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static String getHour() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "HH", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static String getMinute() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "mm", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}

	public static String getSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "ss", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		return dTime;
	}
	
	public static void setNowDate() {
		currentTime = new Date(System.currentTimeMillis());
	}
	public static void setDate(Date date) {
		currentTime = date;
	}
}
