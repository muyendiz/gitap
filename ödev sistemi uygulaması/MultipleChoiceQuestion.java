package Questions;

public class MultipleChoiceQuestion extends Question {

	final static int numOfChoices = 4;
	private int correctChoice;
	private String[] choiceText;

	public MultipleChoiceQuestion(String questionText, String courseCode, int questionNumber, int assignmentNumber,
			String assignmentType, int correctChoice, String choice1, String choice2, String choice3, String choice4) {
		super(questionText, courseCode, questionNumber, assignmentNumber, assignmentType);
		this.correctChoice = correctChoice;
		choiceText = new String[numOfChoices];
		setChoice(0, choice1);
		setChoice(1, choice2);
		setChoice(2, choice3);
		setChoice(3, choice4);
	}

	public int getNumOfChoices() {
		return numOfChoices;
	}

	public int getCorrectChoice() {
		return correctChoice;
	}

	public String getchoiceText(int i) {
		return choiceText[i];
	}

	public void setChoice(int index, String text) {
		if (index < numOfChoices && index >= 0)
			choiceText[index] = text;
		else
			System.out
					.println("Enter a index number which is smaller than number of choices and greater or equal to 0");
	}

}
