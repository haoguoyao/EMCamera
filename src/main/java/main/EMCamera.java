package main;

import java.io.IOException;
import repository.ManageDB;

public class EMCamera {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome :)");
		System.out.println("1:Create student");
		System.out.println("2:Clear database");
		char onechar =(char )System.in.read();
		switch (onechar) {
		case '1':
			ManageDB.initialize();
			break;
		case '2':
			System.out.println("删库到跑路");
			ManageDB.initialize();
			break;
		default:
			break;
		}
	}

}
