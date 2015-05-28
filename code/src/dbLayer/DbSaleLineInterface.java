package dbLayer;

import java.util.ArrayList;

import modelLayer.SaleLine;

/**
 * DbSaleLineInterface
 * 
 * @author DarkSun + futz
 * @version 1.3
 */

public interface DbSaleLineInterface {
	
	public ArrayList<SaleLine> getAllSaleLinesForASale(int id_sale) throws Exception;
	public SaleLine findSaleLine(int id_saleLine, boolean retrieveAssoc) throws Exception;
	public int insertSaleLine(SaleLine sl, int id_sale) throws Exception;

}
