package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab13 {
public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try{
		con=JDBCutility.getOracleConnection();
		String sql="select * from jlcstudents";
		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery(sql);
		System.out.println("isBefore():-"+rs.isBeforeFirst());
		System.out.println("Records in forward direction");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		}
		System.out.println("Records in reverse direction");
		while(rs.previous()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		}
		System.out.println("First Record");
		rs.first();
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		System.out.println("Last Record");
		rs.last();
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
	   System.out.println("4TH record");
	   rs.absolute(4);
	   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
	    System.out.println("6th records");
	    rs.relative(2);
	    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
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
