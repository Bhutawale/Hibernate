package com.Hibernate_Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "regularemployee")
public class Regular_Employee extends Employee {
	
	private double esalary;

	
	private int bonus;

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Regular_Employee(int eid, String ename, double esalary, int bonus) {
		super(eid, ename);
		this.esalary = esalary;
		this.bonus = bonus;
	}

	public Regular_Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Regular_Employee(int eid, String ename) {
		super(eid, ename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Regular_Employee [esalary=" + esalary + ", bonus=" + bonus + "]";
	}

}
