package com.sist.main;
import java.util.*;
import java.sql.*;
public class RecipeDAO {
  private Connection conn;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@localhost:1521:xe";
  public RecipeDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex) {}
  }
  public void getConnection() {
	try
	{
		 conn=DriverManager.getConnection(URL,"hr","happy");
	}catch(Exception ex) {}
  }
  public void disConnection() {
	try
	{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}catch(Exception ex) {}
  }
  public void recipeInsert(Recipe r)
  {
	  try
	  {
		 getConnection();
		 String sql="INSERT INTO recipe(no,title,poster,chef,link) "
				   +"VALUES(recipe_no_seq.nextval,?,?,?,?)";
		 ps=conn.prepareStatement(sql);
		 ps.setString(1, r.getTitle());
		 ps.setString(2, r.getPoster());
		 ps.setString(3, r.getChef());
		 ps.setString(4, r.getLink());
		 ps.executeUpdate();
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
      }
	  finally
	  {
		  disConnection();  
	  }
  }
  public void chefInsert(ChefVO vo)
  {
	  try
	  {
		  getConnection();
		  String sql="INSERT INTO chef VALUES(chef_cno_seq.nextval,?,?,?,?,?,?)";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, vo.getChef());
		  ps.setString(2, vo.getPoster());
		  ps.setInt(3, vo.getMem_cont1());
		  ps.setInt(4, vo.getMem_cont2());
		  ps.setInt(5, vo.getMem_cont3());
		  ps.setInt(6, vo.getMem_cont7());
		  ps.executeUpdate();
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();  
      }
	  finally
	  {
		  disConnection();
	  }
  }
  /*
   *   no NUMBER,
   poster VARCHAR2(300) CONSTRAINT rd_poster_nn NOT NULL,
   title VARCHAR2(1000) CONSTRAINT rd_title_nn NOT NULL,
   chef VARCHAR2(200) CONSTRAINT rd_chef_nn NOT NULL,
   chef_poster VARCHAR2(300),
   chef_profile VARCHAR2(1000),
   info1 VARCHAR2(100),
   info2 VARCHAR2(100),
   info3 VARCHAR2(100),
   content VARCHAR2(4000),
   foodmake CLOB,
   stuff CLOB
   */
  public void recipeDetailInsert(RecipeDetailVO vo)
  {
	  try
	  {
		  getConnection();
		  String sql="INSERT INTO recipeDetail VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		  ps=conn.prepareStatement(sql);
		  ps.setInt(1, vo.getNo());
		  ps.setString(2, vo.getPoster());
		  ps.setString(3, vo.getTitle());
		  ps.setString(4, vo.getChef());
		  ps.setString(5, vo.getChef_poster());
		  ps.setString(6, vo.getChef_profile());
		  ps.setString(7, vo.getInfo1());
		  ps.setString(8, vo.getInfo2());
		  ps.setString(9, vo.getInfo3());
		  ps.setString(10, vo.getContent());
		  ps.setString(11, vo.getFoodmake());
		  ps.setString(12, vo.getStuff());
		  ps.executeUpdate();
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();  
	  }
	  finally
	  {
		  disConnection();
	  }
  }
  public List<Recipe> recipeInfoData()
  {
	  List<Recipe> list=new ArrayList<Recipe>();
	  try
	  {
		  getConnection();
		  String sql="SELECT no,link FROM recipe";
		  ps=conn.prepareStatement(sql);
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  Recipe r=new Recipe();
			  r.setNo(rs.getInt(1));
			  r.setLink(rs.getString(2));
			  
			  list.add(r);
		  }
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();  
	  }
	  finally
	  {
		  disConnection();
	  }
	  return list;
  }
}
