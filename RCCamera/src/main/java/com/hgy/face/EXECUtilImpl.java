package com.hgy.face;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.Buffer;

import org.springframework.stereotype.Service;



@Service
public class EXECUtilImpl implements EXECUtil{
	
	public String execute(String scriptPath, String[] args) {
		String command = "/Users/apple/anaconda2/bin/python ";
		//String command = "python ";
		command+=scriptPath;
		for(int i = 0;i<args.length;i++) {
			command = command+" ";
			command = command+args[i];
		}
		String result = "";
		try {
			System.out.println(command);
            Process process = Runtime.getRuntime().exec(command);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader(ir);
            System.out.println("Script status is "+process.waitFor()+" and 0 means success ");
            result = input.readLine();
            process.waitFor();
            input.close();
            process.waitFor();
            ir.close();
        } catch (IOException | InterruptedException e) {
        		e.printStackTrace();
        }
		return result;
	}

}
