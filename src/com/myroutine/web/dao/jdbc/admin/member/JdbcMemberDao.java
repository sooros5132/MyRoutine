package com.myroutine.web.dao.jdbc.admin.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.IsNumberService;
import com.myroutine.web.service.TimeService;

public class JdbcMemberDao implements MemberDao {
	
	private String sqlTemp = "";
	
	@Override
	public List<Member> getList() {
		return getList(1, 20, 1, "", "", "");
	}

	@Override
	public List<Member> getList(int startIndex, int endIndex) {
		return getList(startIndex, endIndex, 1, "", "", "");
	}

	@Override
	public List<Member> getList(int startIndex, int endIndex, int rule) {
		return getList(startIndex, endIndex, rule, "", "", "");
	}

	@Override
	public List<Member> getList(int startIndex, int endIndex, String key, String value, String searchOption) {
		return getList(1, 20, 1, key, value, searchOption);
	}
	
	@Override
	public List<Member> getList(int startIndex, int endIndex, int searchRule, String key, String value, String searchOption) {
		List<Member> list = new ArrayList<>();

		String url = DBContext.URL;
//		String sql = String.format("SELECT * FROM ( SELECT ROWNUM NUM, MEMBER.* FROM MEMBER WHERE %s LIKE '%%%s%%' ORDER BY ID DESC) WHERE NUM BETWEEN %d AND %d", key, value, start, end);
		String sql = "SELECT * FROM (SELECT ROWNUM NUM, M.* FROM ( SELECT * FROM MEMBER";
		
		boolean existKeyAndValue = false;
		
		// 검색
		if(!key.equals("") && !value.equals("")) {
			if( !searchOption.equals("") ) {
				if( searchOption.toUpperCase().equals("SAME") ) {
					sql += String.format(" WHERE %s = '%s'", key, value);
					existKeyAndValue = true;
				}
			} 
			if( !existKeyAndValue ) {
				sql += String.format(" WHERE %s LIKE '%%%s%%'", key, value);
				existKeyAndValue = true;
			}
		}
		
		// 권한
		if ( searchRule != 0 ) {
			if(existKeyAndValue)
				sql += " AND";
			else
				sql += " WHERE";
			sql += String.format(" RULE = %d", searchRule);
		}

		sqlTemp = sql + " ORDER BY ID DESC) M )";
		
		// 정렬, 페이징
		sql += String.format(" ORDER BY ID DESC) M ) WHERE NUM BETWEEN %d AND %d", startIndex, endIndex);

		System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
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
				Date lastLogin = rs.getDate("last_login");
				String gender = rs.getString("gender");
			    
				Member m = new Member(id, email, name, nickname, pwd, phone, rule, regdate, birthday, openInfo, lastLogin, gender);
				
				list.add(m);
//				System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> getList() 에서 메시지 실행된 결과: \n" + m.toString());
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
	
	@Override
	public Member get(int id) {
		String url = DBContext.URL;
		String sql = "SELECT * FROM MEMBER WHERE ID = " + id;
		// ORDER BY NICNAME DESC
		// WHERE PWD = '111'
		Member m = null;
		
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
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
				Date lastLogin = rs.getDate("last_login");
				String gender = rs.getString("gender");

				m = new Member(id, email, name, nickname, pwd, phone, rule, regdate, birthday, openInfo, lastLogin, gender);
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

	@Override
	public int delete(int id) {
		int result = 0;
		
		if( id == 0 )
			return result;

		String url = DBContext.URL;
		String sql ="DELETE FROM MEMBER WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate();

//			System.out.println("JdbcMemberDao.java -> deleteMember() 에서 메시지" + rs.toString());

			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int update(int id, String key, String value) {
		int result = 0;
		
		if( id == 0 ||
			key == null || value == null ||
			key.equals("") || value.equals(""))
			return result;

		key = key.toUpperCase();
		
		String url = DBContext.URL;
		String sql;
		
		if( IsNumberService.isNumberic(value)) {
			if(key.equals("LAST_LOGIN"))
				value = String.format("TO_DATE('%s','YYYYMMDDHH24MISS')", value);
			
			sql = String.format("UPDATE MEMBER SET %s = %s WHERE ID = %d", key, value, id);
		} else {
			sql = String.format("UPDATE MEMBER SET %s = '%s' WHERE ID = %d", key, value, id);
		}
		
		System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> update() 에서 메시지 실행할 SQL문\n" + sql);
		
		// UPDATE MEMBER SET FINAL_CONNECTION = TO_DATE('20201203164741','YYYYMMDDHH24MISS') WHERE NAME = 'tester94';
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int totalCount() {
		int result = 0;

		String url = DBContext.URL;
		String sql = "SELECT COUNT(NUM) CNT FROM (" + sqlTemp + ")";
		System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> totalCount() 에서 메시지 실행할 SQL문\n" + sql);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
			rs.close();
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
