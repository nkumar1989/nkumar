package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
import java.util.*;
public class Lab9 {
public static void main(String[] args) {
	Scanner kb=new Scanner(System.in);
	Connection con=null;
	CallableStatement cs=null;
	System.out.println("Enter sid of the student:-");
	int sid=kb.nextInt();
	kb.nextLine();
	System.out.println("Enter name of the students:-");
	String name=kb.next();
	System.out.println("Enter fee:-");
	float fee=kb.nextFloat();
	try{
		con=JDBCutility.getOracleConnection();
		System.out.println("connection established");
		String sql="call insertStudentInfo(?,?,?)";
		cs=con.prepareCall(sql);
		cs.setInt(1, sid);
		cs.setString(2, name);
		cs.setFloat(3,fee);
		System.out.println("data set properly");
		cs.execute();
		
		
			System.out.println("procedure called sucsessfully");
		
		
	}catch(Exception ex){
		System.out.println("procedure not called");
		
		
	}finally{
		try{
			JDBCutility.cleanup(cs, con);
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
		

	}

}
