package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab7 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try{
		con=JDBCutility.getOracleConnection();
		String sql="select * from jlcstudents";
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		}
		String str="insert into jlcstudents values(111,'pakistan','pak@jlc',674892209)";
		ps=con.prepareStatement(str);
		int x=ps.executeUpdate();
		if(x==1){
			System.out.println("Data inserted");
		}else{
			System.out.println("Data not inserted");
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
		
	}finally{
		try{
			JDBCutility.cleanup(rs, ps, con);
		}catch(Exception ex){
			ex.printStackTrace();
			
			
		}
	}
		
	}

}
