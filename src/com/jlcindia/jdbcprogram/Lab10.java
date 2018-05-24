package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab10 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	try{
		con=JDBCutility.getOracleConnection();
		st=con.createStatement();
		String sql1="insert into jlcstudents values(881,'Ramadhir','r@jlc',567678)";
		st.addBatch(sql1);
		String sql2="delete from jlcstudents where sid=882";
		st.addBatch(sql2);
		//String sql3="update into jlcstudents set sid=234 where sname='rewat'";
		//st.addBatch(sql3);
		System.out.println("queries added to the batch");
		int x[]=st.executeBatch();
		for(int i=0;i<x.length;i++){
			System.out.println(x[i]);
		}
		st.clearBatch();
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
