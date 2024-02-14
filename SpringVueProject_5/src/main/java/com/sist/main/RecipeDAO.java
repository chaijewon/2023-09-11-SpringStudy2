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
		
	}catch(Exception ex) {}
  }
}
