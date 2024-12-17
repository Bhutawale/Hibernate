package com.hibernate_cascading;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question 
{
	@Id
	private int qid;
	
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Answer> answer;
	
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Question(int qid, String question) {
		super();
		this.qid = qid;
		this.question = question;
	}
	
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	public Question() {
		super();
	}
	public Question(int qid, String question, List<Answer> answer) {
		super();
		this.qid = qid;
		this.question = question;
		this.answer = answer;
	}
	
}
