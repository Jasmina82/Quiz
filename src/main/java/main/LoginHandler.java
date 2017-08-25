package main;

import main.InputHandler;
import user.UserMenuHandler;
import user.UserProfile;
import java.util.Map;
import java.util.Set;

import admin.AdminMenuHandler;
import db_handle.UserDAOImplementation;

public class LoginHandler {

	static UserDAOImplementation userDao = new UserDAOImplementation();
	static Map<String, String> users = userDao.getListOfUsers();

	public static void login() {

		String username = InputHandler.userInput("Enter username:");

		boolean userExists = validateUser(username);

		if (!userExists) {
			System.out.println("Username dosn't exists! ");
			login();
		}

		String password = InputHandler.userInput("Enter password:");

		if (username.equals("jasmina") && password.equals("1122"))
			AdminMenuHandler.adminMenu();

		boolean correctPassword = validatePassword(username, password);

		if (!correctPassword) {
			System.out.println("Wrong password! Returning to main menu...\n");
			login();
		}

		UserProfile user = new UserProfile(username, password);
		UserMenuHandler.userMenu(user);
	}

	public static void register() {

		String username = InputHandler.userInput("Enter username,it has to be unique:");

		boolean userExists = validateUserForRegister(username);

		if (userExists) {
			System.out.println("Username already exists! ");
			AplicationHelper.startApp();
		}

		// create password
		int password = (int) (1000 + (Math.random() * 999));

		UserProfile newUser = new UserProfile(username, password + "");

		userDao.register(newUser);
		System.out.println(newUser.toString());
		UserMenuHandler.userMenu(newUser);
	}

	public static <K> boolean validateUser(String username) {

		return users.containsKey(username);
	}

	public static <K> boolean validateUserForRegister(String username) {
		Set<String> keys = users.keySet();

		for (String e : keys) {
			if (e.equalsIgnoreCase(username))
				return true;
		}

		return false;
	}

	public static boolean validatePassword(String username, String password) {

		return users.get(username).equals(password);

	}

}
