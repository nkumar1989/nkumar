package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab16 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try{
		con=JDBCutility.getOracleConnection();
		String sql="select * from jlcstudents";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		ResultSetMetaData rmd=rs.getMetaData();
		int col=rmd.getColumnCount();
		for(int i=1;i<=col;i++){
			System.out.println(rmd.getColumnName(i)+"\t"+rmd.getColumnClassName(i)+"\t"+rmd.getTableName(i));
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
