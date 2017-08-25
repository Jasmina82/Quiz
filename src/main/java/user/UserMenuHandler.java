package user;

import java.util.Collections;
import java.util.List;
import admin.Question;
import db_handle.AdminDAOImplementation;
import db_handle.UserDAO;
import db_handle.UserDAOImplementation;
import main.AplicationHelper;
import main.InputHandler;
import user.UserProfile;

public class UserMenuHandler {

	static UserDAO userDao = new UserDAOImplementation();
	static Game game = new Game();

	public static void userMenu(UserProfile user) {

		System.out.println("\tEnter option!\n\n1.Play\t\t2.Game history\t\t3.Highscores\t\t4.Exit");

		handleUserOption(user);
	}

	public static void handleUserOption(UserProfile user) {

		int userMenuOption = InputHandler.getUserInput(4);

		switch (userMenuOption) {

		case 1:
			play(user);
			break;
		case 2:
			gameHistory(user);
			break;
		case 3:
			getHighscores(user);
			break;
		case 4:
	
			AplicationHelper.startApp();
		}
	}

	public static void play(UserProfile user) {

		AdminDAOImplementation manager = new AdminDAOImplementation();
		List<Question> questions = manager.getAllQuestions();

		System.out.println("Enter correct answer.Good luck!\n");
		Collections.shuffle(questions);

		for (int i = 0; i < 25; i++) {

			List<String> answers = questions.get(i).getAnswers();

			// print question
			System.out.println(questions.get(i).getQuestion());

			handleAnswer(answers, questions.get(i).getCorrectAnswer());
		}

		System.out.println(game.toString() + "\n");
		userDao.recordPlay(user.getUsername(), game.getPoints());
		userMenu(user);
	}

	public static void handleAnswer(List<String> answers, String correctAnswer) {

		// change position of answers
		Collections.shuffle(answers);

		System.out.println(
				"1." + answers.get(0) + "\n2." + answers.get(1) + "\n3." + answers.get(2) + "\n4." + answers.get(3));

		// get user's answer
		int userAnswer = InputHandler.getUserInput(4);
		
		System.out.println("Correct answer : " + correctAnswer + "\n");

		// check if user's answer is correct
		if (correctAnswer.equals(answers.get(userAnswer - 1)))
			game.plusCorrect();

		else
			game.plusWrong();
	}

	public static void gameHistory(UserProfile user) {
		List<String> highscores = userDao.getGameHistory(user.getUsername());

		System.out.println("Your game history : ");

		for (String e : highscores) {
			System.out.println(e);
		}
		System.out.println();
		userMenu(user);
	}

	public static void getHighscores(UserProfile user) {
		List<String> highscores = userDao.getHighscoresList();

		System.out.println("All players highscores: ");

		int counter=1;
		for (String e : highscores) {
			System.out.println(counter + "." + e);
			counter++;
		}
		System.out.println();
		userMenu(user);
	}

}
