package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	//加载此类时，首先执行static括号里里面的内容
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private DB(){}
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useSSL=true");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Statement getStat(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static PreparedStatement getPStmt(Connection conn,String sql){
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pStmt;
	}
	
	public static void closeStmt(Statement stmt){	
		if(stmt!=null){
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//返回执行结果
	public static ResultSet executeQuery(Statement stmt ,String sql){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//关闭返回结果
	public static void closeResultSet(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				rs = null;
			}
		}catch (SQLException e){
				e.printStackTrace();
		}
	}

}