package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;

public class Lab4 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			con=JDBCutility.getOracleConnection();
			String sql1="select * from jlcstudents";
			st=con.createStatement();
			boolean b=st.execute(sql1);
			if(b){
				System.out.println("select query executed");
			}else{
				System.out.println("select query not executed");
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
