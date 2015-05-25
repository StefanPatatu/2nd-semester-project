package dbLayer;

import java.util.ArrayList;
import modelLayer.*;



/**
 * DbPurchaseLineInterface
 * 
 * @author 
 * @version 1.0
 */

public interface DbPurchaseLineInterface {
	public ArrayList<PurchaseLine> getAllPurchaseLines();
	public PurchaseLine findPurchaseLine(int id_purchaseLine);
	public int insertPurchaseLine(PurchaseLine pl);

}
