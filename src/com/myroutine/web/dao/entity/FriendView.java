package com.myroutine.web.dao.entity;

import com.myroutine.web.entity.user.friend.Friend;

public class FriendView extends Friend {

	private int id;
	private String nickname;
	private int state;
	
	public FriendView() {
		// TODO Auto-generated constructor stub
	}
	
	public FriendView(int id, String nickname, int state) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "FriendView [id=" + id + ", nickname=" + nickname + ", state=" + state + "]";
	}
	
	
}
