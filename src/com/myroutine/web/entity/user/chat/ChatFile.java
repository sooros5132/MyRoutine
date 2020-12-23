package com.myroutine.web.entity.user.chat;

import java.sql.Date;

public class ChatFile {
	
	private int id;
	private String name;
	private String route;
    private int chatId;
    
    public ChatFile() {
    	
	}

	public ChatFile(int id, String name, String route, int chatId) {
		super();
		this.id = id;
		this.name = name;
		this.route = route;
		this.chatId = chatId;
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

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	@Override
	public String toString() {
		return "ChatFile [id=" + id + ", name=" + name + ", route=" + route + ", chatId=" + chatId + "]";
	}
    
}
