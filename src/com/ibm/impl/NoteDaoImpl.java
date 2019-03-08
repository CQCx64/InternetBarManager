package com.ibm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibm.dao.INoteDao;
import com.ibm.entity.Note;
import com.ibm.util.JdbcUtil;

public class NoteDaoImpl implements INoteDao {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	JdbcUtil ju = new JdbcUtil();
	@Override
	public List<Note> selectNoteByType(int type) throws Exception {
		// TODO 自动生成的方法存根
		conn = ju.getConnection();
		String sql = "select * from tbl_note where notetype=?  ";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, type);
		rs = pstm.executeQuery();
		List<Note> notes = new ArrayList<>();
		while(rs.next()){
			Note note = new Note(rs.getInt("noteid"), rs.getString("notedetail"), rs.getInt("notetype"));
			notes.add(note);
		}
		ju.release(rs, pstm, conn);
		return notes;
	}

}
