package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class JdbcExerciseDao implements ExerciseDao{

	@Override
	public Exercise get(int id) {
		Exercise ex = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE WHERE ID= '"+ id+"'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String name=rs.getString("name");
				String contents= rs.getString("contents");
				String recommend= rs.getNString("recommend");
				Date regDate= rs.getDate("regdate");
				String engName=rs.getNString("engname");
				int categoryId = rs.getInt("categoryId");
				int memberId = rs.getInt("memberId");
				
				
				ex=new Exercise(
						id,
					    name,
					    contents,
					    recommend,
					    regDate,
					    engName,
					    memberId,
					    categoryId
					    ) ;
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Exercise> getList() {
		List<Exercise> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE" ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name=rs.getString("name");
				String contents= rs.getString("contents");
				String recommend= rs.getNString("recommend");
				Date regDate= rs.getDate("regdate");
				String engName=rs.getNString("engname");
				int categoryId = rs.getInt("categoryId");
				int memberId = rs.getInt("memberId");

				Exercise ex = new Exercise();
						ex.setId(id);
						ex.setName(name);
						ex.setContents(contents);
						ex.setRecommend(recommend);
						ex.setRegDate(regDate);
						ex.setEngName(engName);
						ex.setCategoryId(categoryId);
						ex.setMemberId(memberId);
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
		return null;
	}

}
