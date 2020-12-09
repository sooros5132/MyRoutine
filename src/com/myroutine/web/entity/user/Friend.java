package com.myroutine.web.entity.user;

public class Friend {
	private int id;
	private int requester;
	private int receiver;
	private int state;
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}

	public Friend(int id, int requester, int receiver) {
		this.id = id;
		this.requester = requester;
		this.receiver = receiver;
	}

	public Friend(int id, int requester, int receiver, int state) {
		this.id = id;
		this.requester = requester;
		this.receiver = receiver;
		this.state = state;
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

	@Override
	public String toString() {
		return "Friend [id=" + id + ", requester=" + requester + ", receiver=" + receiver + ", state=" + state + "]";
	}
	
	
	
}
