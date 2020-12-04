package com.myroutine.web.service.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.entity.user.Member;

public class MemberService {

	private final String dbUrl = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	private final String dbId = "TEAMONE";
	private final String dbPwd = "11111";

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
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pwd = rs.getString("pwd");
				String gender = rs.getString("gender");
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
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				String gender = rs.getString("gender");
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
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				String gender = rs.getString("gender");
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
	
	public int putMember(Member m) {
		int result = 0;
		String email = m.getEmail();
		String name = m.getName();
		String nickname = m.getNickname();
		String pwd = m.getPwd();
		Date date = new Date(System.currentTimeMillis());
		
		if( email.equals("") || name.equals("") ||
			nickname.equals("") || pwd.equals("") ) {
			return result;
		}
		
		String sql ="INSERT INTO "
				+ "MEMBER (ID, EMAIL, NAME, NICKNAME, PWD, AUTHORITY, REGDATE) "
				+ "VALUES (?, ?, ?, ?, ?, 1, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, m.getId());
			st.setString(2, m.getEmail());
			st.setString(3, m.getName());
			st.setString(4, m.getNickname());
			st.setString(5, m.getPwd());
			st.setDate(6, date);
			result = st.executeUpdate();
			
//			System.out.println("MemberService.java -> putMember() 에서 메시지" + rs.toString());

			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteMember(int id) {
		int result = 0;
		
		if( id == 0 )
			return result;
		
		String sql ="DELETE FROM MEMBER WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate();

//			System.out.println("MemberService.java -> deleteMember() 에서 메시지" + rs.toString());

			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int editMember(int id, String key, String value) {
		int result = 0;
		
		if( id == 0 ||
			key == null || value == null ||
			key.equals("") || value.equals(""))
			return result;
		
		String sql;
		if( IsNumberService.isNumberic(value) )
			sql = String.format("UPDATE MEMBER SET %s = %s WHERE ID = %d", key, value, id);
		else
			sql = String.format("UPDATE MEMBER SET %s = '%s' WHERE ID = %d", key, value, id);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);
			
			result = st.executeUpdate();
			System.out.println("admin.member.MemberService -> editMember() 에서 메시지 실행된 명령줄: " + result);

			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
