package com.myroutine.web.service.admin.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myroutine.web.dao.jdbc.DBContext;
import com.myroutine.web.entity.admin.exercise.BodyPart;

public class BodyPartService {
	public List<BodyPart> getList(){
		List<BodyPart> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM Body_Part";
		
		System.out.println("바디파트 겟리스트");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				BodyPart bp = new BodyPart(id,name);
				list.add(bp);
				System.out.print(list);
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
	public BodyPart get(int id){
		BodyPart bp = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM Body_Part WHERE id = '"+id+"'";
		
		System.out.println("바디파트 겟 아이디");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");

				bp = new BodyPart(id,name);
				System.out.print(bp);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bp;
	}
}
