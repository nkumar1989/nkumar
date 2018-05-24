package com.jlcindia.jdbcpractice;
import java.sql.*;
public class TestClass {
	public static void main(String[] args)throws SQLException {
		Connection con=null;
		Statement st=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			String sql="insert into student values(56,'rewat')";
			st=con.createStatement();
			int x=st.executeUpdate(sql);
			if(x==1){
				System.out.println("Record inserted");
				
			}else{
				System.out.println("please try again to insert the record");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			
			
		}finally{
			if(st!=null){
				st.close();
				
                   }
			if(con!=null){
				con.close();
				
			}
			
		}
		
	}

}
