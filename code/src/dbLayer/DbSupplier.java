package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Supplier;

/**
 * DbSupplier
 * 
 * @author Kool-kat
 * @Version 1.0 !
 */

public class DbSupplier implements DbSupplierInterface {
	
	private DbSupplierInterface dbAddress = new DbAddress();
	
	@Override
	public ArrayList<Supplier> getAllSuppliers() {
		return miscWhere("", false);
	}
	
	@Override
	public Supplier findSupplier(int id_supplier) {
		Supplier sp = singleWhere("id_supplier=" + id_supplier, true);
		return sp;
	}
	
	@Override
	public ArrayList<Supplier> searchSupplierByName(String name) {
		return miscWhere("name LIKE '%" + name + "%'", false);
	}
	
	@Override
	public int insertSupplier(Supplier sp) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.DBTablePrefix + "Supplier (name, phoneNr, email, isActive, sp_address, street) VALUES(?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, sp.getName());
			statement.setString(2, sp.getPhoneNr());
			statement.setString(3, sp.getEmail());
			statement.setBoolean(4, sp.isActive());
			statement.setInt(5, sp.getAddress().getId_address());
			statement.setString(6, sp.getStreet());
			result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_supplier = new GeneratedKey().getGeneratedKey(statement);
			sp.setId_supplier(id_supplier);
		} catch (SQLException sqle) {
			throw new SQLException("insertSupplier.DbSupplier.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertSupplier.DbSupplier.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int updateSupplier(Supplier sp) {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Supplier SET name=?, phoneNr=?, email=?, isActive=?, sp_address=?, street=? WHERE id_supplier=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, sp.getName());
			statement.setString(2, sp.getPhoneNr());
			statement.setString(3, sp.getEmail());
			statement.setBoolean(4, sp.isActive());
			statement.setInt(5, sp.getAddress().getId_address());
			statement.setString(6, sp.getStreet());
			statement.setInt(7, sp.getId_supplier());	
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateSupplier.DbSupplier.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("updateSupplier.DbSupplier.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Supplier";
		if(where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private Supplier buildSupplier(ResultSet resultSet) throws Exception {
		Supplier sp = null;
		try {
			sp = new Supplier(
					resultSet.getInt("id_supplier"),
					resultSet.getString("name"),
					new Address(resultSet.getInt("sp_address")),
					resultSet.getString("street"),
					resultSet.getString("phoneNr"),
					resultSet.getString("email"),
					resultSet.getBoolean("isActive"));
		} catch (Exception e) {
			throw new Exception("buildSupplier.DbSupplier.dbLayer", e);
		}
		return sp;
	}
	
	private Supplier singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Supplier> suppliers = miscWhere(where, retrieveAssoc);
		if(suppliers.size() > 0) {
			suppliers.get(0).setAddress(dbAddress.findSupplier(suppliers.get(0).getAddress().getId_address()));
		    return suppliers.get(0);
	} else {
		return null;
	}
  }

   private ArrayList<Supplier> miscWhere(String where, boolean retrieveAssoc) {
	  ResultSet resultSet;
	  ArrayList<Supplier> suppliers = new ArrayList<>();
	  String string = buildQuery(where);
	  try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
		statement.setQueryTimeout(5);
		resultSet = statement.executeQuery(string);
		while(resultSet.next()) {
			Supplier sp = buildSupplier(resultSet);
			if(retrieveAssoc) {
				//nothing
			}
			suppliers.add(sp);
		}
	  } catch (Exception e) {
		  throw new Exception("miscWhere.DbSupplier.dbLayer", e);
	  } 
	  return suppliers;
   }
}

