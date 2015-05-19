package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Customer;


/**
 * DbCustomer
 * 
 * @author Kool-kat
 * @version 1.0
 */

public class DbCustomer implements DbCustomerInterface {
	
	public ArrayList<Customer> getAllCustomers() {
		return miscWhere("", false);
	}
	
	public Customer findCustomer(int id_customer){
		Customer c = singleWhere("id_customer=" + id_customer, false);
		return c;
	}
	
	public ArrayList<Customer> searchCustomerByName(String name) {
		return miscWhere("name LIKE '%" + name + "&'", false);
	}
	
	
	public int insertCustomer(Customer c) {
		int result = 0;
		String string = "INSERT INTO" +authLayer.DbConfig.getTablePrefix() + "Customer (name) VALUES (?,?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setString(1, c.getName());
			result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_customer = new GeneratedKey().getGeneratedKey(statement);
			c.setId_customer(id_customer);
		} catch (SQLException sqle) {
			throw new SQLException("insertCustomer.DbCustomer.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("insertCustomer.DbCustomer.dbLayer", e);
		}
		return result;
	}
	
	public int updateCustomer(Customer c) {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.getTablePrefix() + "Customer SET name=?, WHERE id_customer=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setString(1, c.getName());
			statement.setInt(2, c.getId_customer());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateCustomer.DbCustomer.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateCustomer.DbCustomer.dbLayer", e);
		}
		return result;
	}
	
	public int removeCustomer(Customer c) {
		if(c == null) {
			return 0;
			
		}
		int result = 0;
		String string = "DELETE FROM " + authLayer.DbConfig.getTablePrefix() + "Customer WHERE id_customer=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setInt(1, c.getId_customer());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("removeCustomer.DbCustomer.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("removeCustomer.DbCustomer.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.getTablePrefix() + "Customer";
		if(where != null && where.length() > 0) {
			string += "WHERE" + where;
		}
		return string;
	}
	
	private Customer buildCustomer(ResultSet resultSet) throws Exception {
		Customer c = null;
		try {
			c = new Customer(
					resultSet.getInt("id_customer"),
					resultSet.getString("name"),
					(Address) resultSet.getObject("address"),
					resultSet.getString("street"),
					resultSet.getString("phoneNr"),
					resultSet.getString("email"));
		} catch (Exception e) {
			throw new Exception("buildCustomer.DbCustomer.dbLayer", e);
		}
		return c;
	}
	
	private Customer singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Customer> customers = miscWhere(where, retrieveAssoc);
		if(customers.size() > 0) {
			return customers.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Customer> miscWhere(String where, boolean retrieveAssoc) {
		ResultSet rsresultSet;
		ArrayList<Customer> customers = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon().createStatement()) {
			statement.setQueryTimeout(5);
			rsresultSet = statement.executeQuery(string);
			while(rsresultSet.next()) {
				Customer c = buildCustomer(rsresultSet);
				if(retrieveAssoc) {
					
				}
				customers.add(c);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbCustomer.dbLayer", e);
		}
		return customers;
	}
}
