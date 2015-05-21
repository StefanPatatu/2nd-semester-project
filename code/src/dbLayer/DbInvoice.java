package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Customer;
import modelLayer.Invoice;
import db.DbConnection;;

/**
 * DbCustomer
 * 
 * @author Kool-kat + futz
 * @version 1.1
 */

public class DbInvoice implements DbInvoiceInterface {
	
	private DbCustomerInterface dbCustomer = new DbCustomer();
	
	@Override
	public ArrayList<Invoice> getAllInvoices() {
		return miscWhere("", false);
	}
	
	@Override
	public Invoice findInvoice(int id_invoice){
		Invoice i = singleWhere("id_invoice=" + id_invoice, true);
		return i;
	}
	
	
	
	@Override
	public int insertInvoice(Invoice i) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.getTablePrefix() + "Invoice (id_invoice, invoiceNr, dateCreated, isPaid, datePaid, id_c) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setInt(1, i.getId_invoice());
			statement.setString(2, i.getInvoiceNr());
			statement.setTimestamp(3, i.getDateCreated());
			statement.setBoolean(4, i.isPaid());
			statement.setTimestamp(5, i.getDatePaid());
			statement.setInt(6, i.getCustomer().getId_customer());
			result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_invoice = new GeneratedKey().getGeneratedKey(statement);
			i.setId_invoice(id_invoice);
		} catch (SQLException sqle) {
			throw new SQLException("insertInvoice.DbInvoice.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("insertInvoice.DbInvoice.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int updateInvoice(Invoice i) {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.getTablePrefix() + "Invoice SET id_invoice=?, invoiceNr=?, dateCreated=?, isPaid=?, date_paid, id_c=? WHERE id_invoice=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setInt(1, i.getId_invoice());
			statement.setString(2, i.getInvoiceNr());
			statement.setTimestamp(3, i.getDateCreated());
			statement.setBoolean(4, i.isPaid());
			statement.setTimestamp(5, i.getDatePaid());
			statement.setInt(6, i.getCustomer().getId_customer());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateInvoice.DbInvoice.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateInvoice.DbInvoice.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.getTablePrefix() + "Invoice";
		if(where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private Invoice buildInvoice(ResultSet resultSet) throws Exception {
		Invoice i = null;
		try {
			i = new Invoice(
					resultSet.getInt("id_invoice"),
					resultSet.getString("invoiceNr"),
					resultSet.getTimestamp("dateCreated"),
					resultSet.getBoolean("isPaid"),
					resultSet.getTimestamp("datePaid"),
					new Customer(resultSet.getInt("id_c")));
		} catch (Exception e) {
			throw new Exception("buildCustomer.DbCustomer.dbLayer", e);
		}
		return i;
	}
	
	private Invoice singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Invoice> invoices = miscWhere(where, retrieveAssoc);
		if(invoices.size() > 0) {
			if(retrieveAssoc) {
				invoices.get(0).setCustomer(dbCustomer.findCustomer(invoices.get(0).getCustomer().getId_customer()));
			}
			return invoices.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Invoice> miscWhere(String where, boolean retrieveAssoc) {
		ResultSet resultSet;
		ArrayList<Invoice> invoices = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Invoice i = buildInvoice(resultSet);
				if(retrieveAssoc) {
					//nothing
				}
				invoices.add(i);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbInvoice.dbLayer", e);
		}
		return invoices;
	}
}
