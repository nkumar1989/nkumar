package com.jlcindia.jdbcpractice;
import com.jlcindia.JDBCUtil.*;
import java.util.*;
import java.sql.*;
public class Lab1 {
	public static void main(String[] args)throws SQLException {
		Scanner kb=new Scanner(System.in);
		Connection con=null;
		PreparedStatement st=null;
		try{
			con=JDBCutility.getOracleConnection();
			System.out.println("connection is established");
			System.out.println("Enter SID of the students:-");
			int sid=kb.nextInt();
			System.out.println("Enter Student Name:-");
			String sname=kb.next();
			System.out.println("Enter Email id:-");
			String email=kb.next();
			System.out.println("Enter phone No:-");
			long phone=kb.nextLong();
			String sql="insert into student values(?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1,sid);
			st.setString(2,sname);
			st.setString(3,email);
			st.setLong(4,phone);
			int b=st.executeUpdate();
			System.out.println(b);
			System.out.println("ok...........");
			if(b==1){
				System.out.println("Records successfully inserted");
				
	             }else{
	            	 System.out.println("records not inserted");
	             }
			
		}catch(Exception ex){
			System.out.println(ex);
			JDBCutility.cleanup(st,con);
			
		}
	}

}
