package com.myroutine.web.dao.entity;

import java.util.Date;

import com.myroutine.web.entity.admin.notice.Notice;

public class NoticeView extends Notice{
	 private String fileName;
	 private String fileRoute;

	
public NoticeView() {

}

public NoticeView(String title, String contents) {
	super(title, contents);
}

public NoticeView (int id, String title, String contents, 
		boolean openInfo, int hit,
		String memberId, Date regdate,
		String fileName, String fileRoute) 
{
	
	super(id,title,contents,openInfo,hit,memberId, regdate);
	this.fileName = fileName;
	this.fileRoute = fileRoute;
}




public NoticeView(int id, String title, String contents,
		boolean openInfo, String hit, String memberId,
		Date regdate,
		String fileName, String fileRoute) {
	
	this.fileName = fileName;
	this.fileRoute = fileRoute;
}


public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFileRoute() {
	return fileRoute;
}

public void setFileRoute(String fileRoute) {
	this.fileRoute = fileRoute;
}

@Override
public String toString() {
	return "NoticeView [fileName=" + fileName + ", fileRoute=" + fileRoute + "]";
}
	
	
}
