package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab6 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement ps=null;
	try{
		//con=JDBCutility.getOracleConnection();
		con=JDBCutility.getMySqlConnection();
		String sql="insert into jlcstudents values(90,'samsung','s@jlc.com',6678989)";
		ps=con.prepareStatement(sql);
		int x=ps.executeUpdate();
		if(x==1){
			System.out.println("Data inserted into databases");
		}else{
			System.out.println("Data not inserted into databases");
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
		
	}finally{
		try{
			JDBCutility.cleanup(ps, con);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
		

	}

}
