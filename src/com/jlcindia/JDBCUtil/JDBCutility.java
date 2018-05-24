package com.jlcindia.JDBCUtil;
import java.sql.*;
public class JDBCutility {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	 static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
	         }catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	 public static Connection getOracleConnection()throws SQLException{
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		 return con;
	 }
	 public static Connection getMySqlConnection()throws SQLException{
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/visa","root","root");
	     return con;
	 }
	 public static void cleanup(Statement st,Connection con)throws SQLException{
		 if(st!=null)
			 st.close();
		 if(con!=null)
			 con.close();
		 
	 }
	 public static void cleanup(ResultSet rs,Statement st,Connection con)throws SQLException{
		 if(rs!=null)
			 rs.close();
		 if(st!=null)
			 st.close();
		 if(con!=null)
			 con.close();
	 }
	

}
