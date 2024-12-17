package com.manytoonemapping;

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
	private String question;
	
	
	@OneToMany(mappedBy="question")
	private List<Answer> ans;
	
	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Question(int qid, String question, List<Answer> ans) {
		super();
		this.qid = qid;
		this.question = question;
		this.ans = ans;
	}



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
	
	

	public List<Answer> getAns() {
		return ans;
	}



	public void setAns(List<Answer> ans) {
		this.ans = ans;
	}



	@Override
	public String toString() {
		return "Question [qid=" + qid + ", question=" + question + ", ans=" + ans + "]";
	}



	
	
}
