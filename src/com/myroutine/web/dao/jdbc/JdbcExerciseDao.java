package com.myroutine.web.dao.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myroutine.web.dao.ExerciseDao;
import com.myroutine.web.entity.admin.exercise.BodyPart;
import com.myroutine.web.entity.admin.exercise.Exercise;
import com.myroutine.web.entity.admin.exercise.ExerciseBodyPart;

public class JdbcExerciseDao implements ExerciseDao {
	
	//운동정보
	@Override
	public Exercise get(int id) {
		Exercise ex = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			
			
			if (rs.next()) {
				String name=rs.getString("NAME");
				String contents= rs.getString("CONTENTS");
				Date regdate= rs.getDate("REGDATE");
				String engName=rs.getString("ENG_NAME");
				String recommend= rs.getString("RECOMMEND");
				int memberId = rs.getInt("MEMBER_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
				
				
				System.out.println(name);
				System.out.println(contents);
				System.out.println(recommend);
				System.out.println(regdate);
				System.out.println(engName);
				System.out.println(categoryId);
				System.out.println(memberId);
				ex = new Exercise(
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
		return ex;
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
						ex.setMemberId(memberId);
						ex.setCategoryId(categoryId);
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

	
	//운동추가
	@Override
	public int insert(Exercise exercise) {
		int result=0;
		String url = DBContext.URL;
		String sql = "INSERT INTO EXERCISE(NAME, CONTENTS, REGDATE, ENG_NAME, RECOMMEND, MEMBER_ID, CATEGORY_ID) "
				+ "VALUES(?, ?, SYSTIMESTAMP, ? ,?, ?, ?)";
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

			result = st.executeUpdate(); //insert, update, delete 문장일 때			
			
			System.out.println("운동 추가 완료");
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result");

		return result;
	}


	//운동 삭제
	@Override
	public int delete(int id) {
		int result=0;
		String url = DBContext.URL;
		String sql = "DELETE FROM EXERCISE WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);
			result = st.executeUpdate(); //insert, update, delete 문장일 때
			
			st.close();
			con.close();
			System.out.println("운동 삭제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	//운동수정
	@Override
	public int update(Exercise exercise) {
		int result=0;
		String url = DBContext.URL;
		String sql = "UPDATE EXERCISE SET NAME=?, CONTENTS=?, REGDATE=SYSTIMESTAMP, ENG_NAME=?, RECOMMEND =?, MEMBER_ID = ?, CATEGORY_ID=? WHERE id = ?";
		
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
			st.setInt(7, exercise.getId());

			result = st.executeUpdate(); //insert, update, delete 문장일 때
			
			st.close();
			con.close();
			System.out.println("수정 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	//운동 ID얻기
	@Override
	public int getLast() {
		int id = 0;

		String url = DBContext.URL;
		String sql = "SELECT ROWNUM, E.* FROM (SELECT * FROM EXERCISE ORDER BY REGDATE DESC) E  WHERE ROWNUM = 1";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				id = rs.getInt("ID");
		
			}
			System.out.println("id " + id);
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return id;
	}


}
