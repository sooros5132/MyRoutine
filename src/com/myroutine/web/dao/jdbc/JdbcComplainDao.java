
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

import com.myroutine.web.dao.ComplainDao;
import com.myroutine.web.dao.entity.Complain;
import com.myroutine.web.dao.entity.ComplainCategory;
import com.myroutine.web.dao.entity.ComplainReport;
import com.myroutine.web.dao.entity.ComplainView;

public class JdbcComplainDao implements ComplainDao{

	@Override
	public int insert(Complain Complain) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO COMPLAIN(WRITER_Id,TITLE,HIT,CONTENTS,CATEGORY_ID) VALUES(?,?,?,?,?)";		
		
		Complain m= new Complain();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
//				id writerId title hit  contents categoryId
//				st.setInt(1, Complain.getId());
				st.setInt(1, Complain.getWriterId());
				st.setString(2, Complain.getTitle());
				st.setInt(3, Complain.getHit());
				st.setString(4, Complain.getContents());
				st.setInt(5, Complain.getCategoryId());
//				ResultSet rs = st.executeQuery(sql);
				
				result = st.executeUpdate();

				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

	@Override
	public int update(Complain m) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE Complain SET TITLE=?, CONTENTS=?, HIT=? WHERE ID=?";		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, m.getTitle());
				st.setString(2, m.getContents());
				st.setInt(3, m.getHit());
				st.setInt(4, m.getId());
//				ResultSet rs = st.executeQuery(sql);
				result = st.executeUpdate();

				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM Complain WHERE ID=? ";		

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, id);
				result = st.executeUpdate();

				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return result;
	}

	@Override
	public Complain getDetail(int id) {
		String url = DBContext.URL;
		String sql = "SELECT  c.*, m.nickname writer_name, cc.type category_type, cf.files_id, cf.files, cf.route file_path "
					+ " FROM Complain c"
					+ "		Left join member m on m.id =c.writer_id"
					+ "		Left join Complain_CATEGORY cc on c.category_id = cc.id"
					+ "     Left join Complain_FILE_VIEW cf on cf.Complain_id = c.id"
					+ " where c.id="+id;		
		
		Complain m= new Complain();
		System.out.println(sql);
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				if(rs.next()) {
					int writerId = rs.getInt("writer_id");
					String writerName= rs.getString("writer_name");
					String title = rs.getString("title");
					int hit = rs.getInt("hit");
					Date regdate = rs.getDate("regdate");
					String contents = rs.getString("contents");
					int categoryId = rs.getInt("category_id");
					String categoryType = rs.getString("category_type");
					String files = rs.getString("files");
					String filePath = rs.getString("file_path");
					String fileId= rs.getString("files_id");
					
					m = new Complain(
							id,
							writerId,
							writerName,
						    title,
						    hit,
						    regdate,
						    contents,
						    categoryId,
						    categoryType,
						    files,
						    filePath,
						    fileId
							);
				}
				rs.close();
				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return m;	
	}

	@Override
	public List<Complain> getList(int startIndex, int endIndex) {

		String url = DBContext.URL;
		String sql = "select rownum, m.* "
				+ "from("
				+ "    SELECT   writer_id, title, hit, regdate,  id, category_id"
				+ "    FROM   Complain "
				+ "    order by regdate desc"
				+ ")m "
				+ "where rownum BETWEEN "+startIndex+" and "+endIndex;

		
		
		List<Complain> list = new ArrayList<>();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				while(rs.next()) {
					int id = rs.getInt("id");
					int writerId = rs.getInt("writer_id");
					String title = rs.getString("title");
					int hit = rs.getInt("hit");
					Date regdate = rs.getDate("regdate");
//					String contents = rs.getString("contents");
					int categoryId = rs.getInt("category_id");
					
					Complain m = new Complain();
					m.setId(id);
					m.setWriterId(writerId);
					m.setTitle(title);
					m.setHit(hit);
					m.setRegdate(regdate);					
//					m.setContents(contents);
					m.setCategoryId(categoryId);
					
					list.add(m);
				}
				
				
				rs.close();
				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;	
	}
	
	public List<ComplainCategory> getCategoryList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM Complain_CATEGORY ORDER BY ID";	
		//데이터가 순서대로 안나옴,, 디비서는 제대로 보이는데....이상해서 정렬추가

		
		List<ComplainCategory> list = new ArrayList<>();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				while(rs.next()) {
					int id = rs.getInt("id");
					String type= rs.getString("type");
					
					ComplainCategory m = new ComplainCategory();
					m.setId(id);
					m.setType(type);
					
					list.add(m);
				}
				rs.close();
				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;	
	}
	@Override
	public List<ComplainView> getViewList(int startIndex, int endIndex) {	
		
		return getViewList(startIndex, endIndex, 0, "");
	}

	@Override
	public List<ComplainView> getViewList(int startIndex, int endIndex, String value) {

		return getViewList(startIndex, endIndex, 0, value);
	}
	
	@Override
	public List<ComplainView> getViewList(int startIndex, int endIndex, int key, String value) {
		
		String url = DBContext.URL;
		String sql = "SELECT * "
				+ "FROM("
				+ "    SELECT ROWNUM NUM, N.* FROM("
				+ "        SELECT * FROM COMPLAIN_VIEW"
				+ "        ORDER BY REGDATE DESC) N"
				+ "    )LIST "
				+ "WHERE NUM BETWEEN " + startIndex + " AND "+endIndex;
				if(key !=0 && value =="")
					sql+= " AND LIST.CATEGORY_ID = "+key;
				if(key ==0 && value !="")
					sql+= " AND LIST.TITLE LIKE '%"+value+"%'";
		 		if(key!=0 && value !="")
		 			sql+= " AND LIST.CATEGORY_ID = "+key+ " AND  LIST.TITLE LIKE '%"+value+"%'";
		 		System.out.println("key"+key);
//		 		if(value!=null || value !="")
//		 			sql+= " and  list.title like '%"+value+"%'"; 			
		 
		 	System.out.println(sql);	
	
		List<ComplainView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
							
			while(rs.next()) {
				int id = rs.getInt("id");
				int writerId = rs.getInt("writer_id");
				String writerName = rs.getString("writer_name");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				int categoryId = rs.getInt("category_id");
				String categoryType = rs.getString("category_type");
				
				ComplainView m = new ComplainView();
				m.setId(id);
				m.setWriterId(writerId);
				m.setWriterName(writerName);
				m.setTitle(title);
				m.setRegdate(regdate);					
				m.setCategoryId(categoryId);
				m.setCategoryType(categoryType);
				
				list.add(m);
			}
			
			System.out.println(list);
			
			rs.close();
			st.close();
			con.close();			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return list;
	}

	@Override
	public int getTotal(int cId) {
		String url = DBContext.URL;
		String sql = "select count(*) total from Complain";
				
				if(cId>0)
					sql += " where category_id ="+ cId;	
				
		System.out.println(sql);
				
		int result=0;
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				if(rs.next()) {
					result = rs.getInt("total");
				}
				
				rs.close();
				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;	
	}



//	@Override
//	public Complain getListId() {
//		String url = DBContext.URL;
//		String sql = "SELECT * FROM Complain WHERE ID = (SELECT MAX(ID) FROM Complain)";
//		//가장 최근것 구해온다..
//		//파일등록할때 폴더명 갈수록 숫자가 커지기 때문에..
//		
//		Complain m= new Complain();
//		
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
//				Statement st = con.createStatement();
//				ResultSet rs = st.executeQuery(sql);
//								
//				if(rs.next()) {
//					int id = rs.getInt("id");
//					int writerId = rs.getInt("writer_id");
//					String writerName= rs.getString("writer_name");
//					String title = rs.getString("title");
//					int hit = rs.getInt("hit");
//					Date regdate = rs.getDate("regdate");
//					String contents = rs.getString("contents");
//					int categoryId = rs.getInt("category_id");
////					String categoryName = rs.getString("category_name");
//					String categoryName = "";
//					
//					m = new Complain(
//							id,
//							writerId,
//							writerName,
//						    title,
//						    hit,
//						    regdate,
//						    contents,
//						    categoryId,
//						    categoryName
//							);
//				}
//				
//				rs.close();
//				st.close();
//				con.close();			
//				
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			return m;
//	}

	@Override
	public int getLast() {
		String url = DBContext.URL;
		String sql = "SELECT ID FROM Complain WHERE ID = (SELECT MAX(ID) FROM Complain)";
		//가장 최근것 구해온다..
		//파일등록할때 폴더명 갈수록 숫자가 커지기 때문에..
		
		int id = 0;
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				if(rs.next()) {
					 id = rs.getInt("id");
				}
				
				rs.close();
				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return id;
	}

	@Override
	public int reportInsert(ComplainReport ComplainReport) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO Complain_REPORT(MEMBER_ID,Complain_ID,CONTENTS) VALUES(?,?,?)";		
		
		Complain m= new Complain();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, ComplainReport.getMemberId());
				st.setInt(2, ComplainReport.getComplainId());
				st.setString(3, ComplainReport.getContents());
				
				result = st.executeUpdate();

				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

	@Override
	public int commReportInsert(ComplainReport ComplainReport) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO Complain_COMMENT_REPORT(MEMBER_ID,COMMENT_ID,CONTENTS) VALUES(?,?,?)";		
		
		Complain m= new Complain();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, ComplainReport.getMemberId());
				st.setInt(2, ComplainReport.getComplainId());
				st.setString(3, ComplainReport.getContents());
				
				result = st.executeUpdate();

				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

	@Override
	public List<ComplainReport> getReportList() {
			String url = DBContext.URL;
			String sql = "SELECT m.nickname, c.*  "
						+ " FROM Complain_report c "
						+ "	left join member m on m.id = c.member_id"
						+ " order by c.regdate";	
			
			List<ComplainReport> list = new ArrayList<>();
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
									
					while(rs.next()) {
						int id = rs.getInt("id");
						String nickname = rs.getString("nickname");
						int memberId = rs.getInt("member_id");
						int ComplainId = rs.getInt("Complain_id");
						String contents = rs.getString("contents");
						Date regdate= rs.getDate("regdate");
						
						ComplainReport m = new ComplainReport();
						m.setId(id);
						m.setRegdate(regdate);
						m.setMemberId(memberId);
						m.setContents(contents);
						m.setComplainId(ComplainId);
						m.setNickname(nickname);
						
						list.add(m);
					}
					rs.close();
					st.close();
					con.close();			
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return list;	
		}

	@Override
	public List<ComplainReport> getCommentReportList() {
		String url = DBContext.URL;
		String sql = "SELECT m.nickname, c.*  "
					+ " FROM Complain_comment_report c "
					+ "	left join member m on m.id = c.member_id"
					+ " order by c.regdate";	
		
		List<ComplainReport> list = new ArrayList<>();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				while(rs.next()) {
					int id = rs.getInt("id");
					String nickname = rs.getString("nickname");
					int memberId = rs.getInt("member_id");
					int commentId = rs.getInt("comment_id");
					String contents = rs.getString("contents");
					Date regdate= rs.getDate("regdate");
					
					ComplainReport m = new ComplainReport();
					m.setId(id);
					m.setRegdate(regdate);
					m.setMemberId(memberId);
					m.setContents(contents);
					m.setComplainId(commentId);
					m.setNickname(nickname);
					
					list.add(m);
				}
				rs.close();
				st.close();
				con.close();			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;	
	}
}
