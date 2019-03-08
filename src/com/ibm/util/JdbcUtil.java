package com.ibm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
	private Connection conn;
	
	public Connection getConnection() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/internetbarmanager";
		conn = DriverManager.getConnection(url,"root","123456");
		return conn;
	}
	
	public void release(ResultSet rs,PreparedStatement pstm,Connection conn) throws SQLException{
		
		if (rs != null) {
			rs.close();
		}
		
		if (pstm != null) {
			pstm.close();
		}
		
		if (conn != null) {
			conn.close();
		}
	}
}
