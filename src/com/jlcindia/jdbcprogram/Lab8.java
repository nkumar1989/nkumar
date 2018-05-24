package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
import java.util.*;
public class Lab8 {
public static void main(String[] args) {
	Scanner kb=new Scanner(System.in);
	Connection con=null;
	PreparedStatement ps=null;
	//ResultSet rs=null;
	System.out.println("Enter SID of the student:-");
	int sid=kb.nextInt();
	System.out.println("Enter Name of the student:-");
	String name=kb.next();
	System.out.println("Enter email id of the student:-");
	String email=kb.next();
	System.out.println("Enter phone no of the student:-");
	long ph=kb.nextLong();
	try{
		con=JDBCutility.getOracleConnection();
		String sql="insert into jlcstudents values(?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1, sid);
		ps.setString(2,name);
		ps.setString(3,email);
		ps.setLong(4,ph);
		int x=ps.executeUpdate();
		if(x==1){
			System.out.println("data inserted");
			System.out.println(sid+"\t"+name+"\t"+email+"\t"+ph);
			
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
