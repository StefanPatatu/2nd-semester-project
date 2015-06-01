package dbLayer;

import java.sql.*;

/**
 * CheckConnection
 * 
 * @author futz
 * @version 1.2
 */

public class CheckConnection implements CheckConnectionInterface {
	
	//returns boolean true if connection available
	//returns boolean false if connection not available
	@Override
	public boolean isValidd() {
		boolean isValidd;
		try {
			isValidd = performCheck();
		} catch (Exception e) {
			isValidd = false;
		}
		return isValidd;
	}
	
	private boolean performCheck() {
		ResultSet resultSet = null;
		boolean isActive;
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery("SELECT 0914");
			if(resultSet.next()) {
				isActive = true;
			} else {
				isActive = false;
			}
		} catch (Exception e) {
			isActive = false;
		}
		return isActive;
	}

}
