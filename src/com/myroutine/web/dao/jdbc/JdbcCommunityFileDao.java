package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.CommunityFileDao;
import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.dao.entity.CommunityFile;

public class JdbcCommunityFileDao implements CommunityFileDao {

	@Override
	public int insert(CommunityFile communityFile) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "INSERT INTO community_file(NAME,ROUTE,COMMUNITY_ID) VALUES(?,?,?)";		
		
		Community m= new Community();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, communityFile.getName());
				st.setString(2, communityFile.getRoute());
				st.setInt(3, communityFile.getCommunityId());

				result = st.executeUpdate();

				System.out.println();

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
	public int delete(int id) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM COMMUNITY_FILE WHERE ID=? ";		

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, id);
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
	public List<CommunityFile> getList(int communityId) {
		String url = DBContext.URL;
		String sql = "SELECT *  FROM COMMUNITY_FILE WHERE COMMUNITY_ID = " + communityId;	
	
		List<CommunityFile> list = new ArrayList<>();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				while(rs.next()) {
					int id = rs.getInt("id");
					String name= rs.getString("name");
					String route= rs.getString("route");
					
					CommunityFile m = new CommunityFile();
					m.setId(id);
					m.setName(name);
					m.setRoute(route);
					
					list.add(m);
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

			return list;	
	}

}
