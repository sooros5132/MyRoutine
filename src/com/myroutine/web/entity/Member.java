package com.myroutine.web.entity;

import java.sql.Date;

public class Member {
    private int id;
    private String email;
    private String name;
    private String nickname;
    private String pwd;
    private String phone;
    private int rule;
    private Date regdate;
    private Date birthday;
    private int openInfo;
    private Date finalConnection;
    private String gender;
    
    public Member() {
		// TODO Auto-generated constructor stub
	}

    // 회원가입 때
    public Member(String email, String name, String nickname, String pwd) {
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.pwd = pwd;
    }

	public Member(int id, String email, String name, String nickname, String pwd, String phone, int rule, Date regdate,
			Date birthday, int openInfo, Date finalConnection, String gender) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.pwd = pwd;
		this.phone = phone;
		this.rule = rule;
		this.regdate = regdate;
		this.birthday = birthday;
		this.openInfo = openInfo;
		this.finalConnection = finalConnection;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getOpenInfo() {
		return openInfo;
	}

	public void setOpenInfo(int openInfo) {
		this.openInfo = openInfo;
	}

	public Date getFinalConnection() {
		return finalConnection;
	}

	public void setFinalConnection(Date finalConnection) {
		this.finalConnection = finalConnection;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", name=" + name + ", nickname=" + nickname + ", pwd=" + pwd
				+ ", phone=" + phone + ", rule=" + rule + ", regdate=" + regdate + ", birthday=" + birthday
				+ ", openInfo=" + openInfo + ", finalConnection=" + finalConnection + ", gender=" + gender + "]";
	}
    
}
