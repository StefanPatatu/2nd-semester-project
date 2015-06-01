package controlLayer;

import dbLayer.CheckConnectionInterface;
import dbLayer.CheckConnection;

/**
 * CtrCheckConnection
 * 
 * @author futz
 * @version 1.0
 */

public class CtrCheckConnection {
	
	private CheckConnectionInterface checkConnection;
	
	public CtrCheckConnection() {
		checkConnection = new CheckConnection();
	}
	
	public boolean isValidd() {
		return checkConnection.isValidd();
	}

}
