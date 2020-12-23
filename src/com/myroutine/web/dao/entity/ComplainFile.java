package com.myroutine.web.dao.entity;

public class ComplainFile {
    private int id;
    private String name;
    private String route;
    private int complainId;
    
    public ComplainFile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param route
	 * @param complainId
	 */
	public ComplainFile(int id, String name, String route, int complainId) {
		super();
		this.id = id;
		this.name = name;
		this.route = route;
		this.complainId = complainId;
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

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	@Override
	public String toString() {
		return "ComplainFile [id=" + id + ", name=" + name + ", route=" + route + ", complainId=" + complainId + "]";
	}
    
    
}
