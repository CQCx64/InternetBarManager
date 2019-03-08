package com.ibm.dao;

import java.util.List;

import com.ibm.entity.Note;

public interface INoteDao {
	public List<Note> selectNoteByType(int type)throws Exception;
}
