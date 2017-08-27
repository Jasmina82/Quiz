package main;

/**
 * IMPORTANT! 1.import sql files from the folder database Game into MYSQL
 * Workbanch in order to use this aplication 2.set username and password for
 * MySQL in class ConnectionManager lines 11 and 12 (package db_handle)
 *
 */

public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AplicationHelper.startApp();

		int userOptionForLogin = AplicationHelper.getUserOption(3);

		AplicationHelper.handleLoginOption(userOptionForLogin);

	}

}
