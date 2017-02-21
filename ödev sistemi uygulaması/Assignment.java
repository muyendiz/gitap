package Assignments;

import Questions.Question;
import java.util.ArrayList;

public abstract class Assignment {

	private String dueDate;
	private int numOfQuestion;
	private ArrayList<Question> questions;
	private int numOfAssignment;
	

	public Assignment(String dueDate, int numOfQuestion, int numOfAssignment) {
		this.setDueDate(dueDate);
		this.setNumOfQuestion(numOfQuestion);
		this.setNumOfAssignment(numOfAssignment);
		setQuestions(new ArrayList<Question>());
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getNumOfQuestion() {
		return numOfQuestion;
	}

	public void setNumOfQuestion(int numOfQuestion) {
		this.numOfQuestion = numOfQuestion;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public int getNumOfAssignment() {
		return numOfAssignment;
	}

	public void setNumOfAssignment(int numOfAssignment) {
		this.numOfAssignment = numOfAssignment;
	}

}
