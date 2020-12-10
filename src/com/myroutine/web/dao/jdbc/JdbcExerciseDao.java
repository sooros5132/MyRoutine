package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.Exercise;

public class JdbcExerciseDao implements ExerciseDao {
	
	//�����
	public Exercise get(int id) {
		Exercise exercise = null;
		
		return exercise;
	}
	
	//��߰�
	@Override
	public int insert(Exercise exercise) {
		int result=0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO EXERCISE(ID, NAME, CONTENTS, REGDATE, ENG_NAME, RECOMMAND, MEMBER_ID, CATEGORY_ID) "
				+ "VALUES(EXERCISE_ID_SEQ.nextval, ?, ?, SYSTIMESTAMP, ? ,?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, exercise.getName());
			st.setString(2, exercise.getContents());
			st.setString(3, exercise.getEngName());
			st.setString(4, exercise.getRecommand());
			st.setInt(5, exercise.getMemberId());
			st.setInt(6, exercise.getCategoryId());

			result = st.executeUpdate(); //insert, update, delete ������ ��
			
			st.close();
			con.close();
			System.out.println("� �߰� �Ϸ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	//�����
	@Override
	public int update(Exercise exercise) {
		int result=0;
		String url = DBContext.URL;
		String sql = "UPDATE EXERCISE SET NAME=?, CONTENTS=?, REGDATE=SYSTIMESTAMP, ENG_NAME=?, RECOMMAND =?, MEMBER_ID = ?, WHERE id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, exercise.getName());
			st.setString(2, exercise.getContents());
			st.setString(3, exercise.getEngName());
			st.setString(4, exercise.getRecommand());
			st.setInt(5, exercise.getMemberId());
			//st.setInt(7, exercise.getCategoryId());
			st.setInt(6, exercise.getId());

			result = st.executeUpdate(); //insert, update, delete ������ ��
			
			st.close();
			con.close();
			System.out.println("���� �Ϸ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//���� ����
	
	
	//�����߰�

}
