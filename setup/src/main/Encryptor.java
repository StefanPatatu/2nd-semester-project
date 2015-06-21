package main;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimplePBEConfig;
import org.jasypt.properties.PropertyValueEncryptionUtils;


public class Encryptor {
	
	private String DBDriver;
	private String DBName;
	private String DBUserName;
	private String DBPassword;
	private String DBTablePrefix;
	
	Generator generator = null;
	
	private StandardPBEStringEncryptor encryptor = null;
	private final String password = "1B7C4DD1C6IGHIUW955953226444GKS";
	private final String algorithm = "PBEWithMD5AndDES";
	private final int iterations = 1000;
	
	public Encryptor() {
		generator = new Generator();
		
		SimplePBEConfig config = new SimplePBEConfig(); 
		config.setAlgorithm(algorithm);
		config.setKeyObtentionIterations(iterations);
		config.setPassword(password);
		
		encryptor = new StandardPBEStringEncryptor();
		encryptor.setConfig(config);
		encryptor.initialize();
		
		Encrypt();
	}
	
	public String getDBQuery() {
		return generator.getDBQuery();
	}
	
	private void Encrypt() {
		setDBDriver(PropertyValueEncryptionUtils.encrypt(generator.getDBDriver(), encryptor));
		setDBName(PropertyValueEncryptionUtils.encrypt(generator.getDBName(), encryptor));
		setDBUserName(PropertyValueEncryptionUtils.encrypt(generator.getDBUserName(), encryptor));
		setDBPassword(PropertyValueEncryptionUtils.encrypt(generator.getDBPassword(), encryptor));
		setDBTablePrefix(PropertyValueEncryptionUtils.encrypt(generator.getDBTablePrefix(), encryptor));
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
	
}
