package com.ibm.dao;

import java.util.List;

import com.ibm.entity.Bar;

public interface IBarDao {
	public Bar selectBarByID(int id) throws Exception;
	
	public List<Bar> selectBar() throws Exception;
}
