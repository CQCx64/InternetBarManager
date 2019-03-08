package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibm.dao.IAppDao;
import com.ibm.entity.App;
import com.ibm.util.JdbcUtil;

public class AppDaoImpl implements IAppDao {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	JdbcUtil ju = new JdbcUtil();
	@Override
	public List<App> selectByGroup(int group) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_app where appgroup=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, group);
		rs = pstm.executeQuery();
		App app =null;
		List<App> apps = new ArrayList<>();
		while (rs.next()) {
			app = new App(rs.getInt("appid"), rs.getString("appname"), rs.getString("icon"), rs.getString("url"), rs.getInt("appgroup"));
			apps.add(app);
		}
		ju.release(rs, pstm, conn);

		return apps;
	}

}
