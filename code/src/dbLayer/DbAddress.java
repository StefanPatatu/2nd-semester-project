package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;

/**
 * DbAddress
 * 
 * @author futz
 * @version 1.0
 */

public class DbAddress implements DbAddressInterface {
	
	@Override
	public ArrayList<Address> getAllAddresses() {
		return miscWhere("", false);
	}
	
	@Override
	public Address findAddress(int id_address) {
		Address a = singleWhere("id_address=" + id_address, false);
		return a;
	}
	
	@Override
	public ArrayList<Address> searchAddressByCountry(String country) {
		return miscWhere("country LIKE '%" + country + "%'", false);
	}
	
	@Override
	public ArrayList<Address> searchAddressByCity(String city) {
		return miscWhere("city LIKE '%" + city + "%'", false);
	}
	
	@Override
	public int insertAddress(Address a) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.getTablePrefix() + "Address (country, city) VALUES (?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setString(1, a.getCountry());
			statement.setString(2, a.getCity());
			result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_address = new GeneratedKey().getGeneratedKey(statement);
			a.setId_address(id_address);
		} catch (SQLException sqle) {
			throw new SQLException("insertAddress.DbAddress.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertAddress.DbAddress.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int updateAddress(Address a) {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.getTablePrefix() + "Address SET country=?, city=? WHERE id_address=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setString(1, a.getCountry());
			statement.setString(2, a.getCity());
			statement.setInt(3, a.getId_address());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateAddress.DbAddress.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateAddress.DbAddress.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int removeAddress(Address a) {
		if(a == null) {
			return 0;
		}
		int result = 0;
		String string = "DELETE FROM " + authLayer.DbConfig.getTablePrefix() + "Address WHERE id_address=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setInt(1, a.getId_address());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("removeAddress.DbAddress.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("removeAddress.DbAddress.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.getTablePrefix() + "Address";
		if(where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private Address buildAddress(ResultSet resultSet) throws Exception {
		Address a = null;
		try {
			a = new Address(
					resultSet.getInt("id_address"),
					resultSet.getString("country"),
					resultSet.getString("city"));
		} catch (Exception e) {
			throw new Exception("buildAddress.DbAddress.dbLayer", e);
		}
		return a;
	}
	
	private Address singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Address> addresses = miscWhere(where, retrieveAssoc);
		if(addresses.size() > 0) {
			return addresses.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Address> miscWhere(String where, boolean retrieveAssoc) {
		ResultSet rsresultSet;
		ArrayList<Address> addresses = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon().createStatement()) {
			statement.setQueryTimeout(5);
			rsresultSet = statement.executeQuery(string);
			while(rsresultSet.next()) {
				Address a = buildAddress(rsresultSet);
				if(retrieveAssoc) {
					//nothing
				}
				addresses.add(a);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbAddress.dbLayer", e);
		}
		return addresses;
	}

}
