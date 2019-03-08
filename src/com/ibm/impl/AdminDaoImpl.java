package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibm.dao.IAdminDao;
import com.ibm.entity.Admin;
import com.ibm.util.JdbcUtil;

public class AdminDaoImpl implements IAdminDao {
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	JdbcUtil ju = new JdbcUtil();
	
	@Override
	public Admin selectAdminByName(String name) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_admin where aname = ? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
		rs = pstm.executeQuery();
		Admin admin = null;
		if (rs.next()) {
			admin = new Admin(rs.getInt("aid"), rs.getString("aname"), rs.getString("password"));
		}
		ju.release(rs, pstm, conn);
		return admin;
	}

	@Override
	public void updateAdminPwd(String password,int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_admin set password=? where aid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, password);
		pstm.setInt(2, id);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

}
