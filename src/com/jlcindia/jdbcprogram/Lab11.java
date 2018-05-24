package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab11 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement st=null;
	try{
		con=JDBCutility.getOracleConnection();
		String sql="insert into jlcstudents values(?,?,?,?)";
		st=con.prepareStatement(sql);
		st.setInt(1, 208);
		st.setString(2, "raju");
		st.setString(3,"ra@jlc");
		st.setLong(4, 7688723);
		st.addBatch();
		st.setInt(1, 209);
		st.setString(2, "raju");
		st.setString(3,"ra@jlc");
		st.setLong(4, 7688723);
		st.addBatch();
		System.out.println("queries added to the batch");
		int x[]=st.executeBatch();
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
		st.clearParameters();
		System.out.println("batch is cleared");
		
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
