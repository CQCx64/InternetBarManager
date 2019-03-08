package com.ibm.dao;

import java.util.List;

import com.ibm.entity.App;

public interface IAppDao {
	public List<App> selectByGroup(int group) throws Exception; 
	
}
