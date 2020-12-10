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

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.Exercise;

public class JdbcExerciseDao implements ExerciseDao {
	
	//�����
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
				Date regdate= rs.getDate("regdate");
				String engName=rs.getNString("engname");
				int categoryId = rs.getInt("categoryId");
				int memberId = rs.getInt("memberId");
				
				
				ex=new Exercise(
						id,
						name,
						contents,
						regdate,
						engName,
						recommend,
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
						ex.setRegdate(regDate);
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
			st.setString(4, exercise.getRecommend());
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
			st.setString(4, exercise.getRecommend());
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
