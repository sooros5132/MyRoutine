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
				String phone = rs.getString("phone");
				int rule = rs.getInt("rule");
				Date regdate = rs.getDate("regdate");
				Date birthday = rs.getDate("birthday");
				int openInfo = rs.getInt("open_info");
				Date finalConnection = rs.getDate("final_connection");
				String gender = rs.getString("gender");
			    
				Member m = new Member(
				    id,
				    email,
				    name,
				    nickname,
				    pwd,
				    phone,
				    rule,
				    regdate,
				    birthday,
				    openInfo,
				    finalConnection,
				    gender
				);
				
				list.add(m);
				System.out.println(m.toString());
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
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				String pwd = rs.getString("pwd");
				String phone = rs.getString("phone");
				int rule = rs.getInt("rule");
				Date regdate = rs.getDate("regdate");
				Date birthday = rs.getDate("birthday");
				int openInfo = rs.getInt("open_info");
				Date finalConnection = rs.getDate("final_connection");
				String gender = rs.getString("gender");
			    
				m = new Member(
				    id,
				    email,
				    name,
				    nickname,
				    pwd,
				    phone,
				    rule,
				    regdate,
				    birthday,
				    openInfo,
				    finalConnection,
				    gender
				);
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
				String phone = rs.getString("phone");
				int rule = rs.getInt("rule");
				Date regdate = rs.getDate("regdate");
				Date birthday = rs.getDate("birthday");
				int openInfo = rs.getInt("open_info");
				Date finalConnection = rs.getDate("final_connection");
				String gender = rs.getString("gender");
			    
				m = new Member(
				    id,
				    email,
				    name,
				    nickname,
				    pwd,
				    phone,
				    rule,
				    regdate,
				    birthday,
				    openInfo,
				    finalConnection,
				    gender
				);
				
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
