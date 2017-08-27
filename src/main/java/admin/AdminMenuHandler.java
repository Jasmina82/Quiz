package admin;

import java.util.List;
import db_handle.AdminDAO;
import db_handle.AdminDAOImplementation;
import main.AplicationHelper;
import main.InputHandler;
import main.LoginHandler;

public class AdminMenuHandler {

	static AdminDAO admin = new AdminDAOImplementation();

	public static void adminMenu() {

		System.out.println("\tEnter option!\n1.Add question\n2.Edit question\n3.Delete user\n4.Exit");
		handleAdminOption();
	}

	public static void handleAdminOption() {

		int adminMenuOption = InputHandler.getUserInput(4);

		switch (adminMenuOption) {

		case 1:
			addQuestion();
			break;
		case 2:
			editQuestion();
			break;
		case 3:
			deleteUser();
			break;
		case 4:
			AplicationHelper.startApp();
		}
	}

	public static void addQuestion() {

		String question = InputHandler.userInput("Enter question:");
		String correctAnswer = InputHandler.userInput("Enter correct answer:");
		String wrongAnswer1 = InputHandler.userInput("Enter wrong answer one:");
		String wrongAnswer2 = InputHandler.userInput("Enter wrong answer two:");
		String wrongAnswer3 = InputHandler.userInput("Enter wrong answer three:");

		Question questionObject = new Question(question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3);
		admin.addQuestion(questionObject);

		adminMenu();
	}

	public static void editQuestion() {
		List<Question> questions = admin.getAllQuestions();

		System.out.println("All questions: ");

		for (int i = 0; i < questions.size(); i++) {
			System.out.println(i + 1 + ". " + questions.get(i).getQuestion());
		}
		System.out.println(questions.size() + 1 + ". Exit to main menu\n");

		System.out.println("Enter the number of the question you want to edit: ");

		int questionRow = InputHandler.getUserInput(questions.size() + 1);

		// there is 25 questions in the menu list,last option, 26 is exit
		if (questionRow == (questions.size() + 1))
			adminMenu();

		handleQuestionEdit(questions.get(questionRow - 1), questionRow);
	}

	public static void handleQuestionEdit(Question question, int row) {

		// create new Question object, for editing
		Question editedQuestion = new Question(question.getQuestion(), question.getCorrectAnswer(),
				question.getWrongAnswer1(), question.getWrongAnswer2(), question.getWrongAnswer3());

		int adminOption = 0;
		int changeTime = 0;
		String adminCorrection = "";

		// while option isn't exit
		while (adminOption != 6) {

			// print menu with question's element for editing
			System.out.println(editedQuestion.toString());
			System.out.println("6.Exit menu\n");
			adminOption = InputHandler.getUserInput(6);

			changeTime++;

			switch (adminOption) {

			case 1:
				adminCorrection = InputHandler.userInput("Enter question");
				editedQuestion.setQuestion(adminCorrection);
				break;
			case 2:
				adminCorrection = InputHandler.userInput("Enter correct answer");
				editedQuestion.setCorrectAnswer(adminCorrection);
				break;
			case 3:
				adminCorrection = InputHandler.userInput("Enter wrong answer 1");
				editedQuestion.setWrongAnswer1(adminCorrection);
				break;
			case 4:
				adminCorrection = InputHandler.userInput("Enter wrong answer 2");
				editedQuestion.setWrongAnswer2(adminCorrection);
				break;
			case 5:
				adminCorrection = InputHandler.userInput("Enter wrong answer 3");
				editedQuestion.setWrongAnswer3(adminCorrection);
				break;
			case 6:
				System.out.println("Exiting to main menu....");
			}
		}

		// if user has changed the question,edit question in the db
		if (changeTime > 1)
			admin.editQuestion(editedQuestion, row);

		adminMenu();
	}

	public static void deleteUser() {

		String username = InputHandler.userInput("Enter username you want to delete: ");

		if (LoginHandler.validateUser(username))

			admin.deleteUser(username);

		else
			System.out.println("Username " + username + "doesn't exist! ");

		adminMenu();
	}
}
