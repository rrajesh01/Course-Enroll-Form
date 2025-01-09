package com.rajesh.dao;

import java.util.List;

import com.rajesh.model.Student;

public interface Studentdao {

	public boolean save(Student st);
	
	public boolean update(Student newst);
	
	public boolean deleteById(int sid);
	
	public List<Student> readAll();
}

