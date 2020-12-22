package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.NoticeFileDao;
import com.myroutine.web.entity.admin.notice.NoticeFile;

public class jdbcNoticeFileDao implements NoticeFileDao {

	@Override
	public int insert(NoticeFile noticeFile) {
       int result =0;
		
	    String url = DBContext.URL;
		String sql = "INSERT INTO NOTICE_FILE(NAME,ROUTE,NOTICE_ID) VALUES(?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, noticeFile.getName());
			st.setString(2, noticeFile.getRoute());
			st.setInt(3, noticeFile.getNoticeId());
			
			
			
			
			result = st.executeUpdate(); 
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public NoticeFile get(int id) {
        NoticeFile n = null;
		
		
		String sql = "SELECT * FROM NOTICE_FILE WHERE ID="+id;
		
		List<NoticeFile> list = new ArrayList();
		
		String url = DBContext.URL;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				String name = rs.getString("name");
				String route = rs.getString("route");
			
			
				int noticeId = rs.getInt("notice_id");
			
				
				n = new NoticeFile(id,name,route,noticeId);
				
				list.add(n);
						
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int deleteNf(int id) {
      int result =0;
		
		String url = DBContext.URL;
       String sql = "DELETE FROM NOTICE_FILE WHERE NOTICE_ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,id);
			
			result = st.executeUpdate();
			
			
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int deleteAllnf(int[] ids) {
        int result =0;
		
		String params ="";
		
		for(int i=0; i<ids.length;i++) {
			
			params += ids[i];
			
			if(i<ids.length-1)
				params +=",";
		}
		String url = DBContext.URL;
		String sql = "DELETE NOTICE_FILE WHERE NOTICE_ID IN ("+params+")";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
		     Statement st = con.createStatement();
			
			
			result = st.executeUpdate(sql);
			
			
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

}
