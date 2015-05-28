package dbLayer;

import java.util.ArrayList;

import modelLayer.Invoice;

/**
 * DbCustomerInterface
 * 
 * @author frunziss + futz
 * @version 1.3
 */

public interface DbInvoiceInterface {
	
	public ArrayList<Invoice> getAllInvoices() throws Exception;
	public Invoice findInvoice(int id_invoice, boolean retrieveAssoc) throws Exception;
	public int insertInvoice(Invoice i) throws Exception;
	public int updateInvoice(Invoice i) throws Exception;
	public int updateInvoiceIsPaid(int id_invoice) throws Exception;
	
}
