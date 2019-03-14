package dao;

import java.sql.*;

public class Database {
	
	/**
	 * 通过这个方法获得对数据库的连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagingdemo?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
