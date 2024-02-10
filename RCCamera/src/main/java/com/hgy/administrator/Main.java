package com.hgy.administrator;

import java.io.IOException;

import com.hgy.tools.InputUtil;

public class Main {

	public static void main(String[] args) {
		System.out.println("1.manipulate database");
		System.out.println("2.add students to class by excel");
		
		System.out.println("0.quit");
		char input = InputUtil.readChar();
		switch (input) {
		case 1:
			ManipulateDB manipulateDB = new ManipulateDB();
			manipulateDB.executeSQL();
			break;
		case 2:
			AddClazzStudents addClazzStudents = new AddClazzStudents();
			break;
		case 0:
			System.out.println("press any button to quit");
			input = InputUtil.readChar();
			break;
		default:
			System.out.println("wrong input");
			break;
		}

	}

}
