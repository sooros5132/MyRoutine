package com.myroutine.web.dao.entity;

public class CommunityFile {
    private int id;
    private String name;
    private String route;
    private int communityId;
    
    public CommunityFile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param route
	 * @param communityId
	 */
	public CommunityFile(int id, String name, String route, int communityId) {
		super();
		this.id = id;
		this.name = name;
		this.route = route;
		this.communityId = communityId;
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

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	@Override
	public String toString() {
		return "CommunityFile [id=" + id + ", name=" + name + ", route=" + route + ", communityId=" + communityId + "]";
	}

	
}
