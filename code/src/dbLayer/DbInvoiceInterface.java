package dbLayer;

import java.util.ArrayList;

import modelLayer.Invoice;

/**
 * DbCustomerInterface
 * 
 * @author Kool-kat
 * @version 1.0
 */

public interface DbInvoiceInterface {
	
	public ArrayList<Invoice> getAllInvoices();
	public Invoice findInvoice(int id_invoice);
	public int insertInvoice(Invoice i);
	public int updateInvoice(Invoice i);
	
}
