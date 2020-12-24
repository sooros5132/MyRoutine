package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.ComplainFileDao;
import com.myroutine.web.dao.entity.Complain;
import com.myroutine.web.dao.entity.ComplainFile;

public class JdbcComplainFileDao implements ComplainFileDao {

	@Override
	public int insert(ComplainFile ComplainFile) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "INSERT INTO Complain_file(NAME,ROUTE,COMPLAIN_ID) VALUES(?,?,?)";		
		
		Complain m= new Complain();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);

				st.setString(1, ComplainFile.getName());
				st.setString(2, ComplainFile.getRoute());
				st.setInt(3, ComplainFile.getComplainId());

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
		String sql = "DELETE FROM Complain_FILE WHERE ID=? ";		

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
	public List<ComplainFile> getList(int ComplainId) {
		String url = DBContext.URL;
		String sql = "SELECT *  FROM Complain_FILE WHERE Complain_ID = " + ComplainId;	
	
		List<ComplainFile> list = new ArrayList<>();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				while(rs.next()) {
					int id = rs.getInt("id");
					String name= rs.getString("name");
					String route= rs.getString("route");
					
					ComplainFile m = new ComplainFile();
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
