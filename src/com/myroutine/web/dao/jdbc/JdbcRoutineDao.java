package com.myroutine.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.myroutine.web.dao.RoutineDao;
import com.myroutine.web.entity.user.routine.Routine;

public class JdbcRoutineDao implements RoutineDao {

	@Override
	public int insert(Routine routine) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO EXERCISE(id, name, regdate, excuteDate, releaseDate, regMemberId) VALUES(ROUTINE_ID_SEQ.nextval,? ,sysdate , ? ,? , ?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,routine.getName());
			
			result = st.executeUpdate(); //insert, update, delete 문장일 때
			
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

	@Override
	public int update(Routine routine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Routine> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
