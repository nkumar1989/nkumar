package com.jlcindia.jdbcprogram;
import java.sql.*;
import com.jlcindia.JDBCUtil.*;
public class Lab14 {
public static void main(String[] args) {
		Connection con=null;
		Statement ps=null;
		ResultSet rs=null;
		try{
			con=JDBCutility.getOracleConnection();
			String sql="select sid,sname,email,phone from jlcstudents";
			ps=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery(sql);
			System.out.println("All Records");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
			}
			System.out.println("INSERTING RECORDS");
			rs.moveToInsertRow();
			rs.updateInt(1,616); rs.updateString(2, "rewat"); rs.updateString(3, "rewat@jlc");
			rs.updateLong(4, 67879829);
			rs.insertRow();
			System.out.println("data inserted");
			System.out.println("UPDATING 2ND RECORDS");
			rs.absolute(2);
			rs.updateString(2, "manish");rs.updateString(3, "manish@jlc");rs.updateLong(4, 78547859);
		   rs.updateRow();
		   System.out.println("Records updated");
		   System.out.println("DELETING RECORDS");
		   rs.absolute(3);
		   rs.deleteRow();
		   System.out.println("Record deleted");
		   System.out.println("After all operation records are:-");
		   while(rs.next()){
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
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
