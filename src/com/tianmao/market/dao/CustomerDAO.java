package com.tianmao.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.tianmao.market.bean.Customer;
import com.tianmao.market.bean.Material;
import com.tianmao.market.db.DbClose;
import com.tianmao.market.db.DbConn;

public class CustomerDAO {
	
	private static Logger logger = Logger.getLogger(CustomerDAO.class);
	
	/**
	 * 插入顾客
	 * 
	 * @param material
	 */
	public boolean insertNewCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement preStateMent = null;
		conn = DbConn.getConn();
		boolean isSuccess = false;
		StringBuffer insertSQL = new StringBuffer();
		insertSQL.append("insert into T_IM_Customer(fid,fname,fnumber) value(?,?,?)");
		try {
			preStateMent = conn.prepareStatement(insertSQL.toString());
			preStateMent.setString(1, customer.getId());
			preStateMent.setString(2, customer.getName());
			preStateMent.setString(3, customer.getNumber());

			int rs = preStateMent.executeUpdate();
			if (rs > 0) {
				isSuccess = true;
			}

		} catch (SQLException e) {
			logger.warn(e);
		}finally{
			DbClose.closeConn(conn,preStateMent);
		}

		return isSuccess;
	}
	
	/**
	 * 更新顾客信息
	 * @param material
	 * @return
	 */
	public boolean updateCustomer(Customer customer){
		
		boolean isUpdate = false;
		Connection conn = null;
		conn = DbConn.getConn();
		PreparedStatement state = null;
		StringBuffer updateSql = new StringBuffer();
		updateSql.append("update T_IM_Customer set fname = ? , fnumber = ? , fcostAccount = ? where fid = ?");
		try {
			state = conn.prepareStatement(updateSql.toString());
			state.setString(1, customer.getName());
			state.setString(2, customer.getNumber());
			state.setInt(3, customer.getCostAccount());
			state.setString(4, customer.getId());
			
			int rs = state.executeUpdate();
			if(rs > 0){
				isUpdate = true;
			}
		} catch (SQLException e) {
			logger.warn(e);
		}finally{
			DbClose.closeConn(conn, state);
		}
		
		return isUpdate;
	}

	/**
	 * 刪除顾客
	 * @param material
	 * @return
	 */
	public boolean deleteCustomer(Customer customer){
		boolean isDelete = false;
		Connection conn = null;
		PreparedStatement preState = null;
		StringBuffer delSql = new StringBuffer();
		delSql.append("delete from T_IM_Customer where fid = ?");
		
		try {
			preState = conn.prepareStatement(delSql.toString());
			preState.setString(1, customer.getId());
			int rs = preState.executeUpdate();
			if(rs > 0){
				isDelete = true;
			}
		} catch (SQLException e) {
			logger.warn(e);
		}finally{
			DbClose.closeConn(conn, preState);
		}
		return isDelete;
	} 
	

}
