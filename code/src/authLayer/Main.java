package authLayer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		
		
		DbConfig dbconfig = new DbConfig();
		
		System.out.println(dbconfig.getDBDriver());
		System.out.println(dbconfig.getDBName());
		System.out.println(dbconfig.getDBUserName());
		System.out.println(dbconfig.getDBPassword());
		System.out.println(dbconfig.getDBTablePrefix());	
		
	}

}
