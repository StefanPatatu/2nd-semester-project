package authLayer;

import java.util.ArrayList;

/**
 * SystemLogin
 * 
 * @author futz
 * @version 1.0
 */

public class SystemLogin {
	
	//constructor
	public SystemLogin() {
		
	}
	
	//returns user access level:
	//-1 - authentication error
	//1 - worker
	//2 - cashier
	//3 - manager
	public int Authenticate(int id_employee,  String password, String salt) {
		return -1;
	}
	
	public ArrayList<String> getHashedPasswordAndSalt(String password) {
		ArrayList<String> passAndSalt = new ArrayList<>();
		passAndSalt.set(0, password);
		passAndSalt.set(1, "123");
		return passAndSalt;
	}

}
