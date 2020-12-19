package com.myroutine.web.dao.entity;

import com.myroutine.web.entity.user.friend.Friend;

public class FriendView extends Friend {

	private int id;
	private int requester;
	private int receiver;
	private int state;
	private String nickname;
	public FriendView(int id, int requester, int receiver, int state, String nickname) {
		super();
		this.id = id;
		this.requester = requester;
		this.receiver = receiver;
		this.state = state;
		this.nickname = nickname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequester() {
		return requester;
	}
	public void setRequester(int requester) {
		this.requester = requester;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "FriendView [id=" + id + ", requester=" + requester + ", receiver=" + receiver + ", state=" + state
				+ ", nickname=" + nickname + "]";
	}
	
	
	
}
