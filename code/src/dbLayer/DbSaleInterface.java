package dbLayer;

import java.sql.Timestamp;
import java.util.ArrayList;

import modelLayer.Sale;

/**
 * DbSaleInterface
 * 
 * @author DarkSun + futz
 * @version 1.4
 */

public interface DbSaleInterface {
	
	public ArrayList<Sale> getAllSales() throws Exception;
	public Sale findSaleById_sale(int id_sale, boolean retrieveAssoc) throws Exception;
	public Sale findSaleBySaleNr(String saleNr, boolean retrieveAssoc) throws Exception;
	public ArrayList<Sale> searchSaleBySaleStatuses(boolean isPacked, boolean isSent, boolean isPaid) throws Exception;
	public ArrayList<Sale> searchSaleByDateCreatedInterval(Timestamp dateCreatedMin, Timestamp dateCreatedMax) throws Exception;
	public int insertSale(Sale s, int id_inv) throws Exception;
	public int updateSaleIsPacked(boolean isPacked, int id_sale) throws Exception;
	public int updateSaleIsSent(boolean isSent, int id_sale) throws Exception;
	public int updateSaleIsPaid(boolean isPaid, int id_sale) throws Exception;
	public ArrayList<Sale> getAllUnpaidSalesForCustomer(int id_customer) throws Exception;
	public ArrayList<Sale> getAllSalesForCustomer(int id_customer) throws Exception;
	public int addSalesToInvoice(int id_invoice, ArrayList<Sale> sales) throws Exception;
	
}
