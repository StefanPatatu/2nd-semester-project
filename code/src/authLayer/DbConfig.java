package authLayer;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Address
 * 
 * @author futz
 * @version 1.0
 */

public class DbConfig {
	
	private String DBDriver;
	private String DBName;
	private String DBUserName;
	private String DBPassword;
	private String DBTablePrefix;
	private final String password = "1B7C4DD1C6444GKS";
	
	//constructor
	public DbConfig() throws InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		ReadSetupFile reader = new ReadSetupFile();
		
		this.setDBDriver(Decrypt(reader.getDBDriver(), reader.getLDBDriver()));
		this.setDBName(Decrypt(reader.getDBName(), reader.getLDBName()));
		this.setDBUserName(Decrypt(reader.getDBUserName(), reader.getLDBUserName()));
		this.setDBPassword(Decrypt(reader.getDBPassword(), reader.getLDBPassword()));
		this.setDBTablePrefix(Decrypt(reader.getDBTablePrefix(), reader.getLDBTablePrefix()));
	}
	
	//DBDriver
	public String getDBDriver() {
		return DBDriver;
	}
	private void setDBDriver(String DBDriver) {
		this.DBDriver = DBDriver;
	}
		
	//DBName
	public String getDBName() {
		return DBName;
	}
	private void setDBName(String DBName) {
		this.DBName = DBName;
	}
		
	//DBUserName
	public String getDBUserName() {
		return DBUserName;
	}
	private void setDBUserName(String DBUserName) {
		this.DBUserName = DBUserName;
	}
		
	//DBPassword
	public String getDBPassword() {
		return DBPassword;
	}
	private void setDBPassword(String DBPassword) {
		this.DBPassword = DBPassword;
	}
			
	//TablePrefix
	public String getDBTablePrefix() {
		return DBTablePrefix;
	}
	private void setDBTablePrefix(String DBTablePrefix) {
		this.DBTablePrefix = DBTablePrefix;
	}
	
	//password
	private String getPassword() {
		return password;
	}
	
	//Decrypt
	public String Decrypt(String text, String length) throws InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
		Cipher cipher = null;
		int ctLength = Integer.parseInt(length);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		byte[] input = text.getBytes();
		byte[] keyBytes = getPassword().getBytes();

		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

		cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

		cipher.init(Cipher.DECRYPT_MODE, key);
	    byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
	    int ptLength = cipher.update(input, 0, ctLength, plainText, 0);
	    ptLength += cipher.doFinal(plainText, ptLength);
	    
	    return new String(plainText);
	}
	
}
