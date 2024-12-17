package com.onetomanymapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Answer 
{
	@Id
	@Column(name="Answer_Id")
	private int aid;
	
	@Column(name="Answer")
	private String ans;
	
	

	public Answer(int aid, String ans) {
		super();
		this.aid = aid;
		this.ans = ans;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", ans=" + ans + "]";
	}

		
	
}
