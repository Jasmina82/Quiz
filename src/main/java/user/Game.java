package user;

public class Game {

	int correct = 0;
	int wrong = 0;

	public int getCorrect() {
		return correct;
	}

	public void plusCorrect() {
		correct++;
	}

	public int getWrong() {
		return wrong;
	}

	public void plusWrong() {
		wrong++;
	}

	public int getPoints() {
		return correct * 4;

	}

	@Override
	public String toString() {

		return "\tGame over! \n" + "Correct answers: " + correct + ", wrong answers: " + wrong + "\nTotal points : "
				+ getPoints();
	}

}
