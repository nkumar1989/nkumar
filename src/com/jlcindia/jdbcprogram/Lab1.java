package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab1 {
public static void main(String[] args) {
	//this is my second commit.
	Connection con=null;
	Statement st=null;
	try{
		con=JDBCutility.getOracleConnection();
		//con=JDBCutility.getMySqlConnection();
		String sql="insert into student values(89,'Deepak','d@jlc',66874899)";
		st=con.createStatement();
		int x=st.executeUpdate(sql);
		if(x==1){
			System.out.println("Data inserted into database");
		}else{
			System.out.println("Data not inserted into database");
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
		
		
	}finally{
		try{
		JDBCutility.cleanup(st, con);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
		

	}

}
