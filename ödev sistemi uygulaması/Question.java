package Questions;
import Assignments.*;
public abstract class Question {


	private String questionText;
	private String nameOfCourse;
	private int questionNumber;
	private String questionCode;
	private int assignmentNumber;
	private String assignmentType;
	

	public Question(String questionText,String courseCode, int questionNumber, int assignmentNumber,
			String assignmentType) {
		this.questionText = questionText;
		nameOfCourse = courseCode;
		this.questionNumber = questionNumber;
		this.assignmentNumber = assignmentNumber;
		this.assignmentType = assignmentType;
		
	}

	public String getQuestionText() {
		return questionText;
	}

	public void displayQuestion() {

	}

	public String getNameOfCourse() {
		return nameOfCourse;
	}

	public String calculateQuestionCode() {
		questionCode = nameOfCourse + assignmentType + assignmentNumber + questionNumber ;
		return questionCode;
	}

	public String getQuestionType() {
		String QuestionType = this.getClass().getSimpleName();
		return QuestionType;
	}
	
	public String getAssignmentType() {
		return assignmentType;
	}
	
	public int getQuestionNumber() {
		return questionNumber;
	}
	
	public int assignmentNumber(){
		return assignmentNumber;
	}


}
