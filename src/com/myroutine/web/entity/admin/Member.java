package com.myroutine.web.entity.admin;

import java.sql.Date;

public class Member {
    private int id;
    private String email;
    private String name;
    private String nickname;
    private String pwd;
    private char gender;
    private Date birthday;
    private String phone;
    private Date regdate;
    private byte authority;
    private byte publicinfo;
    private byte mailauth;
    private byte receivingmail;
    private byte receivingsms;
    private Date finalconnection;
    
    // 권한 문자열로
    private String authorityString;
    private String mailauthString;
    private Boolean publicinfoBoolean;
    private Boolean receivingmailBoolean;
    private Boolean receivingsmsBoolean;
    
    public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String email, String name, String nickname, String pwd, char gender, Date birthday,
			String phone, Date regdate, byte authority, byte publicinfo, byte mailauth, byte receivingmail,
			byte receivingsms, Date finalconnection) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.pwd = pwd;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.regdate = regdate;
		this.authority = authority;
		this.publicinfo = publicinfo;
		this.mailauth = mailauth;
		this.receivingmail = receivingmail;
		this.receivingsms = receivingsms;
		this.finalconnection = finalconnection;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public byte getAuthority() {
		return authority;
	}

	public void setAuthority(byte authority) {
		this.authority = authority;
	}

	public byte getPublicinfo() {
		return publicinfo;
	}

	public void setPublicinfo(byte publicinfo) {
		this.publicinfo = publicinfo;
	}

	public byte getMailauth() {
		return mailauth;
	}

	public void setMailauth(byte mailauth) {
		this.mailauth = mailauth;
	}

	public byte getReceivingmail() {
		return receivingmail;
	}

	public void setReceivingmail(byte receivingmail) {
		this.receivingmail = receivingmail;
	}

	public byte getReceivingsms() {
		return receivingsms;
	}

	public void setReceivingsms(byte receivingsms) {
		this.receivingsms = receivingsms;
	}

	public Date getFinalconnection() {
		return finalconnection;
	}

	public void setFinalconnection(Date finalconnection) {
		this.finalconnection = finalconnection;
	}

	public String getAuthorityString() {
		return authorityString;
	}

	public void setAuthorityString(String authorityString) {
		this.authorityString = authorityString;
	}

	public String getMailauthString() {
		return mailauthString;
	}

	public void setMailauthString(String mailauthString) {
		this.mailauthString = mailauthString;
	}

	public Boolean getPublicinfoBoolean() {
		return publicinfoBoolean;
	}

	public void setPublicinfoBoolean(Boolean publicinfoBoolean) {
		this.publicinfoBoolean = publicinfoBoolean;
	}

	public Boolean getReceivingmailBoolean() {
		return receivingmailBoolean;
	}

	public void setReceivingmailBoolean(Boolean receivingmailBoolean) {
		this.receivingmailBoolean = receivingmailBoolean;
	}

	public Boolean getReceivingsmsBoolean() {
		return receivingsmsBoolean;
	}

	public void setReceivingsmsBoolean(Boolean receivingsmsBoolean) {
		this.receivingsmsBoolean = receivingsmsBoolean;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", name=" + name + ", nickname=" + nickname + ", pwd=" + pwd
				+ ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", regdate=" + regdate
				+ ", authority=" + authority + ", publicinfo=" + publicinfo + ", mailauth=" + mailauth
				+ ", receivingmail=" + receivingmail + ", receivingsms=" + receivingsms + ", finalconnection="
				+ finalconnection + ", authorityString=" + authorityString + ", mailauthString=" + mailauthString
				+ ", publicinfoBoolean=" + publicinfoBoolean + ", receivingmailBoolean=" + receivingmailBoolean
				+ ", receivingsmsBoolean=" + receivingsmsBoolean + "]";
	}

}
