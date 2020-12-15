package com.myroutine.web.dao.jdbc.user.chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.Chat;
import com.myroutine.web.service.TimeService;

public class JdbcChatDao implements ChatDao {

	@Override
	public int insert(Chat chat) {
		int result = 0;
		//
		int regMemberId = chat.getRegMemberId();
		int requester = chat.getRequester();
		String contents = chat.getContents();
		
		if( regMemberId == 0 || requester == 0 ||
			contents.equals("") )
			return result;

		String url = DBContext.URL;
		String sql =  "INSERT INTO "
					+ "CHAT(reg_member_id, requester, contents) "
					+ "VALUES(?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, regMemberId);
			st.setInt(2, requester);
			st.setString(3, contents);
			result = st.executeUpdate();
			
//			System.out.println("dao.jdbc.user.chat.JdbcChatDao -> insert() 에서 메시지" + rs.toString());

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
	public int update(int id, String field, String query) {
		int result = 0;
		
		if( id == 0 )
			return result;

		field = field.toUpperCase();
		
		String url = DBContext.URL;
		String sql = String.format(
				"UPDATE CHAT SET %s = %s WHERE ID = %d"
				, field, query, id);
		
		if( field.equals("DELETE_DATE") ) {
			TimeService.setNowDate();
			sql = String.format(
				"UPDATE CHAT SET DELETE_DATE = TO_DATE('%s','YYYYMMDDHH24MISS') WHERE ID = %d"
				, TimeService.getDateNoSeparator(), id);
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			result = st.executeUpdate();

//			System.out.println("dao.jdbc.user.chat.JdbcChatDao -> delete() 에서 메시지" + rs.toString());

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
	public int delete(int id) {
		int result = 0;
		
		if( id == 0 )
			return result;

		String url = DBContext.URL;
		String sql = "DELETE FROM CHAT WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate();

//			System.out.println("dao.jdbc.user.chat.JdbcChatDao -> delete() 에서 메시지" + rs.toString());

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
