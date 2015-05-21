package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Base64;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		Encryptor encryptor = new Encryptor();
		
		Properties prop = new Properties();
		OutputStream output = null;
	 
		try {
	 		output = new FileOutputStream("setup.properties");
	 		// set the properties value
			prop.setProperty("DBDriver", Base64.getEncoder().encodeToString(encryptor.getDBDriver().getBytes("utf-8")));
			prop.setProperty("LDBDriver", encryptor.getLDBDriver());
			prop.setProperty("DBName", Base64.getEncoder().encodeToString(encryptor.getDBName().getBytes("utf-8")));
			prop.setProperty("LDBName", encryptor.getLDBName());
			prop.setProperty("DBUserName", Base64.getEncoder().encodeToString(encryptor.getDBUserName().getBytes("utf-8")));
			prop.setProperty("LDBUserName", encryptor.getLDBUserName());
			prop.setProperty("DBPassword", Base64.getEncoder().encodeToString(encryptor.getDBPassword().getBytes("utf-8")));
			prop.setProperty("LDBPassword", encryptor.getLDBPassword());
			prop.setProperty("DBTablePrefix", Base64.getEncoder().encodeToString(encryptor.getDBTablePrefix().getBytes("utf-8")));
			prop.setProperty("LDBTablePrefix", encryptor.getLDBTablePrefix());
	 		// save properties to project root folder
			prop.store(output, null);
	 	} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}