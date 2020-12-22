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

import com.myroutine.web.dao.NoticeDao;
import com.myroutine.web.dao.entity.NoticeView;
import com.myroutine.web.entity.admin.notice.Notice;



public class JdbcNoticeDao implements NoticeDao{

	@Override
	public int insert(Notice notice) {
	int result =0;
		
	    String url = DBContext.URL;
		String sql = "INSERT INTO NOTICE(TITLE,CONTENTS,MEMBER_ID,OPEN_INFO) VALUES(?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContents());
			st.setString(3, notice.getMemberId());
			st.setBoolean(4, notice.isOpenInfo());
			
			
			
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
	public int update(Notice notice) {
		int result =0;
		String url = DBContext.URL;
        String sql = "UPDATE NOTICE SET TITLE=?, CONTENTS=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1,notice.getTitle());
			st.setString(2, notice.getContents());
			st.setInt(3, notice.getId());
			
			
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
		int result =0;
		
		String url = DBContext.URL;
       String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,id);
			
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
		
		System.out.println(result);
		return result;
	}
	
	@Override
	public int deleteAll(int[] ids) {
	int result =0;
		
		String params = "";
		
		for(int i=0; i<ids.length; i++) {
			params += ids[i];
		
		    if(i<ids.length-1)
		    	params +=",";
		}	
		
		System.out.println(params);
			String url = DBContext.URL;
	       String sql = "DELETE NOTICE WHERE ID IN ("+params+")";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			     Statement st = con.createStatement();
				
				
				result = st.executeUpdate(sql);
				
				
				st.close();
				con.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(result);
			return result;
	}

	
	

	@Override
	public Notice get(int id) {
		    Notice n = null;
			
			
			String sql = "SELECT * FROM NOTICE WHERE ID="+id;
			
			List<Notice> list = new ArrayList();
			
			String url = DBContext.URL;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				
				while(rs.next()) {
					String title = rs.getString("title");
					String contents = rs.getString("contents");
				
					boolean openInfo = rs.getBoolean("open_info");
					int hit = rs.getInt("hit");
					String memberId = rs.getString("member_id");
					Date regdate = rs.getDate("regdate");
					
					n = new Notice(id,title,contents,openInfo,hit,memberId,regdate);
					
					list.add(n);
							
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
			
			return n;
			
	}

	
	@Override
	public NoticeView getView(int id) {
	    NoticeView nw = null;
		
		
				String sql = "SELECT * FROM NOTICE_VIEW WHERE ID="+id;
				
				List<NoticeView> list = new ArrayList();
				
				String url = DBContext.URL;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
					
					while(rs.next()) {
						
						String title = rs.getString("title");
						String contents = rs.getString("contents");
						boolean openInfo = rs.getBoolean("open_info");
						String hit = rs.getString("hit");
						String memberId = rs.getString("member_id");
						Date regdate = rs.getDate("regdate");
						String fileName = rs.getString("file_name");
						String fileRoute = rs.getString("file_route");
						
						
						
				nw = new NoticeView(id,
						 title,
						 contents,
						 openInfo,
						 hit,
						memberId,
						regdate,
						fileName,
						fileRoute);
						
		        list.add(nw);
								
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
		
				return nw;
	}

	
	
	@Override
	public List<Notice> getList() {


		 return getList("TITLE","",1,10);
	}
	@Override
	public List<Notice> getList(int startIndex) {
		// TODO Auto-generated method stub
		 return getList("TITLE","",1,10);
	}
	
	@Override
	public List<Notice> getList(int page,int size) {
		
		    return getList("TITLE","",page,10);
		    
	}
	@Override
	public List<Notice> getList(String field, String query ,int page, int size) {
		 List<Notice> list = new ArrayList<Notice>();
			int start =1 +(page-1) *size;
			int end = 10*page;
			String q = "%"+query+"%";
			
			   String sql = "SELECT *FROM(SELECT ROWNUM NUM, N.* FROM" + 
			   		"(SELECT * FROM NOTICE " + 
			   		"WHERE "+field+" LIKE ?" + 
			   		"ORDER BY REGDATE DESC)N)" + 
			   		"WHERE NUM BETWEEN ? AND ?";
			   
			   String url = DBContext.URL;
			   try {
			         Class.forName("oracle.jdbc.driver.OracleDriver");
			         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			         PreparedStatement st = con.prepareStatement(sql);
			         st.setString(1,q);
			         st.setInt(2, start);
			         st.setInt(3, end);
			         
			         ResultSet rs = st.executeQuery();
			         
			        
			         
			         while(rs.next()) {
			            
			     		int id = rs.getInt("id");
						String title = rs.getString("title");
						String contents = rs.getString("contents");
					
						boolean openInfo = rs.getBoolean("open_info");
						int hit = rs.getInt("hit");
						String memberId = rs.getString("member_id");
						Date regdate = rs.getDate("regdate");
						
						Notice n = new Notice(id,title,contents,openInfo,hit,memberId,regdate);
						
						list.add(n);
			         }
			                  
			         rs.close();
			         st.close();
			         con.close();
			         
			         
			         
			      } catch (SQLException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			      } catch (ClassNotFoundException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			      }
			      System.out.println(field);
			      System.out.println(query);
			      System.out.println(start);
			      System.out.println(end);
			  
			    return list;
	}

	
	

	@Override
	public int getCount() {
		int count =0;
		
		 List<Notice> list = new ArrayList<Notice>();
			
			
			   String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
			   
			   String url = DBContext.URL;
			   try {
			         Class.forName("oracle.jdbc.driver.OracleDriver");
			         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			         Statement st = con.createStatement();
			         
			         
			         ResultSet rs = st.executeQuery(sql);
			         
			         if(rs.next())
			             count = rs.getInt("count");
			         
			    
			                  
			         rs.close();
			         st.close();
			         con.close();
			         
			         
			         
			      } catch (SQLException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			      } catch (ClassNotFoundException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			      }
		      return count;
	}

	
	
	
	@Override
	public Notice getPrev(int pid) {
		Notice notice = null;
		
		String sql ="SELECT* FROM\r\n" + 
				"(SELECT * FROM NOTICE\r\n" + 
				"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID =?)\r\n" + 
				"ORDER BY REGDATE DESC)\r\n" + 
				"WHERE ROWNUM=1";
		
		
		String url = DBContext.URL;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pid);
			
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
			
				boolean openInfo = rs.getBoolean("open_info");
				int hit = rs.getInt("hit");
				String memberId = rs.getString("member_id");
				Date regdate = rs.getDate("regdate");
				
				notice = new Notice(id,title,contents,openInfo,hit,memberId,regdate);
				
			
						
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
		return notice;
	}

	@Override
	public Notice getNext(int nid) {
		Notice notice = null;
		
		String sql ="SELECT* FROM\r\n" + 
				"(SELECT * FROM NOTICE\r\n" + 
				"WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID =?)\r\n" + 
				"ORDER BY REGDATE)\r\n" + 
				"WHERE ROWNUM=1";
		
		String url = DBContext.URL;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, nid);
			
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
			
				boolean openInfo = rs.getBoolean("open_info");
				int hit = rs.getInt("hit");
				String memberId = rs.getString("member_id");
				Date regdate = rs.getDate("regdate");
				
				notice = new Notice(id,title,contents,openInfo,hit,memberId,regdate);
				
						
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
		return notice;
	}

	@Override
	public Notice getLast() {
		 Notice n = null;
			
			
			String sql = "SELECT * FROM NOTICE WHERE ID = (SELECT MAX(ID) FROM NOTICE)";
			
			List<Notice> list = new ArrayList();
			
			String url = DBContext.URL;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
				
					boolean openInfo = rs.getBoolean("open_info");
					int hit = rs.getInt("hit");
					String memberId = rs.getString("member_id");
					Date regdate = rs.getDate("regdate");
					
					n = new Notice(id,title,contents,openInfo,hit,memberId,regdate);
					
					list.add(n);
							
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
			
			return n;
	
	}

	@Override
	public int updateHit(Notice notice) {
		int result =0;
		String url = DBContext.URL;
        String sql = "UPDATE NOTICE SET HIT=? WHERE ID=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1,notice.getHit());
			st.setInt(2, notice.getId());
			
			
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





}
