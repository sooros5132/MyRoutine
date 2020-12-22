package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.ExerciseBodyPartDao;
import com.myroutine.web.dao.entity.ExerciseBodyPartView;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;
import com.myroutine.web.entity.admin.exercise.ExerciseFile;

public class JdbcExerciseBodyPartDao implements ExerciseBodyPartDao {

	@Override
	public List<ExerciseBodyPart> getBodyPartList(int exerciseId) {
		
		System.out.println("======제이디비씨_바디파트_다오");
		List<ExerciseBodyPart> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql =	"select * from exercise_body_part where exercise_id='"+exerciseId+"'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int bodyPartId= rs.getInt("BODY_PART_ID");			
				
				ExerciseBodyPart ebp = new ExerciseBodyPart(bodyPartId, exerciseId);
				list.add(ebp);
			}
			for(ExerciseBodyPart ebp : list) {
				System.out.println(ebp);
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

	
	
	@Override
	public List<ExerciseBodyPartView> getViewBodyPartList(int exerciseId) {
		System.out.println("======제이디비씨_바디파트_뷰_다오");
		List<ExerciseBodyPartView> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql =	"select * from exercise_body_part_view "+
						"where exercise_id=1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int bodyPartId= rs.getInt("BODY_PART_ID");
				String bodyPartName = rs.getString("NAME");
				
				ExerciseBodyPartView ebpv = new ExerciseBodyPartView(bodyPartId, exerciseId,bodyPartName);
				list.add(ebpv);
			}
			for(ExerciseBodyPart ebp : list) {
				System.out.println(ebp);
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
