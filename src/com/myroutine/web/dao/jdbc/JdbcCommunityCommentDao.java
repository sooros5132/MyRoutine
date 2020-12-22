package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myroutine.web.dao.CommunityCommentDao;
import com.myroutine.web.dao.entity.CommunityComment;

public class JdbcCommunityCommentDao implements CommunityCommentDao{

	@Override
	public int insert(CommunityComment comment) {
//		int memberId, int community_id, int pageId, String commnet
		int result = 0;
		String url =DBContext.URL;
		String sql = "INSERT INTO community_comment(member_id, community_id, contents) VALUES(?,?,?)";		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
//			ResultSet rs = st.executeQuery(sql);	
			st.setInt(1, comment.getMemberId());
			st.setInt(2, comment.getCommunityId());
			st.setString(3, comment.getContents());
			result =  st.executeUpdate();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	@Override
	public int delete(int id) {
		int result = 0;
		
		String url =DBContext.URL;
		String sql = "DELETE FROM COMMUNITY_COMMENT WHERE ID=? ";		

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, id);
				result = st.executeUpdate();

				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		return result;
	}
	@Override
	public List<CommunityComment> getList(int communityId) {
		
		
		String url =DBContext.URL;
		String sql = "SELECT c.*, m.nickname writer_name "
				+ " FROM community_comment c"
				+ "   left join member m on m.id = c.member_id"
				+ " WHERE COMMUNITY_ID = "+communityId;

		List<CommunityComment> list = new ArrayList<>();

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				int memberId = rs.getInt("member_id"); 
				String writerName= rs.getString("writer_name");
				Date regdate = rs.getDate("regdate");
				String contents = rs.getString("contents");
				
				CommunityComment m = new CommunityComment();
					m.setId(id);
					m.setMemberId(memberId);
					m.setCommunityId(communityId);
					m.setRegdate(regdate);
					m.setContents(contents);
					m.setWriterName(writerName);

				list.add(m);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
		return list;

	}
	
}

