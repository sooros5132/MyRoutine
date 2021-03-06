package com.myroutine.web.service;

public class IsNumberService {
	
//	public static void main(String[] args) {
//		System.out.println(isNumberic(""));  // false
//		System.out.println(isNumberic(null));// false
//		System.out.println(isInteger(""));   // false
//		System.out.println(isInteger(null)); // false
//	}
	
	public static boolean isNumberic(String s) { //숫자 판별 함수
		try {
	     	Double.parseDouble(s);
	    	return true;
	    } catch(NumberFormatException e) {  //문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
	    	return false;
	    }
	}

	public static boolean isInteger(String s) { //정수 판별 함수
		try {
	     	Integer.parseInt(s);
	    	return true;
	    } catch(NumberFormatException e) {  //문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
	    	return false;
	    }
	}
}
