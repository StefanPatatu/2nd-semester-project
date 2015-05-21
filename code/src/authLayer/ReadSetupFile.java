package authLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Base64;

public class ReadSetupFile {
	
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
	
	public ReadSetupFile() {
		getProperties();
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
	
	public boolean getProperties() {
		
		Properties prop = new Properties();
		InputStream input = null;
	 	try {
	 		input = new FileInputStream("setup.properties");
	 		// load a properties file
			prop.load(input);
	 		// get and decode the properties value
			byte[] decodedDBDriver = Base64.getDecoder().decode(prop.getProperty("DBDriver"));
			byte[] decodedDBName = Base64.getDecoder().decode(prop.getProperty("DBName"));
			byte[] decodedDBUserName = Base64.getDecoder().decode(prop.getProperty("DBUserName"));
			byte[] decodedDBPassword = Base64.getDecoder().decode(prop.getProperty("DBPassword"));
			byte[] decodedDBTablePrefix = Base64.getDecoder().decode(prop.getProperty("DBTablePrefix"));
			
			System.out.println(decodedDBDriver);
			System.out.println(decodedDBName);
			System.out.println(decodedDBUserName);
			System.out.println(decodedDBPassword);
			System.out.println(decodedDBTablePrefix);
			
			//set properties value
			setDBDriver(new String(decodedDBDriver,"utf-8"));
			setLDBDriver(prop.getProperty("LDBDriver"));
			
			setDBName(new String(decodedDBName,"utf-8"));
			setLDBName(prop.getProperty("LDBName"));
			
			setDBUserName(new String(decodedDBUserName, "utf-8"));
			setLDBUserName(prop.getProperty("LDBUserName"));
			
			setDBPassword(new String(decodedDBPassword, "utf-8"));
			setLDBPassword(prop.getProperty("LDBPassword"));
			
			setDBTablePrefix(new String(decodedDBTablePrefix,"utf-8"));
			setLDBTablePrefix(prop.getProperty("LDBTablePrefix"));
	 	} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;  
	}

}
