package com.myroutine.web.dao.jdbc;

import java.io.PrintWriter;
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
import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.entity.admin.exercise.Exercise;

public class JdbcExerciseDao implements ExerciseDao {

	// 운동정보
	@Override
	public Exercise get(int id) {
		Exercise ex = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE WHERE ID= '" + id + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				String contents = rs.getString("contents");
				String recommend = rs.getNString("recommend");
				Date regdate = rs.getDate("regdate");
				String engName = rs.getNString("engname");
				int categoryId = rs.getInt("categoryId");
				int memberId = rs.getInt("memberId");

				ex = new Exercise(id, name, contents, recommend, regdate, engName, categoryId,memberId);
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
	public List<Exercise> getList(String[] parts) {
		List<Exercise> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql =null;
		switch(parts.length) {
		case 0:
			sql = "SELECT * FROM EXERCISE";
		case 1:
			sql = "SELECT * FROM EXERCISE join EXERCISE_BODY_PART on\r\n" + 
					"exercise.id = exercise_body_part.exercise_id\r\n" + 
					"where exercise_body_part.body_part_id=?";
		
		}					

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contents = rs.getString("contents");
				String recommend = rs.getNString("recommend");
				Date regDate = rs.getDate("regdate");
				String engName = rs.getNString("engname");
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
		return list;
	}

	
	
	@Override
	public List<Exercise> getList() {
		List<Exercise> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contents = rs.getString("contents");
				String recommend = rs.getNString("recommend");
				Date regDate = rs.getDate("regdate");
				String engName = rs.getNString("engname");
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

	// 운동추가
	@Override
	public int insert(Exercise exercise) {
		int result = 0;

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

			result = st.executeUpdate(); // insert, update, delete 문장일 때

			st.close();
			con.close();
			System.out.println("운동 추가 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// 운동수정
	@Override
	public int update(Exercise exercise) {
		int result = 0;
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
			// st.setInt(7, exercise.getCategoryId());
			st.setInt(6, exercise.getId());

			result = st.executeUpdate(); // insert, update, delete 문장일 때

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

	@Override
	public int delete(Exercise exercise) {
		return 0;
	}

	@Override
	public List<ExerciseView> getViewList() {
		return getViewList(); //요고 선생님 왜 여러 인자 전달 못하지
	}

	@Override
	public List<ExerciseView> getViewList(String[] parts) {
		return getViewList(parts,"TITLE","");
		
	}

	@Override
	public List<ExerciseView> getViewList(String[] parts, String title, String query) {
		List<ExerciseView> list = new ArrayList<>();
		String bodyParts = String.join(",", parts);
		
		String url = DBContext.URL;
		String sql =
				"SELECT * FROM EXERCISE"+
				"WHERE ID ="+
				"(SELECT EXERCISE_ID FROM ("+
					    "SELECT EXERCISE_ID"+ 
					    "FROM exercise_body_part"+
					    "WHERE BODY_PART_ID IN ("+bodyParts+")"+
					")"+
					"GROUP BY EXERCISE_ID"+
					"HAVING COUNT(EXERCISE_ID) ="+parts.length+")"  ; 
					

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contents = rs.getString("contents");
				String recommend = rs.getNString("recommend");
				Date regDate = rs.getDate("regdate");
				String engName = rs.getNString("eng_name");
				int categoryId = rs.getInt("category_id");
				int memberId = rs.getInt("memberId");
				String fileName = rs.getString("file_name");
				String fileRoute = rs.getNString("file_route");

				ExerciseView exv = new ExerciseView();
				exv.setId(id);
				exv.setName(name);
				exv.setContents(contents);
				exv.setRecommend(recommend);
				exv.setRegDate(regDate);
				exv.setEngName(engName);
				exv.setCategoryId(categoryId);
				exv.setMemberId(memberId);
				exv.setFileName(fileName);
				exv.setFileRoute(fileRoute);
				list.add(exv);
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
