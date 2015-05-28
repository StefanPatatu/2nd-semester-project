package dbLayer;

import java.sql.ResultSet;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.DbConnection;
import modelLayer.Purchase;
import modelLayer.PurchaseLine;
import modelLayer.Sale;
import modelLayer.Item;
import modelLayer.Employee;
import modelLayer.Customer;
import modelLayer.SaleLine;
import authLayer.DbConfig;

/**
 * DBPurchase
 * 
 * @author frunziss
 * @version 1.0 !
 */

public class DbPurchaseLine implements DbPurchaseLineInterface {

	@Override
	public ArrayList<PurchaseLine> getAllPurchaseLines() {
		return miscWhere("", false);
	}

	@Override
	public PurchaseLine findPurchaseLine(int id_purchaseLine) {
		PurchaseLine pl = singleWhere("id_purchaseLine=" + id_purchaseLine, true);
		return pl;
	}

	@Override
	public int insertPurchaseLine(PurchaseLine pl) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.getDBTablePrefix() + "PurchaseLine (quantity, price, id_p, id_i) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
	    	statement.setInt(1, pl.getQuantity());
	    	statement.setDouble(2, pl.getPrice());
	    	statement.setint(3, pl.getPurchase().getId_purchase());
	    	statement.setint(4, pl.getItem().getId_item());
	    	result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_purchaseLine = new GeneratedKey().getGeneratedKey(statement);
			pl.setId_purchaseLine(id_purchaseLine);
		} catch (SQLException sqle) {
			throw new SQLException("insertPurchaseLine.DbPurchaseLine.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertPurchaseLine.DbPurchaseLine.dbLayer", e); 
		}
		return result;
	}

	
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.getTablePrefix() + "PurchaseLine";
		if (where != null && where.length() > 0) {
			string += " WHERE" + where;
		}
		return string;
	}
	
	private PurchaseLine buildPurchaseLine(ResultSet resultSet) throws Exception {
		PurchaseLine pl = null;
		try {
			pl = new PurchaseLine(
					resultSet.getInt("id_PurchaseLine"),
					resultSet.getInt("quantity"),
					resultSet.getDouble("price"),
					new Purchase(resultSet.getInt("id_purchase")),
					new Item(resultSet.getInt("id_item")));
		} catch (Exception e) {
			throw new Exception ("buildPurchaseLine.DbPurchaseLine.dblayer");
		}
		return pl;
	}
	
	private PurchaseLine singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<PurchaseLine> purchaseLines = miscWhere(where, retrieveAssoc);
		if (purchaseLines.size() > 0) {
			if(retrieveAssoc) {
				//soon
			}
			return purchaseLines.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<PurchaseLine> miscWhere(String where, boolean retrieveAssoc) { 
		ResultSet resultSet;
		ArrayList<PurchaseLine> purchaseLines = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				PurchaseLine pl = buildPurchaseLine(resultSet);
				if (retrieveAssoc) {
					//nothing
				}
				purchaseLines.add(pl);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbPurchaseLine.dbLayer", e);
		}
		return purchaseLines;		
	}

}
