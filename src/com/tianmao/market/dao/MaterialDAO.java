package com.tianmao.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.tianmao.market.bean.Material;
import com.tianmao.market.db.DbClose;
import com.tianmao.market.db.DbConn;

/**
 * 数据库操作
 * 
 * @author Administrator
 *
 */
public class MaterialDAO {

	private static Logger logger = Logger.getLogger(MaterialDAO.class);
	
	/**
	 * 插入商品
	 * 
	 * @param material
	 */
	public boolean insertNewMaterial(Material material) {
		Connection conn = null;
		PreparedStatement preStateMent = null;
		conn = DbConn.getConn();
		boolean isSuccess = false;
		StringBuffer insertSQL = new StringBuffer();
		insertSQL.append("insert into T_IM_Material(fid,fname,fnumber,fprice) value(?,?,?,?)");
		try {
			preStateMent = conn.prepareStatement(insertSQL.toString());
			preStateMent.setString(1, material.getId());
			preStateMent.setString(2, material.getName());
			preStateMent.setString(3, material.getNumber());
			preStateMent.setInt(4, material.getPrice());

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
	 * 更新商品信息
	 * @param material
	 * @return
	 */
	public boolean updateMaterial(Material material){
		
		boolean isUpdate = false;
		Connection conn = null;
		conn = DbConn.getConn();
		PreparedStatement state = null;
		StringBuffer updateSql = new StringBuffer();
		updateSql.append("update T_IM_Material set fname = ? , fnumber = ? , fprice = ? where fid = ?");
		try {
			state = conn.prepareStatement(updateSql.toString());
			state.setString(1, material.getName());
			state.setString(2, material.getNumber());
			state.setInt(3, material.getPrice());
			state.setString(4, material.getId());
			
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
	 * 刪除商品
	 * @param material
	 * @return
	 */
	public boolean deleteMaterial(Material material){
		boolean isDelete = false;
		Connection conn = null;
		PreparedStatement preState = null;
		StringBuffer delSql = new StringBuffer();
		delSql.append("delete from T_IM_Material where fid = ?");
		
		try {
			preState = conn.prepareStatement(delSql.toString());
			preState.setString(1, material.getId());
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
