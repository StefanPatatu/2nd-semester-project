package authLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * SystemLogin
 * 
 * @author futz
 * @version 1.2
 */

/**
 * Note to self:
 * The ISO-8859-1 encoding maps a single, unique character for each byte,
 * so it's safe to use it for the conversion. Note that other encodings,
 * such as UTF-8, are not safe in this sense because there are sequences
 *  of bytes that don't map to valid strings in those encodings.
 */

public class SystemLogin {
	
	//variables
	private static final Random RANDOM = new SecureRandom();
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	
	//constructor
	public SystemLogin() {
		
	}
	
	//returns true if password is correct:
	//returns false otherwise
	public boolean authenticate(String password, String salt, String hashedPassword) throws UnsupportedEncodingException {
		
		System.out.println("###authenticate###");
		System.out.println("Password: " + password);
		System.out.println("Salt: " + salt);
		System.out.println("hashedPassword: " + hashedPassword);
		
		char[] passChar = password.toCharArray(); //convert password string to char array
		
		byte[] saltByte = null;
		try {
			saltByte = Base64.decodeBase64((salt));
		} catch (Exception e) {
			System.out.println("decode(salt)");
			e.printStackTrace();
			
		}
		
		byte[] hashedPassByte = null;
		try {
			hashedPassByte = Base64.decodeBase64((hashedPassword));
		} catch (Exception e) {
			System.out.println("decode(hashedPassword)");
			e.printStackTrace();
		}
		
		//byte[] saltByte = salt.getBytes("UTF-8");
		//byte[] hashedPassByte = hashedPassword.getBytes("UTF-8");
		
		return isExpectedPassword(passChar, saltByte, hashedPassByte);
	}
	
	public ArrayList<String> getHashedPasswordAndSalt(String password) throws UnsupportedEncodingException {
		ArrayList<String> passAndSalt = new ArrayList<>();
		
		byte[] salt = getNextSalt(); //generate salt
		char[] pass = password.toCharArray(); //convert password string to char array
		
		byte[] hashedPass = hash(pass, salt); //generate the hash using the above salt and pass
		
		String stringSalt = new String(Base64.encodeBase64(salt));
		String stringPass = new String(Base64.encodeBase64(hashedPass));
		
		//String stringSalt = new String(salt, "UTF-8"); //convert salt to String
		//String stringPass = new String(hashedPass, "UTF-8"); //convert hashed pass to string
		
		System.out.println("###getHashedPasswordAndSalt###");
		System.out.println("stringSalt: " + stringSalt);
		System.out.println("stringPass: " + stringPass);
		
		passAndSalt.add(stringPass); //add pass to array
		passAndSalt.add(stringSalt); //add salt to array
		return passAndSalt; //return the array containing the hashed password and the salt used
	}
	
	//returns a 16 bytes random salt
	private static byte[] getNextSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return salt;
	}
	
	//return the hashed password with a little bit of salt
	private static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}
	 
	//verify if the given password and salt match the hashed value
	//returns true if yes, false if no
	private static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash) {
		byte[] pwdHash = hash(password, salt);
		System.out.println("###isExpectedPassword###");
		String pwdHashString = "";
		try {
			pwdHashString = new String(pwdHash, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("pwdHash: " + pwdHashString);
	    Arrays.fill(password, Character.MIN_VALUE);
	    if (pwdHash.length != expectedHash.length) return false;
	    for (int i = 0; i < pwdHash.length; i++) {
	    	if (pwdHash[i] != expectedHash[i]) return false;
	    }
	    return true;
	}

}
