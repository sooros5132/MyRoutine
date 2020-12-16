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

import com.myroutine.web.dao.entity.ChatView;
import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.Member;
import com.myroutine.web.entity.user.Chat;

public class JdbcChatViewDao implements ChatViewDao{

	@Override
	public List<ChatView> getList(int id) {
		return getList(id, 1, 20, "");
	}

	@Override
	public List<ChatView> getList(int id, int startIndex, int endIndex) {
		return getList(id, startIndex, endIndex, "");
	}

	@Override
	public List<ChatView> getList(int memberId, int startIndex, int endIndex, String query) {
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

		String sql = String.format("SELECT * FROM ( "
						+ "SELECT ROW_NUMBER() OVER (ORDER BY C.REGISTRANTION_DATE DESC) NUM, C.* "
						+ "FROM CHAT_VIEW C "
						+ "WHERE CONTENTS LIKE '%%%s%%' AND REG_MEMBER_ID = %d "
						   + "OR CONTENTS LIKE '%%%s%%' AND REQUESTER = %d ) "
				   + "WHERE NUM BETWEEN %d AND %d", query, memberId, query, memberId, startIndex, endIndex);

		System.out.println("dao.jdbc.user.chat.JdbcChatViewDao -> getList() 에서 메시지 실행할 SQL문\n" + sql);
		
		try {
			// Class.forName = 문자열을 클래스로
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
//			st.setString(1, query);
//			st.setInt(2, id);
//			st.setString(3, query);
//			st.setInt(4, id);
//			st.setInt(5, startIndex);
//			st.setInt(6, endIndex);
			
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
