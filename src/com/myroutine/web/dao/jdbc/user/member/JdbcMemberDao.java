package com.myroutine.web.dao.jdbc.user.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.IsNumberService;

public class JdbcMemberDao implements MemberDao{

	@Override
	public Member get(int id) {
		return get("id", Integer.toString(id));
	}
	
//	@Override
//	public Member getMemberByEmail(String email) {
//		Member m = null;
//
//		if( email == null || email.equals("")) {
//			return m;
//		}
//		
//		String url = DBContext.URL;
//		String sql = String.format("SELECT * FROM MEMBER WHERE EMAIL = '%s'", email);
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
//			PreparedStatement st = con.prepareStatement(sql);
//			ResultSet rs = st.executeQuery(sql);
//
//			if(rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String nickname = rs.getString("nickname");
//				String pwd = rs.getString("pwd");
//				String phone = rs.getString("phone");
//				int rule = rs.getInt("rule");
//				Date regdate = rs.getDate("regdate");
//				Date birthday = rs.getDate("birthday");
//				int openInfo = rs.getInt("open_info");
//				Date lastLogin = rs.getDate("last_login");
//				String gender = rs.getString("gender");
//			    
//				m = new Member(id, email, name, nickname, pwd, phone, rule, regdate, birthday, openInfo, lastLogin, gender);
//			}
//			st.close();
//			con.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		return m;
//	}
	
	@Override
	public Member get(String field, String query) {
		Member m = null;

		if( field == null || field.equals("") ||
			query == null || query.equals("")) {
			return m;
		}
		
		String url = DBContext.URL;
		String sql = 
			String.format(
				"SELECT * FROM MEMBER WHERE %s = '%s'",
				field, query
			);
		
		if(IsNumberService.isInteger(query))
			sql = String.format(
					"SELECT * FROM MEMBER WHERE %s = %s",
					field, query
				);
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {
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
			    
				m = new Member(id, email, name, nickname, pwd, phone, rule, regdate, birthday, openInfo, lastLogin, gender);
			}
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
	public List<Member> getList(String field, String query) {
		return getList(1, 20, field, query);
	}
	
	@Override
	public List<Member> getList(int startIndex, int endIndex, String field, String query) {
		List<Member> list = new ArrayList<Member>();
		

		String url = DBContext.URL;
		String sql = String.format("SELECT * FROM ( "
				+ "SELECT * FROM ( "
				+ "SELECT ROW_NUMBER() OVER (ORDER BY ID DESC) NUM, M.* "
				+ "FROM MEMBER M WHERE %s LIKE '%%%s%%' "
				+ ") WHERE NUM <= %d "
				+ ") WHERE NUM >= %d", field, query, endIndex, startIndex);

		System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
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
	public Member get(int id, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insert(Member m) {
		int result = 0;
		String email = m.getEmail();
		String name = m.getName();
		String nickname = m.getNickname();
		String pwd = m.getPwd();
		
		if( email.equals("") || name.equals("") ||
			nickname.equals("") || pwd.equals("") ) {
			return result;
		}

		String url = DBContext.URL;
		String sql ="INSERT INTO "
				+ "MEMBER (EMAIL, NAME, NICKNAME, PWD) "
				+ "VALUES (?, ?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, m.getEmail());
			st.setString(2, m.getName());
			st.setString(3, m.getNickname());
			st.setString(4, m.getPwd());
			result = st.executeUpdate();
			
//			System.out.println("JdbcMemberDao.java -> put() 에서 메시지" + rs.toString());

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
