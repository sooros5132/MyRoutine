package com.myroutine.web.dao.jdbc.user.chat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.Member;
import com.myroutine.web.entity.user.Chat;
import com.myroutine.web.entity.user.ChatFile;

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

	@Override
	public int insert(ChatFile cf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
