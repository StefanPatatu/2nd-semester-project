package dbLayer;

import java.sql.Timestamp;
import java.util.ArrayList;

import modelLayer.Sale;

/**
 * DbSaleInterface
 * 
 * @author DarkSun
 * @version 1.0
 */

public interface DbSaleInterface {
	
	public ArrayList<Sale> getAllSales();
	public Sale findSaleById_sale(int id_Sale);
	public Sale findSaleBySaleNr(String saleNr);
	public ArrayList<Sale> searchSaleByDateCreated(Timestamp dateCreated);
	public ArrayList<Sale> searchSalesByPayment(boolean isPaid);
	public int insertSale(Sale s);
	public int updateSale(Sale s);
}
