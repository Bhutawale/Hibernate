package com.hibernate_project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Student_Details")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Student_Id")
	private int id;
	
	@Column(name="Student_Name")
	private String name;
	
	@Column(name="Student_Address")
	private String address;
	
	@Column(name="Student_Percentage")
	@Transient               //Transient Annotation won't allow to create column in the database.
	private double percentage;

	@Column(name="Student_Image",length=1000)
	private byte[] image;
	
	public Student(int id, String name, String address, double percentage, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.percentage = percentage;
		this.image = image;
	}

	
	public Student()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] arr) {
		this.image = arr;
	}

	
	
}
