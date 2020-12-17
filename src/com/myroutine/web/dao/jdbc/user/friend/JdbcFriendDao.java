package com.myroutine.web.dao.jdbc.user.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.friend.Friend;

public class JdbcFriendDao implements FriendDao {

	@Override
	public List<Friend> getList(int reqId) {
		return getList(reqId, 1);
	}
	
	@Override
	public List<Friend> getList(int reqId, int state) {
		List<Friend> list = new ArrayList<Friend>();

		if ( reqId == 0 )
			return list;

		String url = DBContext.URL;
		String sql = "SELECT * FROM (SELECT * FROM FRIEND WHERE REQUESTER = ? OR RECEIVER = ? ) WHERE STATE = ?";
		
		System.out.println("dao.jdbc.user.friend.JdbcFriendDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reqId);
			st.setInt(2, reqId);
			st.setInt(3, state);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
			    int requester = rs.getInt("requester");
			    int receiver = rs.getInt("receiver");
			    
			    Friend f = new Friend(requester, receiver, state);
			    
				list.add(f);
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
	public int insert(int reqId, int recId, int state) {
		int result = 0;
		
		if( reqId == 0 || recId == 0 )
			return result;

		String url = DBContext.URL;
		String sql =  "INSERT INTO "
					+ "FRIEND(REQUESTER, RECEIVER, state) "
					+ "VALUES(?, ?, ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reqId);
			st.setInt(2, recId);
			st.setInt(3, state);
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
	public int update(int reqId, int recId, int state) {
		int result = 0;
		
		if( reqId == 0 || recId == 0 || state == 0 )
			return result;

		String url = DBContext.URL;
		String sql = "UPDATE FRIEND SET STATE = ? "
				+ "WHERE REQUESTER = ? AND RECEIVER = ? "
				+ "OR RECEIVER = ? AND REQUESTER = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, state);
			st.setInt(2, reqId);
			st.setInt(3, recId);
			st.setInt(4, reqId);
			st.setInt(5, recId);
			
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
	public int delete(int reqId, int recId, int state) {
		int result = 0;
		
		if( reqId == 0 || recId == 0 || state == 0 )
			return result;

		String url = DBContext.URL;
		String sql = "DELETE FROM FRIEND "
				+ "WHERE REQUESTER = ? AND RECEIVER = ? "
				+ "OR RECEIVER = ? AND REQUESTER = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, state);
			st.setInt(2, reqId);
			st.setInt(3, recId);
			st.setInt(4, reqId);
			st.setInt(5, recId);
			
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
	public List<FriendView> getViewList(int reqId) {
		return getViewList(reqId, 1);
	}

	@Override
	public List<FriendView> getViewList(int reqId, int state) {
		List<FriendView> list = new ArrayList<FriendView>();

		if ( reqId == 0 )
			return list;

		String url = DBContext.URL;
//		String sql = "SELECT * FROM (SELECT * FROM FRIEND_VIEW WHERE REQUESTER = ? OR RECEIVER = ? ) WHERE STATE = ?";
		String sql = String.format("SELECT M.NICKNAME NICKNAME, F.RECEIVER ID, F.STATE STATE FROM ( "
				+ "    (SELECT F1.RECEIVER, F1.STATE FROM FRIEND F1 WHERE REQUESTER = %d "
				+ "    UNION "
				+ "    SELECT F2.REQUESTER, F2.STATE FROM FRIEND F2 WHERE RECEIVER = %d) F "
				+ "    LEFT JOIN MEMBER M ON F.RECEIVER = M.ID)", reqId, reqId);
		
		if( state != 0 )
			sql += "WHERE STATE = " + state;
		
		System.out.println("dao.jdbc.user.friend.JdbcFriendDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
			    String nickname = rs.getString("nickname");
			    
			    FriendView f = new FriendView(id, nickname, state);
			    
				list.add(f);
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
