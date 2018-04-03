package tools;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
	public static boolean isNumeric(String str){
	 for (int i = 0; i < str.length(); i++){
		  System.out.println(str.charAt(i));
		  if (!Character.isDigit(str.charAt(i))){
			  return false;
		  	}
		 }
	 return true;
	}
	public boolean isNumeric2(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
	

}
