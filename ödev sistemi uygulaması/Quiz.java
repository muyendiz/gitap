package Assignments;

public class Quiz extends Assignment {

	private int quizTime;

	public Quiz(String dueDate, int numOfQuestion, int numOfAssignment, int quizTime) {
		super(dueDate, numOfQuestion, numOfAssignment);
		this.quizTime = quizTime;
	}

	public void showQuizResult() {

	}

}
