package com.priyasoft.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetMetaData {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st =con.createStatement();
			rs=st.executeQuery("select * from emp1");
			
		    java.sql.ResultSetMetaData md= rs.getMetaData();
			int count=md.getColumnCount();
			System.out.println("No of Columns\t:"+count);
			for(int i=1;i<=count;i++)
			{
				System.out.println("Column Name\t:"+md.getColumnName(i));
				System.out.println("Column Type\t:"+md.getColumnTypeName(i));
				System.out.println("Column Size\t:"+md.getColumnDisplaySize(i));
				System.out.println("-----------------------------------------------");
			}
			
			}catch(Exception e)
		    {
			e.printStackTrace();
		    }finally{
		    	try{
		    		con.close();
		    	}catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
	}

	

}
