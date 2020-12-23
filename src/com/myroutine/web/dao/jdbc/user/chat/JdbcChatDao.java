package com.myroutine.web.dao.jdbc.user.chat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.chat.Chat;
import com.myroutine.web.service.TimeService;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcChatDao implements ChatDao {

	
	// 영향 받은 아이디값을 리턴함
	@Override
	public int insert(Chat chat) {
		int result = 0;
		//
		int regMemberId = chat.getRegMemberId();
		int requester = chat.getRequester();
		String contents = chat.getContents();
		TimeService.setNowDate();
		String nowDate = TimeService.getDateNoSeparator();
		
		if( regMemberId == 0 || requester == 0 ||
			contents.equals("") )
			return result;

		String url = DBContext.URL;
		String sql =  String.format("INSERT INTO "
					+ "CHAT(reg_member_id, requester, contents, registrantion_date) "
					+ "VALUES(%d, %d, '%s', TO_DATE('%s','YYYYMMDDHH24MISS')) RETURNING ID INTO ?", regMemberId, requester, contents, nowDate);

		System.out.println("dao.jdbc.user.chat.JdbcChatDao -> insert() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			OraclePreparedStatement st = (OraclePreparedStatement) con.prepareStatement(sql);
			st.registerReturnParameter(1, Types.INTEGER);
			
			st.execute();
			ResultSet rs = st.getReturnResultSet();
			rs.next();
			result = rs.getInt(1);
			
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
	
	@Override
	public List<ChatView> getList(int memberId, int otherMemberId) {
		return getList(memberId, otherMemberId, 1, 20, "");
	}

	@Override
	public List<ChatView> getList(int memberId, int otherMemberId, int startIndex, int endIndex) {
		return getList(memberId, otherMemberId, startIndex, endIndex, "");
	}

	@Override
	public List<ChatView> getList(int memberId, int otherMemberId, int startIndex, int endIndex, String query) {
		List<ChatView> list = new ArrayList<ChatView>();

		if ( memberId == 0 )
			return list;

		String url = DBContext.URL;
//		String sql = "SELECT * FROM ( "
//						+ "SELECT ROW_NUMBER() OVER (ORDER BY C.REGISTRANTION_DATE DESC) NUM, C.* "
//						+ "FROM CHAT_VIEW C "
//						+ "WHERE CONTENTS LIKE ? AND REG_MEMBER_ID = ? "
//						   + "OR CONTENTS LIKE ? AND REQUESTER = ? ) "
//				   + "WHERE NUM BETWEEN ? AND ?";

		String sql = String.format(
					"SELECT C.*, REG_M.NICKNAME REG_MEMBER_NAME, REQ_M.NICKNAME REQUESTER_NAME " + 
					"FROM ( " + 
						"( " + 
						"SELECT * " + 
						"FROM ( " + 
							"SELECT * " + 
							"FROM ( " + 
								"SELECT ROW_NUMBER() OVER (ORDER BY REGISTRANTION_DATE DESC) NUM, CHAT.* FROM CHAT "
								+ "WHERE REQUESTER IN (%d, %d) AND REG_MEMBER_ID IN (%d, %d) "
						  								, memberId, otherMemberId, memberId, otherMemberId);
		if( query != null && !query.equals("") )
						   	  sql += "AND CONTENTS LIKE '%" + query + "%' ";
		sql += String.format(	") WHERE NUM <= %d " + 
							") WHERE NUM >= %d " + 
						") C " + 
					"LEFT JOIN MEMBER REQ_M ON C.REQUESTER = REQ_M.ID " + 
					"LEFT JOIN MEMBER REG_M ON C.REG_MEMBER_ID = REG_M.ID " + 
					") ORDER BY REGISTRANTION_DATE ASC", endIndex, startIndex);

		System.out.println("dao.jdbc.user.chat.JdbcChatViewDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int chatId = rs.getInt("id");
			    String contents = rs.getString("contents");
			    String regMemberName = rs.getString("reg_member_name");
			    String requesterName = rs.getString("requester_name");
			    int regMemberId = rs.getInt("reg_member_id");
			    int requester = rs.getInt("requester");
			    Date registrantionDate = rs.getDate("registrantion_date");
			    Date deleteDate = rs.getDate("delete_date");
			    
				ChatView c = new ChatView(chatId, contents, regMemberName, requesterName, regMemberId, requester, registrantionDate, deleteDate);

				list.add(c);
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
	
}
