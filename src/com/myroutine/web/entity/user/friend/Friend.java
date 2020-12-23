package com.myroutine.web.entity.user.friend;

public class Friend {
	private int requester;
	private int receiver;
	private int state;
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}

	public Friend(int requester, int receiver, int state) {
		super();
		this.requester = requester;
		this.receiver = receiver;
		this.state = state;
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
		return "Friend [requester=" + requester + ", receiver=" + receiver + ", state=" + state + "]";
	}
	
}
