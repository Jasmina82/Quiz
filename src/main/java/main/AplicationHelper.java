package main;

import main.LoginHandler;

public class AplicationHelper {

	public static void startApp() {

		System.out.println("\t\tLET'S PLAY !!! \n\n1.Login\t\t2.Register\t\t3.Exit");	
	   int userOption=getUserOption(3);
		handleLoginOption(userOption);

	}
	public static int getUserOption(int limit) {

		return InputHandler.getUserInput(limit);
	}

	public static void handleLoginOption(int userOption) {

		switch (userOption) {

		case 1:
			LoginHandler.login();
			break;
		case 2:
			LoginHandler.register();
			break;
		case 3:
			System.exit(0);

		}

	}


}
