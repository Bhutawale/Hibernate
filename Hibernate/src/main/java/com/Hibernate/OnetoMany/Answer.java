package com.Hibernate.OnetoMany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer
{
	@Id
	private int aid;
	
	private String answer;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Answer(int aid, String answer) {
		super();
		this.aid = aid;
		this.answer = answer;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", answer=" + answer + "]";
	}
	
	
}
