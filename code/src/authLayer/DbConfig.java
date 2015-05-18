package authLayer;

/**
 * Address
 * 
 * @author futz
 * @version 1.0
 */

public class DbConfig {
	
	private static String tablePrefix;
	
	private DbConfig() {
		DbConfig.setTablePrefix("aaaa!!!!!");
	}

	//tablePrefix
	public static String getTablePrefix() {
		return tablePrefix;
	}
	public static void setTablePrefix(String tablePrefix) {
		DbConfig.tablePrefix = tablePrefix;
	}

}
