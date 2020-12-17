package com.myroutine.web.entity.user.member;

import java.sql.Date;

public class MemberReport {

    private int id;
    private String contents;
    private int member_id;
    private int report_id;
    private Date regdate;
	
    public MemberReport() {
		// TODO Auto-generated constructor stub
	}

	public MemberReport(int id, String contents, int member_id, int report_id, Date regdate) {
		super();
		this.id = id;
		this.contents = contents;
		this.member_id = member_id;
		this.report_id = report_id;
		this.regdate = regdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberReport [id=" + id + ", contents=" + contents + ", member_id=" + member_id + ", report_id="
				+ report_id + ", regdate=" + regdate + "]";
	}
	
}
