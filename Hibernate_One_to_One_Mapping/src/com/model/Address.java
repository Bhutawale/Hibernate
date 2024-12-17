package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	
	private String area;
	private String cityname;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", area=" + area + ", cityname=" + cityname + "]";
	}
	
	

}
