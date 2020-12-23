package com.myroutine.web.entity.admin.notice;

public class NoticeFile {
   private int id;
   private String name;
   private String  route;
   private int  noticeId;
   
   public NoticeFile() {
	// TODO Auto-generated constructor stub
}

public NoticeFile(int id, String name, String route, int noticeId) {
	super();
	this.id = id;
	this.name = name;
	this.route = route;
	this.noticeId = noticeId;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getRoute() {
	return route;
}

public void setRoute(String route) {
	this.route = route;
}

public int getNoticeId() {
	return noticeId;
}

public void setNoticeId(int noticeId) {
	this.noticeId = noticeId;
}

@Override
public String toString() {
	return "NoticeFile [id=" + id + ", name=" + name + ", route=" + route + ", noticeId=" + noticeId + "]";
}


   

}
