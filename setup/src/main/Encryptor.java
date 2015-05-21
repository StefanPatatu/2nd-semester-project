package main;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
	
	private String DBDriver;
	private String LDBDriver;
	
	private String DBName;
	private String LDBName;
	
	private String DBUserName;
	private String LDBUserName;
	
	private String DBPassword;
	private String LDBPassword;
	
	private String DBTablePrefix;
	private String LDBTablePrefix;
	
	private final String password = "1B7C4DD1C6444GKS";
	
	public Encryptor() throws UnsupportedEncodingException {
		Generator generator = new Generator();
		
		setDBDriver(EncryptDBDriver(Base64.getEncoder().encodeToString(generator.getDBDriver().getBytes("utf-8"))));
		setDBName(EncryptDBName(Base64.getEncoder().encodeToString(generator.getDBName().getBytes("utf-8"))));
		setDBUserName(EncryptDBUserName(Base64.getEncoder().encodeToString(generator.getDBUserName().getBytes("utf-8"))));
		setDBPassword(EncryptDBPassword(Base64.getEncoder().encodeToString(generator.getDBPassword().getBytes("utf-8"))));
		setDBTablePrefix(EncryptDBTablePrefix(Base64.getEncoder().encodeToString(generator.getDBTablePrefix().getBytes("utf-8"))));
	}
	
	//DBDriver
	public String getDBDriver() {
		return DBDriver;
	}
	private void setDBDriver(String DBDriver) {
		this.DBDriver = DBDriver;
	}
	public String getLDBDriver() {
		return LDBDriver;
	}
	private void setLDBDriver(String LDBDriver) {
		this.LDBDriver = LDBDriver;
	}
	
	//DBName
	public String getDBName() {
		return DBName;
	}
	private void setDBName(String DBName) {
		this.DBName = DBName;
	}
	public String getLDBName() {
		return LDBName;
	}
	private void setLDBName(String LDBName) {
		this.LDBName = LDBName;
	}
	
	//DBUserName
	public String getDBUserName() {
		return DBUserName;
	}
	private void setDBUserName(String DBUserName) {
		this.DBUserName = DBUserName;
	}
	public String getLDBUserName() {
		return LDBUserName;
	}
	private void setLDBUserName(String LDBUserName) {
		this.LDBUserName = LDBUserName;
	}
	
	//DBPassword
	public String getDBPassword() {
		return DBPassword;
	}
	private void setDBPassword(String DBPassword) {
		this.DBPassword = DBPassword;
	}
	public String getLDBPassword() {
		return LDBPassword;
	}
	private void setLDBPassword(String LDBPassword) {
		this.LDBPassword = LDBPassword;
	}
		
	//TablePrefix
	public String getDBTablePrefix() {
		return DBTablePrefix;
	}
	private void setDBTablePrefix(String DBTablePrefix) {
		this.DBTablePrefix = DBTablePrefix;
	}
	public String getLDBTablePrefix() {
		return LDBTablePrefix;
	}
	private void setLDBTablePrefix(String LDBTablePrefix) {
		this.LDBTablePrefix = LDBTablePrefix;
	}
	
	private String getPassword() {
		return password;
	}
	
	//DBDriver
	public String EncryptDBDriver(String DBDriver) {
		Cipher cipher = null;
		int ctLength = 0;
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		byte[] input = DBDriver.getBytes();
		byte[] keyBytes = getPassword().getBytes();

		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		} catch (NoSuchAlgorithmException | NoSuchProviderException	| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		//System.out.println(new String(input));

		// encryption pass
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		try {
			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		} catch (ShortBufferException e) {
			e.printStackTrace();
		}
		try {
			ctLength += cipher.doFinal(cipherText, ctLength);
		} catch (IllegalBlockSizeException | ShortBufferException | BadPaddingException e) {
			e.printStackTrace();
		}
		setLDBDriver(String.valueOf(ctLength));
		return new String(cipherText);
	}
	
	//DBName
	public String EncryptDBName(String DBName) {
		Cipher cipher = null;
		int ctLength = 0;
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		byte[] input = DBName.getBytes();
		byte[] keyBytes = getPassword().getBytes();

		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		} catch (NoSuchAlgorithmException | NoSuchProviderException	| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		//System.out.println(new String(input));

		// encryption pass
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		try {
			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		} catch (ShortBufferException e) {
			e.printStackTrace();
		}
		try {
			ctLength += cipher.doFinal(cipherText, ctLength);
		} catch (IllegalBlockSizeException | ShortBufferException | BadPaddingException e) {
			e.printStackTrace();
		}
		setLDBName(String.valueOf(ctLength));
		return new String(cipherText);
	}
	
	//DBUserName
	public String EncryptDBUserName(String DBUserName) {
		Cipher cipher = null;
		int ctLength = 0;
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		byte[] input = DBUserName.getBytes();
		byte[] keyBytes = getPassword().getBytes();

		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		} catch (NoSuchAlgorithmException | NoSuchProviderException	| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		//System.out.println(new String(input));

		// encryption pass
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		try {
			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		} catch (ShortBufferException e) {
			e.printStackTrace();
		}
		try {
			ctLength += cipher.doFinal(cipherText, ctLength);
		} catch (IllegalBlockSizeException | ShortBufferException | BadPaddingException e) {
			e.printStackTrace();
		}
		setLDBUserName(String.valueOf(ctLength));
		return new String(cipherText);
	}
	
	//DBPassword
	public String EncryptDBPassword(String DBPassword) {
		Cipher cipher = null;
		int ctLength = 0;
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		byte[] input = DBPassword.getBytes();
		byte[] keyBytes = getPassword().getBytes();

		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		} catch (NoSuchAlgorithmException | NoSuchProviderException	| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		//System.out.println(new String(input));

		// encryption pass
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		try {
			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		} catch (ShortBufferException e) {
			e.printStackTrace();
		}
		try {
			ctLength += cipher.doFinal(cipherText, ctLength);
		} catch (IllegalBlockSizeException | ShortBufferException | BadPaddingException e) {
			e.printStackTrace();
		}
		setLDBPassword(String.valueOf(ctLength));
		return new String(cipherText);
	}
	
	//DBTablePrefix
	public String EncryptDBTablePrefix(String DBTablePrefix) {
		Cipher cipher = null;
		int ctLength = 0;
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());  
		byte[] input = DBTablePrefix.getBytes();
		byte[] keyBytes = getPassword().getBytes();

		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
		} catch (NoSuchAlgorithmException | NoSuchProviderException	| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		//System.out.println(new String(input));

		// encryption pass
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
		try {
			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
		} catch (ShortBufferException e) {
			e.printStackTrace();
		}
		try {
			ctLength += cipher.doFinal(cipherText, ctLength);
		} catch (IllegalBlockSizeException | ShortBufferException | BadPaddingException e) {
			e.printStackTrace();
		}
		setLDBTablePrefix(String.valueOf(ctLength));
		return new String(cipherText);
	}
	
}
