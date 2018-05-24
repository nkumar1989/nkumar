package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab15 {
public static void main(String[] args) {
	Connection con=null;
	DatabaseMetaData md=null;
	try{
		con=JDBCutility.getOracleConnection();
		md=con.getMetaData();
		System.out.println("URL:-"+md.getURL());
		System.out.println("UserName:-"+md.getUserName());
		System.out.println("Major Version:-"+md.getDatabaseMajorVersion());
		System.out.println("Minor version:-"+md.getDatabaseMinorVersion());
		System.out.println("Dtabase product:-"+md.getDatabaseProductName());
		System.out.println("Data base product Version:-"+md.getDatabaseProductVersion());
		System.out.println("Driver Version:-"+md.getDriverVersion());
		System.out.println("Driver Name:-"+md.getDriverName());
		System.out.println("Full join:-"+md.supportsFullOuterJoins());
	}catch(Exception ex){
		ex.printStackTrace();
		
	}finally{
		try{
			con.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
		
	}

}
