package com.Hibernate_Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="contractemployee")
public class Contract_Employee extends Employee
{
	
	private double pay_per_hour;
	
	
	private String contract_duration;

	public double getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(double pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}

	public Contract_Employee(int eid, String ename, double pay_per_hour, String contract_duration) {
		super(eid, ename);
		this.pay_per_hour = pay_per_hour;
		this.contract_duration = contract_duration;
	}

	public Contract_Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract_Employee(int eid, String ename) {
		super(eid, ename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contract_Employee [pay_per_hour=" + pay_per_hour + ", contract_duration=" + contract_duration + "]";
	}
	
	
}
