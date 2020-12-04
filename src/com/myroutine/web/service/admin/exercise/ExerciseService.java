package com.myroutine.web.service.admin.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.myroutine.web.entity.admin.exercise.Exercise;


public class ExerciseService {
	public List<Exercise> getList() {
		List<Exercise> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM EXERCISE" ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEAMONE", "11111");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String name=rs.getNString("name");
				String des= rs.getNString("des");
				String rec= rs.getNString("rec");
				String div1= rs.getNString("div1");
				String div2= rs.getNString("div2");
				Date regDate= rs.getDate("regdate");
				String files= rs.getString("files");
				String engName=rs.getString("engname");

				Exercise ex = new Exercise();
						ex.setName(name);
						ex.setDes(des);
						ex.setRec(rec);
						ex.setDiv1(div1);
						ex.setDiv2(div2);
						ex.setRegDate(regDate);
						ex.setFiles(files);
						ex.setEngName(engName);
//						System.out.println(ex.getName());
//						System.out.println(ex.getEngName());
						list.add(ex);
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
	public Exercise get(String name) {
		Exercise ex = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM EXERCISE WHERE NAME= '"+ name+"'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "TEAMONE", "11111");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String des= rs.getNString("des");
				String rec= rs.getNString("rec");
				String div1= rs.getNString("div1");
				String div2= rs.getNString("div2");
				Date regDate= rs.getDate("regdate");
				String files= rs.getString("files");
				String engName=rs.getString("engname");
				
				
				ex = new Exercise(
						name,
						des,
						rec,
						div1,
						div2,
						regDate,
						files,
						engName
						);

			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ex;
	}

	
	
}
