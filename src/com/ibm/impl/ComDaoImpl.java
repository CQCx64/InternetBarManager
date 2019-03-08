package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.ibm.dao.IComDao;
import com.ibm.dao.IPosDao;
import com.ibm.dao.IUserDao;
import com.ibm.entity.Com;
import com.ibm.entity.Pos;
import com.ibm.entity.User;
import com.ibm.util.JdbcUtil;

public class ComDaoImpl implements IComDao {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	JdbcUtil ju = new JdbcUtil();

	IUserDao ud = new UserDaoImpl();
	IPosDao pd = new PosDaoImpl();

	@Override
	public void insertCom(Com com) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "insert into tbl_com (status,uid,time,posid) " + "values (?,?,?,?) ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, com.getStatus());
		pstm.setInt(2, com.getUser().getId());
		pstm.setInt(3, com.getTime());
		pstm.setInt(4, com.getPos().getId());
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void powerOffComFast(int uid) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_com set status=?,uid=?,time=? where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, 0);
		pstm.setInt(2, 0);
		pstm.setInt(3, 0);
		pstm.setInt(4, uid);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void powerOffCom(int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_com set status=?,uid=?,time=? where cid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, 0);
		pstm.setInt(2, 0);
		pstm.setInt(3, 0);
		pstm.setInt(4, id);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void powerOnCom(int cid, int uid) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_com set status=?,uid=?,time=? where cid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, 1);
		pstm.setInt(2, uid);
		pstm.setInt(3, 1);
		pstm.setInt(4, cid);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public void deleteCom(Com com) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "delete from tbl_com where cid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, com.getId());
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public Com selectComByID(int id) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_com where cid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		Com com = null;
		if (rs.next()) {
			com = new Com(rs.getInt("cid"), rs.getInt("status"), rs.getInt("time"), rs.getTimestamp("starttime"));
			int userid = rs.getInt("uid");
			User user = ud.selectUserByID(userid);
			int posid = rs.getInt("posid");
			Pos pos = pd.selectPosByID(posid);
			com.setUser(user);
			com.setPos(pos);
		}
		ju.release(rs, pstm, conn);

		return com;
	}

	@Override
	public Com selectComByUID(int uid) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_com where uid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, uid);
		rs = pstm.executeQuery();
		Com com = null;
		if (rs.next()) {
			com = new Com(rs.getInt("cid"), rs.getInt("status"), rs.getInt("time"),rs.getTimestamp("starttime"));
			int userid = rs.getInt("uid");
			User user = ud.selectUserByID(userid);
			int posid = rs.getInt("posid");
			Pos pos = pd.selectPosByID(posid);
			com.setUser(user);
			com.setPos(pos);
		}
		ju.release(rs, pstm, conn);

		return com;
	}

	@Override
	public List<Com> selectCom(int pid) throws Exception {
		// TODO 自动生成的方法存根
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		conn = ju.getConnection();
		String sql = "select * from tbl_com where posid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, pid);
		rs = pstm.executeQuery();
		Com com = null;
		List<Com> coms = new ArrayList<>();
		while (rs.next()) {
			com = new Com(rs.getInt("cid"), rs.getInt("status"), rs.getInt("time"), rs.getTimestamp("starttime"));
			int userid = rs.getInt("uid");
			User user = ud.selectUserByID(userid);
			int posid = rs.getInt("posid");
			Pos pos = pd.selectPosByID(posid);
			com.setUser(user);
			com.setPos(pos);
			coms.add(com);
		}
		ju.release(rs, pstm, conn);
		return coms;
	}

	@Override
	public int getComOnlineNum() throws Exception {
		// TODO 自动生成的方法存根
		int num = 0;
		conn = ju.getConnection();
		String sql = "select * from tbl_com where status = 1";
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next()) {
			num++;
		}
		ju.release(rs, pstm, conn);
		return num;
	}

	@Override
	public void setStartTime(int cid, int status) throws Exception {
		// TODO 自动生成的方法存根
		if (status == 1) {
			conn = ju.getConnection();
			String sql = "update tbl_com set starttime=? " + "where cid=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstm.setInt(2, cid);
			pstm.executeUpdate();
			ju.release(null, pstm, conn);
		} else {
//			DateFormat dateFormat;
//			dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH);// 设定格式
//			// dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss",
//			// Locale.ENGLISH);
//			String dateString = "2000-01-01 00:00:00.0"; 
//			dateFormat.setLenient(false);
//			java.util.Date timeDate = dateFormat.parse(dateString);// util类型
//			java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());
//			conn = ju.getConnection();
//			String sql = "update tbl_com set starttime=? " + "where cid=? ";
//			
//			pstm = conn.prepareStatement(sql);
//			pstm.setTimestamp(1, dateTime);
//			pstm.setInt(2, cid);
//			pstm.executeUpdate();
//			ju.release(null, pstm, conn);
			
			conn = ju.getConnection();
			String sql = "update tbl_com set starttime=? " + "where cid=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			pstm.setInt(2, cid);
			pstm.executeUpdate();
			ju.release(null, pstm, conn);
		}

	}

	@Override
	public List<Com> selectComByStatus(int status) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_com where status=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, status);
		rs = pstm.executeQuery();
		Com com = null;
		List<Com> coms = new ArrayList<>();
		while (rs.next()) {
			com = new Com(rs.getInt("cid"), rs.getInt("status"), rs.getInt("time"), rs.getTimestamp("starttime"));
			int userid = rs.getInt("uid");
			User user = ud.selectUserByID(userid);
			int posid = rs.getInt("posid");
			Pos pos = pd.selectPosByID(posid);
			com.setUser(user);
			com.setPos(pos);
			coms.add(com);
		}
		ju.release(rs, pstm, conn);
		return coms;
	}

	@Override
	public void changeComPowerStatus(int cid, User user, int status) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "update tbl_com set status=?,uid=?,starttime=? " + "where cid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, status);
		pstm.setInt(2, user.getId());
		pstm.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
		pstm.setInt(4, cid);
		pstm.executeUpdate();
		ju.release(null, pstm, conn);
	}

	@Override
	public int getComPosIDByID(int id) throws Exception {
		// TODO 自动生成的方法存根
		int posid = 0;
		conn = ju.getConnection();
		String sql = "select posid from tbl_com where cid=? ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		while (rs.next()){
			posid = rs.getInt("posid");
		}
		return posid;
	}

}
