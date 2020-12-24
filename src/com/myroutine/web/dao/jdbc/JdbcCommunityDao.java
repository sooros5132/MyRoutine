
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

import com.myroutine.web.dao.CommunityDao;
import com.myroutine.web.dao.entity.Community;
import com.myroutine.web.dao.entity.CommunityCategory;
import com.myroutine.web.dao.entity.CommunityReport;
import com.myroutine.web.dao.entity.CommunityView;

public class JdbcCommunityDao implements CommunityDao{

	@Override
	public int insert(Community community) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO COMMUNITY(WRITER_Id,TITLE,HIT,CONTENTS,CATEGORY_ID) VALUES(?,?,?,?,?)";		
		
		Community m= new Community();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
//				id writerId title hit  contents categoryId
//				st.setInt(1, community.getId());
				st.setInt(1, community.getWriterId());
				st.setString(2, community.getTitle());
				st.setInt(3, community.getHit());
				st.setString(4, community.getContents());
				st.setInt(5, community.getCategoryId());
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
	public int update(Community m) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE COMMUNITY SET TITLE=?, CONTENTS=?, HIT=?, CATEGORY_ID=? WHERE ID=?";		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, m.getTitle());
				st.setString(2, m.getContents());
				st.setInt(3, m.getHit());
				st.setInt(4, m.getCategoryId());
				st.setInt(5, m.getId());
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
		String sql = "DELETE FROM COMMUNITY WHERE ID=? ";		

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
	public Community getDetail(int id) {
		String url = DBContext.URL;
		String sql = "SELECT  c.*, m.nickname writer_name, cc.type category_type, cf.files_id, cf.files, cf.route file_path "
					+ " FROM COMMUNITY c"
					+ "		Left join member m on m.id =c.writer_id"
					+ "		Left join COMMUNITY_CATEGORY cc on c.category_id = cc.id"
					+ "     Left join COMMUNITY_FILE_VIEW cf on cf.community_id = c.id"
					+ " where c.id="+id;		
		
		Community m= new Community();
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
					
					m = new Community(
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
	public List<Community> getList(int startIndex, int endIndex) {

		String url = DBContext.URL;
		String sql = "select rownum, m.* "
				+ "from("
				+ "    SELECT   writer_id, title, hit, regdate,  id, category_id"
				+ "    FROM   community "
				+ "    order by regdate desc"
				+ ")m "
				+ "where rownum BETWEEN "+startIndex+" and "+endIndex;

		
		
		List<Community> list = new ArrayList<>();
		
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
					
					Community m = new Community();
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
	
	public List<CommunityCategory> getCategoryList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM COMMUNITY_CATEGORY ORDER BY ID";	
		//�����Ͱ� ������� �ȳ���,, ��񼭴� ����� ���̴µ�....�̻��ؼ� �����߰�

		
		List<CommunityCategory> list = new ArrayList<>();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
								
				while(rs.next()) {
					int id = rs.getInt("id");
					String type= rs.getString("type");
					
					CommunityCategory m = new CommunityCategory();
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
	public List<CommunityView> getViewList(int startIndex, int endIndex) {	
		
		return getViewList(startIndex, endIndex, 0, "");
	}

	@Override
	public List<CommunityView> getViewList(int startIndex, int endIndex, String value) {

		return getViewList(startIndex, endIndex, 0, value);
	}
	
	@Override
	public List<CommunityView> getViewList(int startIndex, int endIndex, int key, String value) {
		
		String url = DBContext.URL;
		String sql = "select * "
				+ "from("
				+ "    select rownum num, n.* from("
				+ "        select * from community_view"
				+ "        order by regdate desc) n"
				+ "    )list "
				+ "where num between " + startIndex + " and "+endIndex;
				if(key !=0 && value =="")
					sql+= " and list.category_id = "+key;
				if(key ==0 && value !="")
					sql+= " and list.title like '%"+value+"%'";
		 		if(key!=0 && value !="")
		 			sql+= " and list.category_id = "+key+ " and  list.title like '%"+value+"%'";
		 		System.out.println("key"+key);
//		 		if(value!=null || value !="")
//		 			sql+= " and  list.title like '%"+value+"%'"; 			
		 
		 	System.out.println(sql);	
	
		List<CommunityView> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
							
			while(rs.next()) {
				int id = rs.getInt("id");
				int writerId = rs.getInt("writer_id");
				String writerName = rs.getString("writer_name");
				int cnt= rs.getInt("cnt");
				String title = rs.getString("title");
				int hit = rs.getInt("hit");
				Date regdate = rs.getDate("regdate");
				int categoryId = rs.getInt("category_id");
				String categoryType = rs.getString("category_type");
				
				CommunityView m = new CommunityView();
				m.setId(id);
				m.setWriterId(writerId);
				m.setWriterName(writerName);
				m.setCommCount(cnt);
				m.setTitle(title);
				m.setHit(hit);
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
		String sql = "select count(*) total from community";
				
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
//	public Community getListId() {
//		String url = DBContext.URL;
//		String sql = "SELECT * FROM COMMUNITY WHERE ID = (SELECT MAX(ID) FROM COMMUNITY)";
//		//���� �ֱٰ� ���ؿ´�..
//		//���ϵ���Ҷ� ������ ������ ���ڰ� Ŀ���� ������..
//		
//		Community m= new Community();
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
//					m = new Community(
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
		String sql = "SELECT ID FROM COMMUNITY WHERE ID = (SELECT MAX(ID) FROM COMMUNITY)";
		//���� �ֱٰ� ���ؿ´�..
		//���ϵ���Ҷ� ������ ������ ���ڰ� Ŀ���� ������..
		
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
	public int reportInsert(CommunityReport communityReport) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO COMMUNITY_REPORT(MEMBER_ID,COMMUNITY_ID,CONTENTS) VALUES(?,?,?)";		
		
		Community m= new Community();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, communityReport.getMemberId());
				st.setInt(2, communityReport.getCommunityId());
				st.setString(3, communityReport.getContents());
				
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
	public int commReportInsert(CommunityReport communityReport) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO COMMUNITY_COMMENT_REPORT(MEMBER_ID,COMMENT_ID,CONTENTS) VALUES(?,?,?)";		
		
		Community m= new Community();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, communityReport.getMemberId());
				st.setInt(2, communityReport.getCommunityId());
				st.setString(3, communityReport.getContents());
				
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
	public List<CommunityReport> getReportList() {
			String url = DBContext.URL;
			String sql = "SELECT m.nickname, c.*  "
						+ " FROM community_report c "
						+ "	left join member m on m.id = c.member_id"
						+ " order by c.regdate desc ";	
			
			List<CommunityReport> list = new ArrayList<>();
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
									
					while(rs.next()) {
						int id = rs.getInt("id");
						String nickname = rs.getString("nickname");
						int memberId = rs.getInt("member_id");
						int communityId = rs.getInt("community_id");
						String contents = rs.getString("contents");
						Date regdate= rs.getDate("regdate");
						
						CommunityReport m = new CommunityReport();
						m.setId(id);
						m.setRegdate(regdate);
						m.setMemberId(memberId);
						m.setContents(contents);
						m.setCommunityId(communityId);
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
	public List<CommunityReport> getCommentReportList() {
		String url = DBContext.URL;
		String sql = "SELECT m.nickname, c.*  "
					+ " FROM community_comment_report c "
					+ "	left join member m on m.id = c.member_id"
					+ " order by c.regdate desc";	
		 System.out.println(sql);
		List<CommunityReport> list = new ArrayList<>();
		
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
					
					CommunityReport m = new CommunityReport();
					m.setId(id);
					m.setRegdate(regdate);
					m.setMemberId(memberId);
					m.setContents(contents);
					m.setCommunityId(commentId);
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
