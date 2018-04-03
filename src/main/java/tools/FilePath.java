package tools;

import java.util.List;

import repository.RollCallDAO;

public class FilePath {
	private static String divide = null;
	public static String idToPath(int id) {
		String idString = String.format("%08d",id);
		int length = idString.length();
		String fineDigit = idString.substring(length-4, length);
		String coarseDigit = idString.substring(0,length-4);
		return fineDigit+divide+coarseDigit;
	}
	public static String idToPath(String idString) {
		return idToPath(Integer.valueOf(idString));
	}

	public static String rollCallIDToPath(int id) {
		return "images"+divide+"rollcall"+divide+idToPath(id);
	}
	public static String rollCallIDToPath(String idString) {
		return "images"+divide+"rollcall"+divide+idToPath(idString);
	}
	public static String studentIDToPath(int id) {
		return "images"+divide+"student"+divide+idToPath(id);
	}
	public static String studentIDToPath(String idString) {
		return "images"+divide+"student"+divide+idToPath(idString);
	}
	public static List<String> studentIDHead(int id) {
		return RollCallDAO.retrievePhotoResultByStudent(id);
	}
	public static List<String> studentIDHead(String id) {
		return RollCallDAO.retrievePhotoResultByStudent(id);
	}
	public static void setDivide(String newDivide) {
		divide = newDivide;
	}

}
