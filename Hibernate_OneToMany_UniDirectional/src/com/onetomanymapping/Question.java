package com.onetomanymapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question
{
	@Id
	@Column(name="Question_Id")
	private int qid;
	
	@Column(name="Question")
	private String que;
	
	@OneToMany
	private List<Answer> answer; //List because we have to store more than one answer for one question.

	
	public Question() {                 //Default Constructor
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int qid, String que, List<Answer> answer) {      //Parameterized Constructor
		super();
		this.qid = qid;
		this.que = que;
		this.answer = answer;
	}

	public int getQid() {                  //Getters and Setters Methods
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", que=" + que + ", answer=" + answer + "]";
	}
	
}
