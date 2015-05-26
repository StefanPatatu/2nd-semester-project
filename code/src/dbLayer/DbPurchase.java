package dbLayer;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.DbConnection;
import modelLayer.Purchase;
import modelLayer.Sale;
import modelLayer.Employee;
import modelLayer.Customer;
import modelLayer.SaleLine;
import authLayer.DbConfig;

/**
 * DBPurchase
 * 
 * @author frunziss + futz
 * @version 1.0
 */

public class DbPurchase implements DbPurchaseInterface {

	@Override
	public ArrayList<Purchase> getAllPurchases() {
		return miscWhere("", false);
	}

	@Override
	public Purchase findPurchaseById_purchase(int id_purchase) {
		Purchase p = singleWhere("id_purchase=" + id_purchase, true);
		return p;
	}

	@Override
	public ArrayList<Purchase> findPurchasesByDateCreated(Timestamp dateCreated) {
		return miscWhere("dateCreated LIKE '%" + dateCreated, false);
	}


	@Override
	public ArrayList<Purchase> findPurchasesByDateDelivered(Timestamp dateDelivered) {
		return miscWhere("dateDelivered LIKE '%" + dateDelivered, false);
	}

	@Override
	public int insertPurchase(Purchase p) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.getDBTablePrefix() + "Purchase (dateOrdered, dateDelivered, id_sp) VALUES (?, ?, ?)";
	    try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
	    	statement.setTimestamp(1, p.getDateOrdered());
	    	statement.setTimestamp(2, p.getDateDelivered());
	    	statement.setint(3, p.getSupplier().getId_supplier);
	    	result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_purchase = new GeneratedKey().getGeneratedKey(statement);
			p.setId_purchase(id_purchase);
		} catch (SQLException sqle) {
			throw new SQLException("insertPurchase.DbPurchase.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertPurchase.DbPurchase.dbLayer", e); 
		}
		return result;
	}

	@Override
	public int updatePurchase(Purchase p) {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.getTablePrefix() + "Purchase SET dateOrdered=?, dateDelivered=?, id_sp=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon.prepareStatement()) {
			statement.setTimestamp(1, p.getDateOrdered());
			statement.setTimestamp(2, p.getDateDelivered());
			statement.setInt(3, p.getSupplier.getId_supplier);
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updatePurchase.DbPurchase.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updatePurchase.DbPurchase.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.getTablePrefix() + "Purchase";
		if (where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private Purchase buildPurchase(ResultSet resultSet) throws Exception {
		Purchase p = null;
		try {
			p = new Purchase(
					resultSet.getInt("id_Purchase"),
					resultSet.getTimestamp("dateOrdered"),
					resultSet.getBoolean("dateDelivered"),
					resultSet.getTimestamp("datePacked"),
					new Supplier(resultSet.getInt("id_supplier");								
		} catch (Exception e) {
			throw new Exception ("buildPurchase.DbPurchase.dblayer");
		}
		return p;
	}
	
	private Purchase singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Purchase> purchases = miscWhere(where, retrieveAssoc);
		if (purchases.size() > 0) {
			if(retrieveAssoc) {
				//soon
			}
			return purchases.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Purchase> miscWhere(String where, boolean retrieveAssoc) { 
		ResultSet resultSet;
		ArrayList<Purchase> purchases = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Purchase p = buildPurchase(resultSet);
				if (retrieveAssoc) {
					//nothing
				}
				purchases.add(p);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbPurchase.dbLayer", e);
		}
		return purchases;		
	}

}
