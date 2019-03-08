package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibm.dao.IBarDao;
import com.ibm.entity.Bar;
import com.ibm.entity.User;
import com.ibm.util.JdbcUtil;

public class BarDaoImpl implements IBarDao {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	JdbcUtil ju = new JdbcUtil();
	@Override
	public Bar selectBarByID(int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_bar where bid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		Bar bar = null;
		if (rs.next()) {
			bar = new Bar(rs.getInt("bid"), rs.getString("bname"), rs.getString("baddress"));
		}
		ju.release(rs, pstm, conn);
		
		return bar;
	}

	@Override
	public List<Bar> selectBar() throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_bar  ";
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		List<Bar> bars = new ArrayList<>();
		while (rs.next()) {
			Bar bar = new Bar(rs.getInt("bid"), rs.getString("bname"), rs.getString("baddress"), rs.getString("x"), rs.getString("y"),rs.getString("phone"));
			bars.add(bar);
		}
		ju.release(rs, pstm, conn);
		return bars;
	}

}
