package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myroutine.web.dao.ExerciseFileDao;
import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;

public class JdbcExerciseFileDao implements ExerciseFileDao {

	@Override
	public List<ExerciseFile> getFileList(int exerciseId) {
		System.out.println("======제이디비씨_파일_다오");
		List<ExerciseFile> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql =	"select * from exercise_file where exercise_id='"+exerciseId+"'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id= rs.getInt("ID");
				//System.out.println("ID:"+id);
				String name = rs.getString("NAME");
				String route = rs.getString("ROUTE");
				
				ExerciseFile ef = new ExerciseFile(id,name,route,exerciseId);
				list.add(ef);
			}
			for(ExerciseFile ef : list) {
				System.out.println(ef);
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
