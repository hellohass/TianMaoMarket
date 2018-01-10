package com.tianmao.market.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DbClose {
	/**
	 * 执行数据库资源关闭
	 * @param conn
	 */
	public static void closeConn(Connection conn,PreparedStatement statement){
		if(conn != null){
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
