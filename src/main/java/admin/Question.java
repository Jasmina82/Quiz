package admin;

import java.util.ArrayList;
import java.util.List;

public class Question {

	String question;
	String correctAnswer;
	String wrongAnswer1;
	String wrongAnswer2;
	String wrongAnswer3;

	public Question(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2,
			String wrongAnswer3) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}

	public List<String> getAnswers() {

		List<String> answers = new ArrayList<>();

		answers.add(correctAnswer);
		answers.add(wrongAnswer1);
		answers.add(wrongAnswer2);
		answers.add(wrongAnswer3);

		return answers;

	}

	@Override
	public String toString() {

		return "1.question - " + question + "\n2. Correct answer - " + correctAnswer + "\n3. Wrong answer 1 - " + wrongAnswer1 + "\n4. Wrong answer 2 - " + wrongAnswer2+ "\n5. Wrong answer 3 - " + wrongAnswer3;
		
	}
}