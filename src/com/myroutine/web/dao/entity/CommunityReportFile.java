package com.myroutine.web.dao.entity;

public class CommunityReportFile {
	private int id;
	private int communityReportId;
	private String name;
	private String route;
	
	public CommunityReportFile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param communityReportId
	 * @param name
	 * @param route
	 */
	public CommunityReportFile(int id, int communityReportId, String name, String route) {
		super();
		this.id = id;
		this.communityReportId = communityReportId;
		this.name = name;
		this.route = route;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommunityReportId() {
		return communityReportId;
	}

	public void setCommunityReportId(int communityReportId) {
		this.communityReportId = communityReportId;
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

	@Override
	public String toString() {
		return "CommunityReportFile [id=" + id + ", communityReportId=" + communityReportId + ", name=" + name
				+ ", route=" + route + "]";
	}


	
	
	
}
