package dbLayer;
import java.util.ArrayList;

import java.sql.Timestamp;

import modelLayer.Purchase;


/**
 * DbSaleInterface
 * 
 * @author frunziss + futz
 * @version 1.0 !
 */

public interface DbPurchaseInterface {
	
	public ArrayList<Purchase> getAllPurchases();
	public Purchase findPurchaseById_purchase(int id_purchase);
	public ArrayList<Purchase> findPurchasesByDateCreated(Timestamp dateCreated);
	public ArrayList<Purchase> findPurchasesByDateDelivered(Timestamp dateDelivered);
	public int insertPurchase(Purchase p);
	public int updatePurchase(Purchase p);
}
