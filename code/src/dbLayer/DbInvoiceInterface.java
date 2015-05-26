package dbLayer;

import java.util.ArrayList;

import modelLayer.Invoice;

/**
 * DbCustomerInterface
 * 
 * @author Kool-kat
 * @version 1.2
 */

public interface DbInvoiceInterface {
	
	public ArrayList<Invoice> getAllInvoices() throws Exception;
	public Invoice findInvoice(int id_invoice) throws Exception;
	public int insertInvoice(Invoice i) throws Exception;
	public int updateInvoice(Invoice i) throws Exception;
	
}
