package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Sale;
import modelLayer.Employee;
import modelLayer.Customer;
import modelLayer.SaleLine;

/**
 * DbSale
 * 
 * @author DarkSun + futz
 * @version 1.6
 */

public class DbSale implements DbSaleInterface {
	
	private DbEmployeeInterface dbEmployee = new DbEmployee();
	private DbCustomerInterface dbCustomer = new DbCustomer();
	private DbSaleLineInterface dbSaleLine = new DbSaleLine();

	@Override
	public ArrayList<Sale> getAllSales() throws Exception {
		return miscWhere("", false);
	}

	@Override
	public Sale findSaleById_sale(int id_sale, boolean retrieveAssoc) throws Exception {
		Sale s = singleWhere("id_sale='" + id_sale + "'", retrieveAssoc);
		return s;
	}

	@Override
	public Sale findSaleBySaleNr(String saleNr, boolean retrieveAssoc) throws Exception {
		Sale s = singleWhere("saleNr='" + saleNr + "'", retrieveAssoc);
		return s;
	}
	
	@Override
	public ArrayList<Sale> searchSaleBySaleStatuses(boolean isPacked, boolean isSent, boolean isPaid) throws Exception {
		int isPackedBIT = 0;
		int isSentBIT = 0;
		int isPaidBIT = 0;
		if (isPacked == true) isPackedBIT = 1;
		if (isSent == true) isSentBIT = 1;
		if (isPaid == true) isPaidBIT = 1;
		return miscWhere("isPacked=" + isPackedBIT + " AND isSent=" + isSentBIT + " AND isPaid=" + isPaidBIT, false);
	}

	@Override
	public ArrayList<Sale> searchSaleByDateCreatedInterval(Timestamp dateCreatedMin, Timestamp dateCreatedMax) throws Exception {
		ResultSet resultSet;
		ArrayList<Sale> sales = new ArrayList<>();
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Sale WHERE dateCreated BETWEEN ? AND ?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setTimestamp(1, dateCreatedMin);
			statement.setTimestamp(2, dateCreatedMax);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Sale s = buildSale(resultSet);
				sales.add(s);
			}
		} catch (SQLException sqle) {
			throw new SQLException("searchSaleByDateCreatedInterval.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("searchSaleByDateCreatedInterval.DbSale.dbLayer", e);
		}
		return sales;
	}

	@Override
	public int insertSale(Sale s, int id_inv) throws Exception {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.DBTablePrefix + "Sale (saleNr, discount, dateCreated, isPacked, datePacked, isSent, dateSent, isPaid, datePaid, id_e, id_c, id_inv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string, Statement.RETURN_GENERATED_KEYS)) {
	    	statement.setString(1, s.getSaleNr());
	    	statement.setInt(2, s.getDiscount());
	    	statement.setTimestamp(3, s.getDateCreated());
	    	statement.setBoolean(4, s.isPacked());
	    	statement.setTimestamp(5, s.getDatePacked());
	    	statement.setBoolean(6, s.isSent());
	    	statement.setTimestamp(7, s.getDateSent());
	    	statement.setBoolean(8, s.isPaid());
	    	statement.setTimestamp(9, s.getDatePaid());
	    	statement.setInt(10, s.getEmployee().getId_employee());
	    	statement.setInt(11, s.getCustomer().getId_customer());
	    	if(id_inv == -1) {
	    		statement.setNull(12, Types.INTEGER);
	    	} else {
	    		statement.setInt(12, id_inv);
	    	}
	    	result = statement.executeUpdate();
			int id_sale = new GeneratedKey().getGeneratedKey(statement);
			s.setId_sale(id_sale);
		} catch (SQLException sqle) {
			throw new SQLException("insertSale.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertSale.DbSale.dbLayer", e); 
		}
		return result;
	}

	@Override
	public int updateSaleIsPacked(boolean isPacked, int id_sale) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Sale SET isPacked=? WHERE id_sale=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setBoolean(1, isPacked);
			statement.setInt(2, id_sale);
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateSaleIsPacked.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updateSaleIsPacked.DbSale.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int updateSaleIsSent(boolean isSent, int id_sale) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Sale SET isSent=? WHERE id_sale=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setBoolean(1, isSent);
			statement.setInt(2, id_sale);
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateSaleIsSent.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updateSaleIsSent.DbSale.dbLayer", e);
		}
		return result;		
	}
	
	@Override
	public int updateSaleIsPaid(boolean isPaid, int id_sale) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Sale SET isPaid=? WHERE id_sale=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setBoolean(1, isPaid);
			statement.setInt(2, id_sale);
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateSaleIsPaid.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updateSaleIsPaid.DbSale.dbLayer", e);
		}
		return result;	
	}
	
	@Override
	public ArrayList<Sale> getAllUnpaidSalesForCustomer(int id_customer) throws Exception {
		ResultSet resultSet;
		ArrayList<Sale> sales = new ArrayList<>();
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Sale WHERE id_c=? AND isPaid=? AND id_inv IS NULL";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setInt(1, id_customer);
			statement.setBoolean(2, false);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Sale s = buildSale(resultSet);
				sales.add(s);
			}
		} catch (SQLException sqle) {
			throw new SQLException("getAllUnpaidSalesForCustomer.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("getAllUnpaidSalesForCustomer.DbSale.dbLayer", e);
		}
		return sales;
	}
	
	@Override
	public ArrayList<Sale> getAllSalesForCustomer(int id_customer) throws Exception {
		ResultSet resultSet;
		ArrayList<Sale> sales = new ArrayList<>();
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Sale WHERE id_c=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setInt(1, id_customer);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Sale s = buildSale(resultSet);
				sales.add(s);
			}
		} catch (SQLException sqle) {
			throw new SQLException("getAllSalesForCustomer.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("getAllSalesForCustomer.DbSale.dbLayer", e);
		}
		return sales;
	}
	
	@Override
	public int addSalesToInvoice(int id_invoice, ArrayList<Sale> sales) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Sale SET id_inv=? WHERE id_sale=?";
		for (Sale sale : sales) {
			try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
				statement.setInt(1, id_invoice);
				statement.setInt(2, sale.getId_sale());
				result += statement.executeUpdate();
			} catch (SQLException sqle) {
				throw new SQLException("addSalesToInvoice.DbSale.dbLayer", sqle);
			} catch (Exception e) {
				throw new Exception("addSalesToInvoice.DbSale.dbLayer", e); 
			}
		}
		return result;
	}
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.DBTablePrefix + "Sale";
		if (where != null && where.length() > 0) {
			string += " WHERE " + where;
		}
		return string;
	}
	
	private Sale buildSale(ResultSet resultSet) throws Exception {
		Sale s = null;
		try {
			s = new Sale(
					resultSet.getInt("id_Sale"),
					resultSet.getString("saleNr"),
					resultSet.getInt("discount"),
					resultSet.getTimestamp("dateCreated"),
					resultSet.getBoolean("isPacked"),
					resultSet.getTimestamp("datePacked"),
					resultSet.getBoolean("isSent"),
					resultSet.getTimestamp("dateSent"),
					resultSet.getBoolean("isPaid"),
					resultSet.getTimestamp("datePaid"),
					new Employee(resultSet.getInt("id_e")),
					new Customer(resultSet.getInt("id_c")));									
		} catch (Exception e) {
			throw new Exception ("buildSale.DbSale.dblayer");
		}
		return s;
	}
	
	private Sale singleWhere(String where, boolean retrieveAssoc) throws Exception {
		ArrayList<Sale> sales = miscWhere(where, retrieveAssoc);
		if (sales.size() > 0) {
			if(retrieveAssoc) {
				sales.get(0).setEmployee(dbEmployee.findEmployeeById_employee(sales.get(0).getEmployee().getId_employee(), false));
				sales.get(0).setCustomer(dbCustomer.findCustomer(sales.get(0).getCustomer().getId_customer(), false));
				sales.get(0).setSaleLines(getAllSaleLinesForASale(sales.get(0).getId_sale()));
			}
			return sales.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Sale> miscWhere(String where, boolean retrieveAssoc) throws Exception { 
		ResultSet resultSet;
		ArrayList<Sale> sales = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Sale s = buildSale(resultSet);
				if (retrieveAssoc) {
					//nothing
				}
				sales.add(s);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbEmployee.dbLayer", e);
		}
		return sales;		
	}
	
	private ArrayList<SaleLine> getAllSaleLinesForASale(int id_sale) throws Exception {
		ArrayList<SaleLine> saleLines = new ArrayList<>();
		saleLines = dbSaleLine.getAllSaleLinesForASale(id_sale);
		return saleLines;
	}

}
