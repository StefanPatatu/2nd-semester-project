package dbLayer;

import java.util.ArrayList;

import modelLayer.SaleLine;

/**
 * DbSaleLineInterface
 * 
 * @author DarkSun + futz
 * @version 1.2
 */

public interface DbSaleLineInterface {
	
	public ArrayList<SaleLine> getAllSaleLinesForASale(int id_sale) throws Exception;
	public SaleLine findSaleLine(int id_saleLine) throws Exception;
	public int insertSaleLine(SaleLine sl, int id_sale) throws Exception;

}
