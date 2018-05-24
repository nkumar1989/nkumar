package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
import java.util.*;
public class Lab5 {
public static void main(String[] args) {
	Scanner kb=new Scanner(System.in);
	Connection con=null;
	Statement st=null;
	System.out.println("Enter student id:-");
	int sid=kb.nextInt();
	System.out.println("Enter Name of the student:-");
	String name=kb.next();
	System.out.println("Enter email id of the student:-");
	String email=kb.next();
	System.out.println("Enter the phone number of the student:-");
	long ph=kb.nextLong();
	try{
		con=JDBCutility.getOracleConnection();
		String sql="insert into jlcstudents values("+sid+",'"+name+"','"+email+"',"+ph+")";
		st=con.createStatement();
		int x=st.executeUpdate(sql);
		if(x==1){
			System.out.println("data inserted into data base");
			System.out.println(sid+"\t"+name+"\t"+email+"\t"+ph);
		}else{
			System.out.println("Data not inserted");
		}
		
		}catch(Exception ex){
			ex.printStackTrace();
		
		
	}finally{
		try{
			
			JDBCutility.cleanup(st, con);
		}catch(Exception ex){
			
			
		}
	}
		
	}

}
