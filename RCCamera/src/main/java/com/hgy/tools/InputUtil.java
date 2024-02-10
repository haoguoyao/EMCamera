package com.hgy.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
	public static char readChar(){
		int charAsInt = -1;
		try {
		charAsInt = System.in.read();
		} catch(IOException e) {
		System.out.println(e.getMessage());
		System.out.println("Fatal error. Ending Program.");
		System.exit(0);
		}
		return (char)charAsInt;
	}
	public static String readLine(){
		String inputString = null;
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
	        inputString = bf.readLine(); 
		} catch(IOException e) {
		System.out.println(e.getMessage());
		System.out.println("Fatal error. Ending Program.");
		System.exit(0);
		}
		return inputString;
	}

}
