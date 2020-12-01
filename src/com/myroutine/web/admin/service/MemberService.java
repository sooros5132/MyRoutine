package com.myroutine.web.admin.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.admin.entity.Member;

public class MemberService {

	private final String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	private final String userId = "TEAMONE";
	private final String pwd = "11111";

	public List<Member> getList() {
		return this.getList(20);
	}
	
	public List<Member> getList(int size) {
		String sql = "SELECT * FROM MEMBER WHERE rownum <= " + size;
		// ORDER BY NICNAME DESC
		// WHERE PWD = '111'
		List<Member> list = new ArrayList<>();
		
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, userId, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pwd = rs.getString("pwd");
				char gender = rs.getString("gender").charAt(0);
				Date birthday = rs.getDate("birthday");
				String phone = rs.getString("phone");
				Date regdate = rs.getDate("regdate");
				byte authority = rs.getByte("authority");
				byte publicinfo = rs.getByte("publicinfo");
				byte mailauth = rs.getByte("mailauth");
				byte receivingmail = rs.getByte("receivingmail");
				byte receivingsms = rs.getByte("receivingsms");
				Date finalconnection = rs.getDate("finalconnection");
			    
				Member m = new Member(
					id,
					email,
					name,
					nickname,
					pwd,
					gender,
					birthday,
					phone,
					regdate,
					authority,
					publicinfo,
					mailauth,
					receivingmail,
					receivingsms,
					finalconnection
				);
				if( m != null)
					translate(m);
				
				list.add(m);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	private void translate(Member m) {
		
		String authority = null;
		switch ( m.getAuthority() ) {
		case 1:
			authority = "회원";
			break;
		case 2:
			authority = "차단";
			break;
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			break;
		case 8:
			authority = "탈퇴";
			break;
		case 9:
			authority = "관리자";
			break;
		default:
			authority = "오류";
			break;
		}
		m.setAuthorityString(authority);
		
		if(m.getPublicinfo() == 0)
		    m.setPublicinfoBoolean(false);
		else
		    m.setPublicinfoBoolean(true);

		if(m.getMailauth() == 0)
		    m.setMailauthString("NO");
		else
			m.setMailauthString("YES");

		if(m.getReceivingmail() == 0)
		    m.setReceivingmailBoolean(false);
		else
		    m.setReceivingmailBoolean(true);

		if(m.getReceivingsms() == 0)
		    m.setReceivingsmsBoolean(false);
		else
		    m.setReceivingsmsBoolean(true);

	}

	public Member get(int id) {
		String sql = "SELECT * FROM MEMBER WHERE ID = " + id;
		// ORDER BY NICNAME DESC
		// WHERE PWD = '111'
		List<Member> list = new ArrayList<>();
		Member m = null;
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, userId, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				char gender = rs.getString("gender").charAt(0);
				Date birthday = rs.getDate("birthday");
				String phone = rs.getString("phone");
				Date regdate = rs.getDate("regdate");
				byte authority = rs.getByte("authority");
				byte publicinfo = rs.getByte("publicinfo");
				byte mailauth = rs.getByte("mailauth");
				byte receivingmail = rs.getByte("receivingmail");
				byte receivingsms = rs.getByte("receivingsms");
				Date finalconnection = rs.getDate("finalconnection");
			    
				m = new Member(
					id,
					name,
					email,
					nickname,
					pwd,
					gender,
					birthday,
					phone,
					regdate,
					authority,
					publicinfo,
					mailauth,
					receivingmail,
					receivingsms,
					finalconnection
				);
				if( m != null)
					translate(m);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Member searchNickName(String nickname) {
		String sql = String.format("SELECT * FROM MEMBER WHERE NICKNAME = '%s'", nickname);
		List<Member> list = new ArrayList<>();
		Member m = null;
		
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, userId, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				char gender = rs.getString("gender").charAt(0);
				Date birthday = rs.getDate("birthday");
				String phone = rs.getString("phone");
				Date regdate = rs.getDate("regdate");
				byte authority = rs.getByte("authority");
				byte publicinfo = rs.getByte("publicinfo");
				byte mailauth = rs.getByte("mailauth");
				byte receivingmail = rs.getByte("receivingmail");
				byte receivingsms = rs.getByte("receivingsms");
				Date finalconnection = rs.getDate("finalconnection");
			    
				m = new Member(
					id,
					email,
					name,
					nickname,
					pwd,
					gender,
					birthday,
					phone,
					regdate,
					authority,
					publicinfo,
					mailauth,
					receivingmail,
					receivingsms,
					finalconnection
				);
				if( m != null)
					translate(m);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return m;
	}
	
//	public String putMember(Member member) {
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICKNAME = '%s'",
//				member.getAuthority());
//		List<Member> list = new ArrayList<>();
//		Member m = null;
//		
//		try {
//			// Class.forName = 문자열을 클래스로
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, userId, pwd);
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			
//			if(rs.next()) {
//				int id = rs.getInt("id");
//				String email = rs.getString("email");
//				String name = rs.getString("name");
//				String pwd = rs.getString("pwd");
//				char gender = rs.getString("gender").charAt(0);
//				Date birthday = rs.getDate("birthday");
//				String phone = rs.getString("phone");
//				Date regdate = rs.getDate("regdate");
//				byte authority = rs.getByte("authority");
//				byte publicinfo = rs.getByte("publicinfo");
//				byte mailauth = rs.getByte("mailauth");
//				byte receivingmail = rs.getByte("receivingmail");
//				byte receivingsms = rs.getByte("receivingsms");
//				Date finalconnection = rs.getDate("finalconnection");
//			    
//				m = new Member(
//					id,
//					email,
//					name,
//					nickname,
//					pwd,
//					gender,
//					birthday,
//					phone,
//					regdate,
//					authority,
//					publicinfo,
//					mailauth,
//					receivingmail,
//					receivingsms,
//					finalconnection
//				);
//				if( m != null)
//					translate(m);
//			}
//			
//			rs.close();
//			st.close();
//			con.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return m;
//	}
}
