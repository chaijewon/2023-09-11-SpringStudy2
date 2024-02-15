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
}
