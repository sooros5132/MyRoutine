package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myroutine.web.dao.ExerciseBodyPartDao;
import com.myroutine.web.dao.entity.ExerciseBodyPartView;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public class JdbcExerciseBodyPartDao implements ExerciseBodyPartDao{

	//운동 부위 등록
	@Override
	public int insert(ExerciseBodyPart exerciseBodyPart) {
		int result=0;
		String url = DBContext.URL;
		String sql = "INSERT INTO EXERCISE_BODY_PART(BODY_PART_ID, EXERCISE_ID) VALUES(?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, exerciseBodyPart.getBodyPartId());
			st.setInt(2, exerciseBodyPart.getExerciseId());

			result = st.executeUpdate(); //insert, update, delete 문장일 때			
			
			System.out.println("운동 부위 추가 완료");
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	
	//운동 부위 삭제
	@Override
	public int delete(int id) {
		int result = 0;
		String url = DBContext.URL;
		String sql = "DELETE FROM EXERCISE_BODY_PART WHERE EXERCISE_ID = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			result = st.executeUpdate(); //insert, update, delete 문장일 때			
			
			System.out.println("운동 부위 삭제 완료");
			
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}


	
	
	//운동 부위 가져오기
	@Override
	public List<ExerciseBodyPart> getList(int id) {
		System.out.println("id? " + id);
		List<ExerciseBodyPart> list = new ArrayList();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE_BODY_PART WHERE EXERCISE_ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int bodyPartId = rs.getInt("BODY_PART_ID");	
				ExerciseBodyPart ebp = new ExerciseBodyPart();
				ebp.setBodyPartId(bodyPartId);
				ebp.setExerciseId(id);
				
				list.add(ebp);	
			}
				
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}



	@Override
	public List<ExerciseBodyPart> getBodyPartList(int exerciseId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ExerciseBodyPartView> getViewBodyPartList(int exerciseId) {
		System.out.println("======제이디비씨_바디파트_뷰_다오");
		List<ExerciseBodyPartView> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql =	"select * from exercise_body_part_view "+
						"where exercise_id="+exerciseId;

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
