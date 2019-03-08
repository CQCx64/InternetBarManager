package com.ibm.dao;

import java.util.List;

import com.ibm.entity.Pos;

public interface IPosDao {
	
	public Pos selectPosByID(int id) throws Exception;
	
	public List<Pos> selectPos() throws Exception;
	
	public void updatePos(Pos pos)throws Exception;
	
}
