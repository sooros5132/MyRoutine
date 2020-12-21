package com.myroutine.web.dao.jdbc.user.chat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.chat.Chat;
import com.myroutine.web.entity.user.chat.ChatFile;
import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.TimeService;

import oracle.jdbc.OraclePreparedStatement;

public class JdbcChatFileDao implements ChatFileDao{

	@Override
	public List<ChatFile> getList(int id) {
		return getList(id, "");
	}
	
	@Override
	public List<ChatFile> getList(int id, String query) {
		List<ChatFile> list = new ArrayList<ChatFile>();

		if ( id == 0 )
			return list;

		String url = DBContext.URL;

		String sql = String.format("SELECT * FROM CHAT_FILE WHERE CHAT_ID = ?", id);

		if(query != null && !query.equals("") )
			sql = String.format("SELECT * FROM CHAT_FILE WHERE NAME LIKE ? AND CHAT_ID = ?", query, id);
		
		System.out.println("dao.jdbc.user.chat.JdbcChatFileDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
			    String name = rs.getString("name");
			    String route = rs.getString("route");
			    int chatId = rs.getInt("chat_id");
			    
			    ChatFile c = new ChatFile(id, name, route, chatId);
			    
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

	@Override
	public List<ChatFile> getList(Set<String> idList) {
		List<ChatFile> list = new ArrayList<ChatFile>();

		if ( idList == null )
			return list;

		String url = DBContext.URL;
		String ids = String.join(",", idList);
		String sql = String.format("SELECT * FROM CHAT_FILE WHERE CHAT_ID IN (%s)", ids);

		System.out.println("dao.jdbc.user.chat.JdbcChatFileDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
			    int id = rs.getInt("id");
			    String name = rs.getString("name");
			    String route = rs.getString("route");
			    int chatId = rs.getInt("chat_id");
			    
				ChatFile cf = new ChatFile(id, name, route, chatId);

				list.add(cf);
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

	// 영향 받은 아이디값을 리턴함
	@Override
	public int insert(ChatFile cf) {
		int result = 0;
		
		if( cf == null )
			return result;

		String url = DBContext.URL;
		String sql =  String.format("INSERT INTO "
					+ "CHAT_FILE(NAME, ROUTE) "
					+ "VALUES('%s', '%s') RETURNING ID INTO ?", cf.getName(), cf.getRoute());

		System.out.println("dao.jdbc.user.chat.JdbcChatFileDao -> insert() 에서 메시지 실행할 SQL문\n" + sql);
		
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

		String url = DBContext.URL;
		String sql =  String.format("UPDATE CHAT_FILE SET %s = '%s' WHERE ID = %d", field, query, id);
		
		int chatId = 0;
		if( field.toUpperCase().equals("CHAT_ID")) {
			chatId = Integer.parseInt(query);
			sql = String.format("UPDATE CHAT_FILE SET %s = %d WHERE ID = %d", field, chatId, id);
		}

		System.out.println("dao.jdbc.user.chat.JdbcChatFileDao -> insert() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			result = st.executeUpdate(sql);
			
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
		// TODO Auto-generated method stub
		return 0;
	}

}
