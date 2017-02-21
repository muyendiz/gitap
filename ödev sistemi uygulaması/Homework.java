package Assignments;

import Questions.Question;
public class Homework extends Assignment {

	private String hint;

	public Homework(String dueDate, int numOfQuestion, int numOfAssignment, String hint) {
		super(dueDate, numOfQuestion, numOfAssignment);
		this.hint = hint;
	}

	public String displayHint() {
		return hint;
	}

	public void showAnswer(Question q) {

	}

}
