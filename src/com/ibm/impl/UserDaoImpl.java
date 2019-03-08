package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.dao.IComDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Com;
import com.ibm.entity.User;
import com.ibm.util.JdbcUtil;
import com.sun.corba.se.impl.protocol.CorbaMessageMediatorImpl;

public class UserDaoImpl implements IUserDao {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	JdbcUtil ju = new JdbcUtil();

	@Override
	public void insertUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "insert into tbl_user (uname,sex,age,registerdate,idnumber,phone,money) "
				+ "values (?,?,?,?,?,?,?) ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getSex());
		pstm.setInt(3, user.getAge());
		pstm.setDate(4, new java.sql.Date(user.getRegisterdate().getTime()));
		pstm.setString(5, user.getIdnumber());
		pstm.setString(6, user.getPhone());
		pstm.setInt(7, user.getMoney());
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_user set uname=?,sex=?,age=?,registerdate=?,idnumber=?,phone=?,money=? "
				+ "where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getSex());
		pstm.setInt(3, user.getAge());
		pstm.setDate(4, new java.sql.Date(user.getRegisterdate().getTime()));
		pstm.setString(5, user.getIdnumber());
		pstm.setString(6, user.getPhone());
		pstm.setInt(7, user.getMoney());
		pstm.setInt(8, user.getId());
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "delete from tbl_user where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public User selectUserByID(int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_user where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("sex"), rs.getInt("age"),
					rs.getDate("registerdate"), rs.getString("idnumber"), rs.getString("phone"), rs.getDate("lastdate"),
					rs.getInt("money"));
		}
		ju.release(rs, pstm, conn);

		return user;
	}

	@Override
	public List<User> selectUserByCondition(int id, String name) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_user where 1=1   ";
		if (name != null && !"".equals(name.trim())) {
			sql += "  and uname like '%" + name + "%'  ";
		}
		if (id != 0) {
			sql += "  and uid = " + id;
		}

		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("sex"), rs.getInt("age"),
					rs.getDate("registerdate"), rs.getString("idnumber"), rs.getString("phone"), rs.getDate("lastdate"),
					rs.getInt("money"));
			users.add(user);
		}
		ju.release(rs, pstm, conn);

		return users;
	}

	@Override
	public int getUserNum() throws Exception {
		// TODO 自动生成的方法存根
		int num = 0;
		conn = ju.getConnection();
		String sql = "select * from tbl_user ";
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next()) {
			num++;
		}
		ju.release(rs, pstm, conn);
		return num;
	}

	@Override
	public int getUserMoneyByID(int id) throws Exception {
		// TODO 自动生成的方法存根
		int money = 0;
		conn = ju.getConnection();
		String sql = "select money from tbl_user where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		while (rs.next()) {
			money = rs.getInt("money");
		}
		ju.release(rs, pstm, conn);
		return money;
	}

	@Override
	public void changeUserCanUseByID(int id, int status) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_user set canuse=? " + "where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, status);
		pstm.setInt(2, id);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void updateLastDate(int id) throws Exception {
		// TODO 自动生成的方法存根
		java.util.Date time = new Date();
		java.sql.Date sqlDate = new java.sql.Date(time.getTime());
		conn = ju.getConnection();
		String sql = "update tbl_user set lastdate=? " + "where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setDate(1, sqlDate);
		pstm.setInt(2, id);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);

	}

	@Override
	public User selectUserByIDNumber(String idNumber) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_user where idnumber=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, idNumber);
		rs = pstm.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("sex"), rs.getInt("age"),
					rs.getDate("registerdate"), rs.getString("idnumber"), rs.getString("phone"), rs.getDate("lastdate"),
					rs.getInt("money"));
		}
		ju.release(rs, pstm, conn);

		return user;
	}

	@Override
	public int getUserCanUseByIDNumber(String idnumber) throws Exception {
		// TODO 自动生成的方法存根
		int canuse = 0;
		conn = ju.getConnection();
		String sql = "select canuse from tbl_user where idnumber=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, idnumber);
		rs = pstm.executeQuery();
		while (rs.next()) {
			canuse = rs.getInt("canuse");
		}
		ju.release(rs, pstm, conn);
		return canuse;
	}

	@Override
	public void rechargeByID(int id, int money) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select money from tbl_user where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		int moneyf = 0;
		while (rs.next()) {
			moneyf = rs.getInt("money");
		}
		
		sql = "update tbl_user set money=? " + "where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, money+moneyf);
		pstm.setInt(2, id);
		pstm.executeUpdate();
		ju.release(rs, pstm, conn);
	}

	@Override
	public void checkOutByID(int id, int money) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select money from tbl_user where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		int moneyf = 0;
		while (rs.next()) {
			moneyf = rs.getInt("money");
		}
		
		sql = "update tbl_user set money=? " + "where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, moneyf - money);
		pstm.setInt(2, id);
		pstm.executeUpdate();
		ju.release(rs, pstm, conn);
	}

}
