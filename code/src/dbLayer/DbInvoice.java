package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;

/**
 * DbCustomer
 * 
 * @author frunziss + futz (who is going to kill you!)
 * @version 1.6
 */

public class DbInvoice implements DbInvoiceInterface {
	
	private DbCustomerInterface dbCustomer = new DbCustomer();
	
	@Override
	public ArrayList<Invoice> getAllInvoices() throws Exception {
		return miscWhere("", false);
	}
	
	@Override
	public Invoice findInvoice(int id_invoice, boolean retrieveAssoc) throws Exception {
		Invoice i = singleWhere("id_invoice='" + id_invoice + "'", retrieveAssoc);
		return i;
	}
	
	@Override
	public int insertInvoice(Invoice i) throws Exception {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.DBTablePrefix + "Invoice (invoiceNr, dateCreated, isPaid, datePaid, id_c) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, i.getInvoiceNr());
			statement.setTimestamp(2, i.getDateCreated());
			statement.setBoolean(3, i.isPaid());
			statement.setTimestamp(4, i.getDatePaid());
			statement.setInt(5, i.getCustomer().getId_customer());
			result = statement.executeUpdate();
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
	public int updateInvoice(Invoice i) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Invoice SET invoiceNr=?, dateCreated=?, isPaid=?, datePaid=?, id_c=? WHERE id_invoice=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, i.getInvoiceNr());
			statement.setTimestamp(2, i.getDateCreated());
			statement.setBoolean(3, i.isPaid());
			statement.setTimestamp(4, i.getDatePaid());
			statement.setInt(5, i.getCustomer().getId_customer());
			statement.setInt(6, i.getId_invoice());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateInvoice.DbInvoice.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateInvoice.DbInvoice.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int updateInvoiceIsPaid(int id_invoice) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Invoice SET isPaid=? WHERE id_invoice=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setBoolean(1, true);
			statement.setInt(2, id_invoice);
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateInvoiceIsPaid.DbInvoice.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateInvoiceIsPaid.DbInvoice.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Invoice";
		if(where != null && where.length() > 0) {
			string += " WHERE " + where;
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
			throw new Exception("buildInvoice.DbInvoice.dbLayer", e);
		}
		return i;
	}
	
	private Invoice singleWhere(String where, boolean retrieveAssoc) throws Exception {
		ArrayList<Invoice> invoices = miscWhere(where, retrieveAssoc);
		if(invoices.size() > 0) {
			if(retrieveAssoc) {
				invoices.get(0).setCustomer(dbCustomer.findCustomer(invoices.get(0).getCustomer().getId_customer(), false));
			}
			return invoices.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Invoice> miscWhere(String where, boolean retrieveAssoc) throws Exception {
		ResultSet resultSet;
		ArrayList<Invoice> invoices = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
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
