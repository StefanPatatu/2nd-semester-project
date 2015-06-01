package authLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimplePBEConfig;
import org.jasypt.properties.PropertyValueEncryptionUtils;

/**
 * ReadSetupFile
 * 
 * @author futz
 * @version 2.2
 */

public class ReadSetupFile {
	
	private String DBDriver;
	private String DBName;
	private String DBUserName;
	private String DBPassword;
	private String DBTablePrefix;
	
	private StandardPBEStringEncryptor encryptor = null;
	private final String password = "1B7C4DD1C6IGHIUW955953226444GKS";
	private final String algorithm = "PBEWithMD5AndDES";
	private final int iterations = 1000;
	
	//constructor
	public ReadSetupFile() throws Exception {
		if(!getProperties()) {
			throw new Exception("Error reading setup file in ReadSetupFile.ReadSetupFile.authLayer.");
		}
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
	
	private boolean getProperties() {
		
		SimplePBEConfig config = new SimplePBEConfig(); 
		config.setAlgorithm(algorithm);
		config.setKeyObtentionIterations(iterations);
		config.setPassword(password);
		
		encryptor = new StandardPBEStringEncryptor();
		encryptor.setConfig(config);
		encryptor.initialize();
		
		Properties prop = new Properties();
		InputStream input = null;
		
	 	try {
	 		input = new FileInputStream("setup.properties");
	 		// load a properties file
			prop.load(input);
	 		// get and decode the properties value
			setDBDriver(PropertyValueEncryptionUtils.decrypt(prop.getProperty("DBDriver"), encryptor));
			setDBName(PropertyValueEncryptionUtils.decrypt(prop.getProperty("DBName"), encryptor));
			setDBUserName(PropertyValueEncryptionUtils.decrypt(prop.getProperty("DBUserName"), encryptor));
			setDBPassword(PropertyValueEncryptionUtils.decrypt(prop.getProperty("DBPassword"), encryptor));
			setDBTablePrefix(PropertyValueEncryptionUtils.decrypt(prop.getProperty("DBTablePrefix"), encryptor));			
	 	} catch (IOException ex) {
			return false;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					return false;
				}
			}
		}
		return true;  
	}

}
