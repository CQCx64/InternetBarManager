package com.ibm.dao;

import java.util.List;

import com.ibm.entity.Com;
import com.ibm.entity.User;

public interface IComDao {

	public void insertCom(Com com) throws Exception;

	public void powerOffComFast(int uid) throws Exception;

	public void powerOffCom(int id) throws Exception;

	public void powerOnCom(int cid, int uid) throws Exception;

	public void setStartTime(int cid,int status) throws Exception;

	public int getComOnlineNum() throws Exception;
	
	public int getComPosIDByID(int id) throws Exception;

	public void deleteCom(Com com) throws Exception;

	public void changeComPowerStatus(int cid, User user, int status) throws Exception;

	public Com selectComByID(int id) throws Exception;

	public Com selectComByUID(int uid) throws Exception;

	public List<Com> selectComByStatus(int status) throws Exception;

	public List<Com> selectCom(int pid) throws Exception;
}
