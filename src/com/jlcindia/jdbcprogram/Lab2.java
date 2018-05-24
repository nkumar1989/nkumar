package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab2 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try{
		//con=JDBCutility.getOracleConnection();
		con=JDBCutility.getMySqlConnection();
		String sql="select * from jlcstudents";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		}
	
		
	}catch(Exception ex){
		
		ex.printStackTrace();
	}finally{
		try{
			JDBCutility.cleanup(rs, st, con);
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
		
	}

}
