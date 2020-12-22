package com.myroutine.web.dao.jdbc.user.friend;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.entity.FriendView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.user.friend.Friend;
import com.myroutine.web.entity.user.member.Member;
import com.myroutine.web.service.IsNumberService;

public class JdbcFriendDao implements FriendDao {

	@Override
	public Friend get(int reqId, int recId) {
		Friend f = new Friend();
		if ( reqId == 0 || recId == 0 )
			return f;

		String url = DBContext.URL;
		String sql = "SELECT * FROM (SELECT * FROM FRIEND WHERE REQUESTER = ? AND RECEIVER = ? OR RECEIVER = ? AND REQUESTER = ? )";
		
		System.out.println("dao.jdbc.user.friend.JdbcFriendDao -> get() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reqId);
			st.setInt(2, recId);
			st.setInt(3, reqId);
			st.setInt(4, recId);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
			    int requester = rs.getInt("requester");
			    int receiver = rs.getInt("receiver");
			    int state_ = rs.getInt("state");
			    
			    f = new Friend(requester, receiver, state_);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
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
		String sql = "SELECT * FROM (SELECT * FROM FRIEND WHERE REQUESTER = ? OR RECEIVER = ? )";
		
		if( state > 0 )
			sql += String.format("WHERE STATE = %d", state);
		
		System.out.println("dao.jdbc.user.friend.JdbcFriendDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reqId);
			st.setInt(2, reqId);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
			    int requester = rs.getInt("requester");
			    int receiver = rs.getInt("receiver");
			    int state_ = rs.getInt("state");
			    
			    Friend f = new Friend(requester, receiver, state_);
			    
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
	public int delete(int reqId, int recId) {
		return delete(reqId, recId, 0);
	}
	
	@Override
	public int delete(int reqId, int recId, int state) {
		int result = 0;
		
		if( reqId == 0 || recId == 0 )
			return result;

		String url = DBContext.URL;
		String sql = String.format("DELETE FROM FRIEND "
				+ "WHERE REQUESTER = %d AND RECEIVER = %d "
				+ "OR RECEIVER = %d AND REQUESTER = %d", reqId, recId, reqId, recId);
		
		if(state != 0) {
			sql = String.format("DELETE FROM FRIEND "
				+ "WHERE REQUESTER = %d AND RECEIVER = %d AND STATE = %d", reqId, recId, state);
		}
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
	public List<FriendView> getViewList(int reqId) {
		return getViewList(reqId, 0, 1, 20);
	}

	@Override
	public List<FriendView> getViewList(int reqId, int state){
		return getViewList(reqId, 0, 1, 20);
	}
	
	@Override
	public List<FriendView> getViewList(int reqId, int state, int startIndex, int endIndex) {
		List<FriendView> list = new ArrayList<FriendView>();

		if ( reqId == 0 )
			return list;

		String url = DBContext.URL;
//		String sql = "SELECT * FROM (SELECT * FROM FRIEND_VIEW WHERE REQUESTER = ? OR RECEIVER = ? ) WHERE STATE = ?";
		String sql = 
//			  "SELECT * FROM ( "
//				+ "SELECT * FROM ( "
					"SELECT ROW_NUMBER() OVER (ORDER BY M.NICKNAME ASC) NUM, F.*, M.NICKNAME NICKNAME "
					+ "FROM ( "
						+ "SELECT F1.RECEIVER FRIEND_ID, F1.REQUESTER, F1.RECEIVER, F1.STATE FROM FRIEND F1 WHERE F1.REQUESTER = " + reqId;
		if( state != 2)
			   	   sql += " AND STATE != 2";
		if( state != 0)
				   sql += " AND STATE = " + state;
				   sql += " UNION "
						+ " SELECT F2.REQUESTER FRIEND_ID, F2.REQUESTER, F2.RECEIVER, F2.STATE FROM FRIEND F2 WHERE F2.RECEIVER = " + reqId;
		if( state != 0)
				   sql += " AND STATE = " + state;
		sql += String.format(
						" ) F "
					+ "LEFT JOIN MEMBER M ON F.FRIEND_ID = M.ID ");
//				+ ") WHERE NUM <= %d "
//			+ ")WHERE NUM >= %d", endIndex, startIndex);
		
		System.out.println("dao.jdbc.user.friend.JdbcFriendDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int friendId = rs.getInt("friend_id");
				int requester = rs.getInt("requester");
				int receiver = rs.getInt("receiver");
			    int state_ = rs.getInt("state");
			    String nickname = rs.getString("nickname");
			    
			    FriendView f = new FriendView(friendId, requester, receiver, state_, nickname);
			    
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
	public List<Member> getAddAbleMemberList(int memberId, String nickname, int startIndex, int endIndex) {
		List<Member> list = new ArrayList<Member>();
		
		if( memberId == 0 || nickname == null)
			return list;
		
		String addedMemberIds = "";
		String url = DBContext.URL;
		// 추가된 멤버들 가져오기 ===========================================================

		String sql = String.format(
				"SELECT LISTAGG(ADDED_MEMBER,',') WITHIN GROUP(ORDER BY ADDED_MEMBER) ADDED_MEMBER_IDS "
				+ "FROM ( "
				+ "    SELECT REQUESTER MEMBER_ID, RECEIVER ADDED_MEMBER FROM FRIEND WHERE REQUESTER = %d "
				+ "    UNION "
				+ "    SELECT RECEIVER MEMBER_ID, REQUESTER ADDED_MEMBER FROM FRIEND WHERE RECEIVER = %d "
				+ ") GROUP BY MEMBER_ID", memberId, memberId);

		System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> getAddAbleMemberList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {
				addedMemberIds = rs.getString("ADDED_MEMBER_IDS");
			}
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 추가 가능한 멤버들 가져오기 ========================================================
		
		sql = String.format(
			  "SELECT * FROM "
				  + "(SELECT * FROM ( "
			  		  + "SELECT ROW_NUMBER() OVER (ORDER BY NICKNAME ASC) NUM, ID, NICKNAME "
			  		  + "FROM MEMBER WHERE ID NOT IN (%s) AND NICKNAME LIKE '%%%s%%'"
		  		  + ")WHERE NUM <= %d "
			+ ") WHERE NUM >= %d", addedMemberIds, nickname, endIndex, startIndex);

		System.out.println("dao.jdbc.admin.jdbc.JdbcMemberDao -> getAddAbleMemberList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nickname_ = rs.getString("nickname");
			    
				Member m = new Member();
				
				m.setId(id);
				m.setNickname(nickname_);
				
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
}
