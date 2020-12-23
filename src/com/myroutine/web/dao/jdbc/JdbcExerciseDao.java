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
import com.myroutine.web.dao.entity.ExerciseListView;
import com.myroutine.web.dao.entity.ExerciseView;
import com.myroutine.web.entity.admin.exercise.Exercise;


public class JdbcExerciseDao implements ExerciseDao {


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

				//ex = new Exercise(id, name, contents, regdate, engName,recommend, ,memberId), categoryId;
				System.out.println(ex);
			}
			//부위를 받아와서 조인으로 생성자에 넣어
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

//	public ExerciseView getView(int id) {
//		
//		ExerciseView exv = null;		 
//		String url = DBContext.URL;
//		String sql = "SELECT de.*,e.contents FROM "+
//						"(SELECT distinct ev.id ,ev.name,ev.eng_name , ev.regdate, ev.recommend, ev.member_id, ev.category_id "+
//						",(SELECT listagg(body_part_id,',') within group (order by body_part_id) FROM (select distinct body_part_id,id from exercise_view where id='"+id+"')) body_part_id "+
//						",(SELECT listagg(file_name,',') within group (order by file_name) FROM (select distinct file_name,id from exercise_view where id='"+id+"')) file_name "+
//						",(SELECT listagg(file_route,',') within group (order by file_route) FROM (select distinct file_route,id from exercise_view where id='"+id+"')) file_route "+
//						"FROM exercise_view ev) de "+
//						"left join exercise e on e.id = de.id "+
//						"where de.id='"+id+"' ";
//		System.out.println("제디비씨다오");
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			if (rs.next()) {
//				String name = rs.getString("name");
//				String contents = rs.getString("contents");
//				Date regDate = rs.getDate("regdate");
//				String engName = rs.getString("eng_name");
//				String recommend = rs.getString("recommend");
//				int categoryId = rs.getInt("category_id");
//				int memberId = rs.getInt("member_id");
//				String bodyPartId = rs.getString("body_part_id");
//				String fileName= rs.getString("file_name");
//				String fileRoute= rs.getString("file_route");
	
//				List<String> bodyPartIdList = new ArrayList<String>(); 
//				List<String> fileNameList = new ArrayList<String>();
//				
//				String[] bodyPartIds = bodyPartId.split(",");
//				String[] fileNames = fileName.split(",");
//				
//				for(int i=0;i<bodyPartIds.length;i++)
//					bodyPartIdList.add(bodyPartIds[i]);
//				
//				for(int i=0;i<bodyPartIds.length;i++)
//					fileNameList.add(fileNames[i]);	
//				
//
//				exv = new ExerciseView(
//						id, 
//						name,
//						contents, 
//						regDate, 
//						engName,
//						recommend, 
//						categoryId,
//						memberId,
//						bodyPartIdList,
//						fileNameList,
//						fileRoute
//						);
//			}
//			//부위를 받아와서 조인으로 생성자에 넣어
//			rs.close();
//			st.close();
//			con.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return exv;
//		
//	}

	@Override
	public List<Exercise> getList() {
		List<Exercise> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE";
		
		System.out.println("제이디비씨 겟리스트");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String contents = rs.getString("contents");
				Date regdate = rs.getDate("regdate");
				String engName = rs.getNString("eng_name");
				String recommend = rs.getNString("recommend");
				int memberId = rs.getInt("member_id");
				int categoryId = rs.getInt("category_id");
				

				Exercise ex = new Exercise();
				ex.setId(id);
				ex.setName(name);
				ex.setContents(contents);
				ex.setRegdate(regdate);
				ex.setEngName(engName);
				ex.setRecommend(recommend);
				ex.setMemberId(memberId);
				ex.setCategoryId(categoryId);
				
				list.add(ex);
				System.out.print(list);
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

	// 운동추가
	@Override
	public int insert(Exercise exercise) {
		int result=0;
		String url = DBContext.URL;
		String sql = "INSERT INTO EXERCISE(ID, NAME, CONTENTS, REGDATE, ENG_NAME, RECOMMEND, MEMBER_ID, CATEGORY_ID) "
				+ "VALUES(EXERCISE_ID_SEQ.NEXTVAL,?, ?, SYSTIMESTAMP, ? ,?, ?, ?)";
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
	public List<ExerciseView> getViewList() {
		return getViewList(); //요고 선생님 왜 여러 인자 전달 못하지
	}

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


//	@Override
//	public List<ExerciseView> getViewList(String[] parts) {
//		List<ExerciseView> list = new ArrayList<>();
//		String bodyParts = String.join(",", parts);
//		
//		String url = DBContext.URL;
//		String sql = "SELECT ROWNUM, E.* FROM (SELECT * FROM EXERCISE ORDER BY REGDATE DESC) E  WHERE ROWNUM = 1";
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String contents = rs.getString("contents");
//				String recommend = rs.getNString("recommend");
//				Date regDate = rs.getDate("regdate");
//				String engName = rs.getNString("eng_name");
//				int categoryId = rs.getInt("category_id");
//				int memberId = rs.getInt("memberId");
//				String bodyPartId = rs.getString("body_part_id");
//				String fileName= rs.getString("file_name");
//				String fileRoute= rs.getString("file_route");
//				
//				List<String> bodyPartIdList = new ArrayList<String>(); 
//				List<String> fileNameList = new ArrayList<String>();
//				
//				String[] bodyPartIds = bodyPartId.split(",");
//				String[] fileNames = fileName.split(",");
//				
//				for(int i=0;i<bodyPartIds.length;i++)
//					bodyPartIdList.add(bodyPartIds[i]);
//				
//				for(int i=0;i<bodyPartIds.length;i++)
//					fileNameList.add(fileNames[i]);	
//				
//
//				ExerciseView exv = new ExerciseView(
//						id, 
//						name,
//						contents, 
//						regDate, 
//						engName,
//						recommend, 
//						categoryId,
//						memberId,
//						bodyPartIdList,
//						fileNameList,
//						fileRoute
//						);
//				System.out.println(exv);
//				list.add(exv);
//
//			}
//			System.out.println("id " + id);
//			rs.close();
//
//			st.close();
//			con.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return id;
//	}
	

//	@Override
//	public List<ExerciseView> getViewList(String[] parts, String[] files) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	//재활 리스트의 정보를 받아오는 함수
	@Override
	//재활 리스트의 정보를 받아오는 함수
	public List<ExerciseListView> getListView() {
		List<ExerciseListView> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE_LIST_VIEW WHERE CATEGORY_ID=1";
		
		System.out.println("제이디비씨 겟리스트");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId=rs.getInt("category_id");
				String efName = rs.getString("ef_name");
				String efRoute = rs.getString("ef_route");

				ExerciseListView exlv = new ExerciseListView(id,name,categoryId, efName,efRoute);
				System.out.println(list);
				list.add(exlv);
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
	
	//홈트 리스트의 정보를 받아오는 함수
	public List<ExerciseListView> getHomeListView(){
		List<ExerciseListView> list = new ArrayList<>();

		String url = DBContext.URL;
		String sql = "SELECT * FROM EXERCISE_LIST_VIEW WHERE CATEGORY_ID=2";
		
		System.out.println("제이디비씨 겟리스트");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId=rs.getInt("category_id");
				String efName = rs.getString("ef_name");
				String efRoute = rs.getString("ef_route");

				ExerciseListView exlv = new ExerciseListView(id,name,categoryId, efName,efRoute);
				System.out.println(list);
				list.add(exlv);
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
	
	//부위를 and 체크해서 운동 아이디,이름,카테고리, 파일이름,파일경로
	public List<ExerciseListView> getAndListView(String[] parts) {
		String partStrJoin=String.join(",", parts);
		
		List<ExerciseListView> list = new ArrayList<>();
		String url = DBContext.URL;
		String sql = "SELECT E.EXERCISE_ID ID, E.NAME, E.category_id, EF.NAME EF_NAME, EF.ROUTE EF_ROUTE FROM ( "+
			    "SELECT IDS.EXERCISE_ID, E.NAME,E.category_id,  MIN(EF.ID) EF_ID "+
			    "FROM ( "+
			        "SELECT EXERCISE_ID  "+
			        "FROM ( "+
			            "SELECT EXERCISE_ID "+
			            "FROM exercise_body_part "+
			            "WHERE BODY_PART_ID IN ("+partStrJoin+") "+
			        ") "+
			        "GROUP BY EXERCISE_ID "+
			        "HAVING COUNT(EXERCISE_ID) = "+parts.length +
			    ") IDS "+
			    "LEFT JOIN EXERCISE E ON E.ID = IDS.EXERCISE_ID "+
			    "LEFT JOIN EXERCISE_FILE EF ON ef.exercise_id = ids.EXERCISE_ID "+
			    "where e.category_id=1 "+
			    "GROUP BY IDS.EXERCISE_ID, E.NAME ,E.category_id"+
			") E "+
			"LEFT JOIN EXERCISE_FILE EF ON EF.ID = E.EF_ID ";
			

		System.out.println(sql);
		
		System.out.println("===운동 리스트 뷰");
		System.out.println(partStrJoin);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println(partStrJoin);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId= rs.getInt("category_id");
				String efName = rs.getString("ef_name");
				String efRoute = rs.getString("ef_route");
				System.out.println(partStrJoin);

				ExerciseListView exlv = new ExerciseListView(id,name,categoryId,efName,efRoute);
				System.out.println(exlv);
				list.add(exlv);
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
	
	//부위를 or 체크해서 운동 아이디,이름,카테고리, 파일이름,파일경로
		@Override
	public List<ExerciseListView> getOrListView(String[] parts) {
			String partStrJoin=String.join(",", parts);
			
			List<ExerciseListView> list = new ArrayList<>();
			String url = DBContext.URL;
			String sql = "SELECT E.EXERCISE_ID ID, E.NAME, E.category_id, EF.NAME EF_NAME, EF.ROUTE EF_ROUTE FROM ( "+
				    "SELECT IDS.EXERCISE_ID, E.NAME, E.category_id, MIN(EF.ID) EF_ID "+
				    "FROM ( "+
				        "SELECT EXERCISE_ID  "+
				        "FROM ( "+
				            "SELECT EXERCISE_ID "+
				            "FROM exercise_body_part "+
				            "WHERE BODY_PART_ID IN ("+partStrJoin+") "+
				        ") "+
				    ") IDS "+
				    "LEFT JOIN EXERCISE E ON E.ID = IDS.EXERCISE_ID "+
				    "LEFT JOIN EXERCISE_FILE EF ON ef.exercise_id = ids.EXERCISE_ID "+
				    "where e.category_id=1 "+
				    "GROUP BY IDS.EXERCISE_ID, E.NAME ,E.category_id"+
				") E "+
				"LEFT JOIN EXERCISE_FILE EF ON EF.ID = E.EF_ID";

			System.out.println(sql);
			
			System.out.println("===운동 or리스트 뷰");
			System.out.println(partStrJoin);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(partStrJoin);

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int categoryId= rs.getInt("category_id");
					String efName = rs.getString("ef_name");
					String efRoute = rs.getString("ef_route");
					System.out.println(partStrJoin);

					ExerciseListView exlv = new ExerciseListView(id,name,categoryId,efName,efRoute);
					System.out.println(exlv);
					list.add(exlv);
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

	
	//부위를 and 체크해서 운동 아이디,이름,카테고리, 파일이름,파일경로
	public List<ExerciseListView> getAndHomeListView(String[] parts) {
			String partStrJoin=String.join(",", parts);
			
			List<ExerciseListView> list = new ArrayList<>();
			String url = DBContext.URL;
			String sql = "SELECT E.EXERCISE_ID ID, E.NAME, E.category_id, EF.NAME EF_NAME, EF.ROUTE EF_ROUTE FROM ( "+
				    "SELECT IDS.EXERCISE_ID, E.NAME,E.category_id,  MIN(EF.ID) EF_ID "+
				    "FROM ( "+
				        "SELECT EXERCISE_ID  "+
				        "FROM ( "+
				            "SELECT EXERCISE_ID "+
				            "FROM exercise_body_part "+
				            "WHERE BODY_PART_ID IN ("+partStrJoin+") "+
				        ") "+
				        "GROUP BY EXERCISE_ID "+
				        "HAVING COUNT(EXERCISE_ID) = "+parts.length +
				    ") IDS "+
				    "LEFT JOIN EXERCISE E ON E.ID = IDS.EXERCISE_ID "+
				    "LEFT JOIN EXERCISE_FILE EF ON ef.exercise_id = ids.EXERCISE_ID "+
				    "where e.category_id=2 "+
				    "GROUP BY IDS.EXERCISE_ID, E.NAME ,E.category_id"+
				") E "+
				"LEFT JOIN EXERCISE_FILE EF ON EF.ID = E.EF_ID";

			System.out.println(sql);
			
			System.out.println("===운동 리스트 뷰");
			System.out.println(partStrJoin);
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(partStrJoin);

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int categoryId= rs.getInt("category_id");
					String efName = rs.getString("ef_name");
					String efRoute = rs.getString("ef_route");
					System.out.println(partStrJoin);

					ExerciseListView exlv = new ExerciseListView(id,name,categoryId,efName,efRoute);
					System.out.println(exlv);
					list.add(exlv);
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
	
	//부위를 or 체크해서 운동 아이디,이름,카테고리, 파일이름,파일경로
	public List<ExerciseListView> getOrHomeListView(String[] parts) {
				String partStrJoin=String.join(",", parts);
				
				List<ExerciseListView> list = new ArrayList<>();
				String url = DBContext.URL;
				String sql = "SELECT E.EXERCISE_ID ID, E.NAME, E.category_id, EF.NAME EF_NAME, EF.ROUTE EF_ROUTE FROM ( "+
					    "SELECT IDS.EXERCISE_ID, E.NAME, E.category_id, MIN(EF.ID) EF_ID "+
					    "FROM ( "+
					        "SELECT EXERCISE_ID  "+
					        "FROM ( "+
					            "SELECT EXERCISE_ID "+
					            "FROM exercise_body_part "+
					            "WHERE BODY_PART_ID IN ("+partStrJoin+") "+
					        ") "+
					    ") IDS "+
					    "LEFT JOIN EXERCISE E ON E.ID = IDS.EXERCISE_ID "+
					    "LEFT JOIN EXERCISE_FILE EF ON ef.exercise_id = ids.EXERCISE_ID "+
					    "where e.category_id=2 "+
					    "GROUP BY IDS.EXERCISE_ID, E.NAME ,E.category_id"+
					") E "+
					"LEFT JOIN EXERCISE_FILE EF ON EF.ID = E.EF_ID";

				System.out.println(sql);
				
				System.out.println("===운동 or리스트 뷰");
				System.out.println(partStrJoin);
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					System.out.println(partStrJoin);

					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int categoryId= rs.getInt("category_id");
						String efName = rs.getString("ef_name");
						String efRoute = rs.getString("ef_route");
						System.out.println(partStrJoin);

						ExerciseListView exlv = new ExerciseListView(id,name,categoryId,efName,efRoute);
						System.out.println(exlv);
						list.add(exlv);
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
	public List<Exercise> getList(String[] parts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExerciseView getView(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExerciseView> getViewList(String[] parts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExerciseView> getViewList(String[] parts, String[] files) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExerciseView> getViewList(String[] parts, String[] files, String[] routes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExerciseView> getViewList(String[] parts, String[] files, String[] routes, String title, String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
