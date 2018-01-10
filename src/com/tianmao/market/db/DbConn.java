package com.tianmao.market.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConn {
	
	private static Connection conn = null;
	private static String userName = "hasser";
	private static String pwd = "qxh123456";
	private static String url = "jdbc:mysql://127.0.0.1:3306/tianmaodb";
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url,userName,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
