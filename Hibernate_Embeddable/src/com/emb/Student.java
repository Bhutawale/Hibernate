package com.emb;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Student
{
	@Id
	@Column(name="Student_Id")
	private int sid;
	
	@Column(name="Student_Name")
	private String sname;
	
	@Embedded
	@Column(name="Student_Certificate")
	private Certificate certi;

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

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public Student(int sid, String sname, Certificate certi) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.certi = certi;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", certi=" + certi + "]";
	}
	
	
}
