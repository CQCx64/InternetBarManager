package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibm.dao.IPosDao;
import com.ibm.entity.Pos;
import com.ibm.util.JdbcUtil;

public class PosDaoImpl implements IPosDao {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	JdbcUtil ju = new JdbcUtil();

	@Override
	public Pos selectPosByID(int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_pos where posid = ? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		Pos pos = null;
		if (rs.next()) {
			pos = new Pos(rs.getInt("posid"), rs.getString("posname"), rs.getInt("price"), rs.getString("CPU"),
					rs.getString("board"), rs.getString("graphics"), rs.getString("memory"), rs.getString("SATA"),
					rs.getString("SSD"), rs.getString("monitor"));
		}
		ju.release(rs, pstm, conn);
		return pos;
	}

	@Override
	public List<Pos> selectPos() throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_pos  ";
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		List<Pos> poss = new ArrayList<>();
		
		while (rs.next()) {
			Pos pos = new Pos(rs.getInt("posid"), rs.getString("posname"), rs.getInt("price"), rs.getString("CPU"),
					rs.getString("board"), rs.getString("graphics"), rs.getString("memory"), rs.getString("SATA"),
					rs.getString("SSD"), rs.getString("monitor"));
			poss.add(pos);
		}
		ju.release(rs, pstm, conn);
		return poss;
	}

	@Override
	public void updatePos(Pos pos) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_pos set posname=?,price=?,CPU=?,board=?,graphics=?,memory=?,SATA=?,SSD=?,monitor=?  "
				+ "where posid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, pos.getName());
		pstm.setInt(2, pos.getPrice());
		pstm.setString(3, pos.getCpu());
		pstm.setString(4, pos.getBoard());
		pstm.setString(5, pos.getGraphics());
		pstm.setString(6, pos.getMemory());
		pstm.setString(7, pos.getSata());
		pstm.setString(8, pos.getSsd());
		pstm.setString(9, pos.getMonitor());
		pstm.setInt(10, pos.getId());
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

}
