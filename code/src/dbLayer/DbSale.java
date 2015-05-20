package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Sale;
import modelLayer.Employee;
import modelLayer.Customer;
import modelLayer.SaleLine;

/**
 * DBSale
 * 
 * @author DarkSun
 * @version 1.0
 */

public class DbSale implements DbSaleInterface {

	@Override
	public ArrayList<Sale> getAllSales() {
		return miscWhere("", false);
	}

	@Override
	public Sale findSaleById_sale(int id_Sale) {
		Sale s = singleWhere("id_sale=" + id_Sale, true);
		return s;
	}

	@Override
	public Sale findSaleBySaleNr(String saleNr) {
		Sale s = singleWhere("saleNr=" + saleNr, true);
		return s;
	}

	@Override
	public ArrayList<Sale> searchSaleByDateCreated(Timestamp dateCreated) {
		return miscWhere("dateCreated LIKE '%" + dateCreated, false);
	}

	@Override
	public ArrayList<Sale> searchSalesByPayment(boolean isPaid) {
		return miscWhere("isPaid LIKE '%" + isPaid, false);
	}

	@Override
	public int insertSale(Sale s) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.getTablePrefix() + "Sale (saleNr, discount, dateCreated, isPacked, datePacked, isSent, dateSent, isPaid, datepaid, id_e, id_c VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
	    	result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_employee = new GeneratedKey().getGeneratedKey(statement);
			s.setId_employee(id_sale);
		} catch (SQLException sqle) {
			throw new SQLException("insertSale.DbSale.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertSale.DbSale.dbLayer", e); 
		}
		return result;
	}

	@Override
	public int updateSale(Sale s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.getTablePrefix() + "Sale";
		if (where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private Sale buildSale(ResultSet resultSet) throws Exception {
		Sale s = null;
		try {
			s = new Sale(
					resultSet.getInt("id_Sale"),
					resultSet.getString("saleNr"),
					resultSet.getTimestamp("dateCreated"),
					resultSet.getBoolean("isPacked"),
					resultSet.getTimestamp("datePacked"),
					resultSet.getBoolean("isSent"),
					resultSet.getTimestamp("dateSent"),
					resultSet.getBoolean("isPaid"),
					resultSet.getTimestamp("datePaid"),
					new Employee(resultSet.getInt("id_e")),
					new Customer(resultSet.getInt("id_c"));									
		} catch (Exception e) {
			throw new Exception ("buildSale.DbSale.dblayer");
		}
		return s;
	}
	
	private Sale singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Sale> sales = miscWhere(where, retrieveAssoc);
		if (sales.size() > 0) {
			if(retrieveAssoc) {
				//soon
			}
			return sales.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Sale> miscWhere(String where, boolean retrieveAssoc) { 
		ResultSet resultSet;
		ArrayList<Sale> sales = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon().createStatement()) {
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

}
