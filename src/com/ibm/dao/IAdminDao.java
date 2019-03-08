package com.ibm.dao;

import com.ibm.entity.Admin;

public interface IAdminDao {
		
	public Admin selectAdminByName(String name) throws Exception;

	public void updateAdminPwd(String password,int id) throws Exception;
	
}
