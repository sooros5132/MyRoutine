package com.myroutine.web.dao.jdbc.user.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.Member;

public class JdbcMemberDao implements MemberDao{

	@Override
	public int put(Member m) {
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

	@Override
	public int login(String email, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("dao.jdbc.user.JdbcMemberDao -> login() 구현안됨");
		return 0;
	}

	@Override
	public int recoveryPwd(String email) {
		// TODO Auto-generated method stub
		System.out.println("dao.jdbc.user.JdbcMemberDao -> recoveryPwd() 구현안됨");
		return 0;
	}
	
	@Override
	public int dupCheck(String key, String value) {

		int result = 0;

		if( key == null || key.equals("") ||
			value == null || value.equals("")) {
			return result;
		}
		
		String url = DBContext.URL;
		String sql = 
			String.format(
				"SELECT ROWNUM, %s FROM MEMBER WHERE %s = '%s'",
				key, key, value
			);
		

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
	
}
