package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab12 {
public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			con=JDBCutility.getOracleConnection();
			String sql="select * from jlcstudents";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			System.out.println(rs.isBeforeFirst());
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
			    System.out.println(rs.isFirst());
			    System.out.println(rs.isAfterLast());
			    System.out.println(rs.getRow());
			}
			//.out.println(rs.isLast());
			}catch(Exception ex){
			System.out.println("operation not performed properly");
			
		}finally{
			try{
				JDBCutility.cleanup(rs, st, con);
			}catch(Exception ex){
			ex.printStackTrace();
			}
		}

	}

}
