package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		String filepath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getFile();
		
		try {
			prop.load(new FileInputStream(filepath));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("userName"),prop.getProperty("password"));
			
			conn.setAutoCommit(false);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && ! conn.isClosed()) {
					conn.commit();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stat) {
		
		try {
			if(stat != null && !stat.isClosed()) {
				stat.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
