package com.ibm.dao;

import java.util.List;

import com.ibm.entity.User;

public interface IUserDao {
	
	public void insertUser(User user) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public int getUserNum() throws Exception;
	
	public int getUserMoneyByID(int id) throws Exception;
	
	public int getUserCanUseByIDNumber(String idnumber) throws Exception;
	
	public void changeUserCanUseByID(int id,int status) throws Exception;
	
	public void rechargeByID(int id,int money) throws Exception;
	
	public void checkOutByID(int id,int money) throws Exception;
	
	public void updateLastDate(int id) throws Exception;
	
	public User selectUserByIDNumber(String idNumber) throws Exception;
	
	public User selectUserByID(int id) throws Exception;
	
	public List<User> selectUserByCondition(int id ,String name) throws Exception;
	
}
