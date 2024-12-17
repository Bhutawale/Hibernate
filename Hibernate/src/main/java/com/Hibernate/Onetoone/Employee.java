package com.Hibernate.Onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee 
{
	@Id
	private int eid;
	private String ename;
	@OneToOne
	private Department edep;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Department getEdep() {
		return edep;
	}
	public void setEdep(Department edep) {
		this.edep = edep;
	}
	public Employee(int eid, String ename, Department edep) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.edep = edep;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
	
	
}
