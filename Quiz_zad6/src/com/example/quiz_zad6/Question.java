package com.example.quiz_zad6;

public class Question {

	String questionName;
	String[] answers;
	int numberOfRightAnswer;
	int questionImage;

	public Question(String questionName, String[] answers,
			int numberOfRightAnswerr, int questionImage) {
		this.questionName = questionName;
		this.answers = answers;
		this.numberOfRightAnswer = numberOfRightAnswerr;
		this.questionImage = questionImage;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getQuestionImage() {
		return questionImage;
	}

	public void setQuestionImage(int questionImage) {
		this.questionImage = questionImage;
	}

	public int getNumberOfRightAnswer() {
		return numberOfRightAnswer;
	}

	public void setNumberOfRightAnswer(int numberOfRightAnswer) {
		this.numberOfRightAnswer = numberOfRightAnswer;
	}

}
