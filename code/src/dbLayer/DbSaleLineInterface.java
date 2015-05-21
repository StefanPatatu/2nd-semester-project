package dbLayer;

import java.util.ArrayList;

import modelLayer.SaleLine;

/**
 * DbSaleLineInterface
 * 
 * @author DarkSun
 * @version 1.0
 */

public interface DbSaleLineInterface {
	public ArrayList<SaleLine> getAllSaleLines();
	public SaleLine findSaleLine(int id_saleLine);
	public int insertSaleLine(SaleLine sl);

}
