package authLayer;

/**
 * Address
 * 
 * @author futz
 * @version 2.0
 */

public class DbConfig {
	
	private String DBDriver;
	private String DBName;
	private String DBUserName;
	private String DBPassword;
	private static String DBTablePrefix;
	
	//constructor
	public DbConfig() throws Exception {
		ReadSetupFile reader = new ReadSetupFile();
		
		this.setDBDriver(reader.getDBDriver());
		this.setDBName(reader.getDBName());
		this.setDBUserName(reader.getDBUserName());
		this.setDBPassword(reader.getDBPassword());
		DBTablePrefix = reader.getDBTablePrefix();
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
	
}
