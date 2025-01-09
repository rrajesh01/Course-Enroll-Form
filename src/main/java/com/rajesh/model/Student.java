package com.rajesh.model;

public class Student {
	
	int sid;
	String sname;
	String email;
	String course;
	
	public Student() {}
	
	public Student(int sid) {
		this.sid=sid;
	}
	
	

	public Student(String sname, String email, String course) {
		this.sname = sname;
		this.email = email;
		this.course = course;
	}

	public Student(int sid, String sname, String email, String course) {
		this.sid = sid;
		this.sname = sname;
		this.email = email;
		this.course = course;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	

}
