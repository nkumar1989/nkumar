package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab3 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try{
		con=JDBCutility.getOracleConnection();
		st=con.createStatement();
		String sql1="delete from jlcstudents where sid=89";
		int x=st.executeUpdate(sql1);
		if(x==1){
		System.out.println("required data deleted");
		}else{
			System.out.println("data not deleted");
		}
		String sql2="select * from jlcstudents";
		rs=st.executeQuery(sql2);
		System.out.println("All stored data are");
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
