package com.emb;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Certificate
{
	@Column(name="Course")
	private String course;
	
	@Column(name="Duration")
	private int duration;
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Certificate(String course, int duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duration=" + duration + "]";
	}
	
}
