package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
	public static Scanner input = new Scanner(System.in);

	public static int getUserInput(int limit) {

		int userInput = 0;
		boolean wrong = true;

		do {
			try {
				userInput = input.nextInt();
				input.nextLine();
				wrong = false;
				if (userInput < 1 || userInput > limit) {
					System.out.println("Wrong option!Try again:");
					wrong = true;
				}
			} catch (InputMismatchException ex) {
				
				System.out.println("Wrong input!Try again:");
				input.nextLine();
			}
		} while (wrong);

		return userInput;

	}
	
	public static String userInput(String message) {
		
		System.out.println(message);
		
	String user="";
		boolean wrong = true;

		do {
				user = input.nextLine();
				wrong = false;
				if (user.length() > 70) {
					System.out.println("Too long!Try again:");
					wrong = true;
				}
				if(user.isEmpty()) {
					System.out.println("Enter something!Try again:");
					wrong = true;
				}
			
		} while (wrong);
		
		
		return user;
		
	}

}
