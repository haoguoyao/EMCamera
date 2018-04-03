package service;

import repository.InfoDAO;

public class DoLogin {
	public int login(int id, String inputPassword) {
		String password = InfoDAO.retrievePassword(id);
		if(password==null)
			return 101;
		else if(!password.equals(inputPassword))
			return 102;
		else
			return 100;
	}
	public int login(String email, String inputPassword) {
		String password = InfoDAO.retrievePassword(email);
		if(password==null)
			return 101;
		else if(!password.equals(inputPassword))
			return 102;
		else
			return 100;
	}
	

}
