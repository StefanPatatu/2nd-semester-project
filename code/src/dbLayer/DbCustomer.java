package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Customer;

/**
 * DbCustomer
 * 
 * @author Kool-kat + futz
 * @version 1.2
 */

public class DbCustomer implements DbCustomerInterface {
	
	private DbAddressInterface dbAddress = new DbAddress();
	
	@Override
	public ArrayList<Customer> getAllCustomers() throws Exception {
		return miscWhere("", false);
	}
	
	@Override
	public Customer findCustomer(int id_customer) throws Exception{
		Customer c = singleWhere("id_customer=" + id_customer, true);
		return c;
	}
	
	@Override
	public ArrayList<Customer> searchCustomerByName(String name) throws Exception {
		return miscWhere("name LIKE '%" + name + "%'", false);
	}
	
	@Override
	public int insertCustomer(Customer c) throws Exception {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.DBTablePrefix + "Customer (name, phoneNr, email, c_address, street) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, c.getName());
			statement.setString(2, c.getPhoneNr());
			statement.setString(3, c.getEmail());
			statement.setInt(4, c.getAddress().getId_address());
			statement.setString(5, c.getStreet());
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
	
	@Override
	public int updateCustomer(Customer c) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Customer SET name=?, phoneNr=?, email=?, c_address=?, street=? WHERE id_customer=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, c.getName());
			statement.setString(2, c.getPhoneNr());
			statement.setString(3, c.getEmail());
			statement.setInt(4, c.getAddress().getId_address());
			statement.setString(5, c.getStreet());
			statement.setInt(6, c.getId_customer());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateCustomer.DbCustomer.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateCustomer.DbCustomer.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Customer";
		if(where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private Customer buildCustomer(ResultSet resultSet) throws Exception {
		Customer c = null;
		try {
			c = new Customer(
					resultSet.getInt("id_customer"),
					resultSet.getString("name"),
					new Address(resultSet.getInt("c_address")),
					resultSet.getString("street"),
					resultSet.getString("phoneNr"),
					resultSet.getString("email"));
		} catch (Exception e) {
			throw new Exception("buildCustomer.DbCustomer.dbLayer", e);
		}
		return c;
	}
	
	private Customer singleWhere(String where, boolean retrieveAssoc) throws Exception {
		ArrayList<Customer> customers = miscWhere(where, retrieveAssoc);
		if(customers.size() > 0) {
			if(retrieveAssoc) {
				customers.get(0).setAddress(dbAddress.findAddress(customers.get(0).getAddress().getId_address()));
			}
			return customers.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Customer> miscWhere(String where, boolean retrieveAssoc) throws Exception {
		ResultSet resultSet;
		ArrayList<Customer> customers = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Customer c = buildCustomer(resultSet);
				if(retrieveAssoc) {
					//nothing
				}
				customers.add(c);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbCustomer.dbLayer", e);
		}
		return customers;
	}
}
