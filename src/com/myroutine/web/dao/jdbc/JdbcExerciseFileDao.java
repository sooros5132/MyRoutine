package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	//파일 추가
	@Override
	public int insert(ExerciseFile exerciseFile) {
		int result=0;
		String url = DBContext.URL;
		String sql = "INSERT INTO EXERCISE_FILE(ID ,NAME, ROUTE, EXERCISE_ID) VALUES(EXERCISE_FILE_ID_SEQ.NEXTVAL,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, exerciseFile.getName());
			st.setString(2, exerciseFile.getRoute());
			st.setInt(3, exerciseFile.getExerciseId());


			result = st.executeUpdate(); //insert, update, delete 문장일 때			
			
			System.out.println("파일 추가 완료");
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
	
	//파일 삭제
	@Override
	public int delete(String fileNameStr, int id) {
		int result=0;
		System.out.println("fileNameStr:" + fileNameStr);
		String url = DBContext.URL;
		String sql = String.format("DELETE FROM EXERCISE_FILE WHERE ID IN((SELECT ID FROM EXERCISE_FILE WHERE EXERCISE_ID=%d AND NAME NOT IN(%s)))", id, fileNameStr);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			
			result = st.executeUpdate(sql); //insert, update, delete 문장일 때			
			
			System.out.println("파일 삭제 완료");
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
	
	
	
	//파일 삭제2
	@Override
	public int delete(int id) {
		int result=0;
		String url = DBContext.URL;
		String sql = "DELETE FROM EXERCISE_FILE WHERE EXERCISE_ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate(); //insert, update, delete 문장일 때			
			
			System.out.println("파일 삭제 완료");
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
	
	
	
	//모든 첨부 파일 삭제
	@Override
	public int deleteAll(int id) {
		int result=0;
		String url = DBContext.URL;
		String sql = "DELETE INTO EXERCISE_FILE WHERE EXERCISE_ID = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			result = st.executeUpdate(); //insert, update, delete 문장일 때			
			
			System.out.println("파일 삭제 완료");
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


	
	
	//파일 리스트 가져오기
	@Override
	public List<ExerciseFile> getList(int id) {
		List<ExerciseFile> exFileList = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE_FILE WHERE EXERCISE_ID=?" ;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int fileId = rs.getInt("ID");
				String name = rs.getString("NAME");
				String route = rs.getString("ROUTE");
				int exerciseId = rs.getInt("EXERCISE_ID");
				
				
				ExerciseFile  exFile = new ExerciseFile();
				exFile.setId(fileId);
				exFile.setName(name);
				exFile.setRoute(route);
				exFile.setExerciseId(exerciseId);
				
				exFileList.add(exFile);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return exFileList;
	}

	

}
