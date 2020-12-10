package com.myroutine.web.service.admin.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myroutine.web.entity.admin.notice.Notice;

public class NoticeService {
	public List<Notice> getList() {

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";

		List<Notice> list = new ArrayList();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEAMONE", "11111");
			Statement st = con.createStatement(); //문장실행
			ResultSet rs = st.executeQuery(sql);  //결과집합
			
			while (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				String files = rs.getString("files");
				String open = rs.getString("open");
				String hits = rs.getString("hits");
				String writerId = rs.getString("writer_id");
				
				Notice n = new Notice(id,title,content,regdate,files,open,hits,writerId);
				
				list.add(n);

			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 드라이버 생성
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		return list;
	}
	
	public Notice get(int id) {
		
		Notice n = null;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID="+id;
		
		List<Notice> list = new ArrayList();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"TEAMONE", "11111");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				String files = rs.getString("files");
				String open = rs.getString("open");
				String hits = rs.getString("hits");
				String writerId = rs.getString("writer_id");
				
				n = new Notice(id,title,content,regdate,files,open,hits,writerId);
				
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

	public int insert(Notice notice) {
		int result =0;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1 ";
		String sql = "INSERT INTO NOTICE(TITLE,CONTENT) VALUES(?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"TEAMONE","11111");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getTitle());
			
			
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

}
