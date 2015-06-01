package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Item;

/**
 * DbItem
 * 
 * @author Kool-kat + futz
 * @version 1.2
 */

public class DbItem implements DbItemInterface {
	
	@Override
	public ArrayList<Item> getAllItems() throws Exception {
		return miscWhere("", false);
	}
	
	@Override
	public Item findItemById_Item(int id_item) throws Exception {
		Item i = singleWhere("id_item='" + id_item + "'", false);
		return i;
	}
	
	@Override
	public Item findItemByBarcode(String barcode) throws Exception {
		Item i = singleWhere("barcode='" + barcode + "'", false);
		return i;
	}
	
	@Override
	public ArrayList<Item> searchItemByName(String name) throws Exception {
		return miscWhere("name LIKE '%" + name + "%'", false);
	}
	
	@Override
	public ArrayList<Item> searchItemsByStockRange(int min, int max) throws Exception {
		ResultSet resultSet;
		ArrayList<Item> items = new ArrayList<>();
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "Item WHERE stock BETWEEN ? AND ?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setInt(1, min);
			statement.setInt(2, max);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Item i = buildItem(resultSet);
				items.add(i);
			}		
		} catch (SQLException sqle) {
			throw new SQLException("searchItemByStockRange.DbItem.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("searchItemByStockRange.DbItem.dbLayer", e);
		}
		return items;
	}
	
	@Override
	public int insertItem(Item i) throws Exception {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.DBTablePrefix + "Item (barcode, name, price, stock, itemType, category) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, i.getBarcode());
			statement.setString(2, i.getName());
			statement.setDouble(3, i.getPrice());
			statement.setInt(4, i.getStock());
			statement.setString(5, i.getItemType());
			statement.setString(6, i.getCategory());
			result = statement.executeUpdate();
			int id_item = new GeneratedKey().getGeneratedKey(statement);
			i.setId_item(id_item);
		} catch (SQLException sqle) {
			throw new SQLException("insertItem.DbEmployee.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertItem.DbEmployee.dbLayer", e);
		}
		return result;
	}
	
	@Override
	public int updateItem(Item i) throws Exception {
		int result = 0;
		String string  = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Item SET barcode=?, name=?, price=?, stock=?, itemType=?, category=? WHERE id_item=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, i.getBarcode());
			statement.setString(2, i.getName());
			statement.setDouble(3, i.getPrice());
			statement.setInt(4, i.getStock());
			statement.setString(5, i.getItemType());
			statement.setString(6, i.getCategory());
			statement.setInt(7, i.getId_item());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateItem.DbItem.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updateItem.DbItem.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.DBTablePrefix + "Item";
		if (where != null && where.length() > 0) {
			string += " WHERE " + where;
		}
		return string;
		
	}
	
	private Item buildItem(ResultSet resultSet) throws Exception {
		Item i = null;
		try {
			i = new Item(
					resultSet.getInt("id_item"),
					resultSet.getString("barcode"),
					resultSet.getString("name"),
					resultSet.getDouble("price"),
					resultSet.getInt("stock"),
					resultSet.getString("itemType"),
					resultSet.getString("category"));
		} catch (Exception e) {
			throw new Exception("buildItem.DbItem.dbLayer");
		}
		return i;
	}
	
	private Item singleWhere(String where, boolean retrieveAssoc) throws Exception {
		ArrayList<Item> items = miscWhere(where, retrieveAssoc);
		if(items.size() > 0) {
			return items.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Item> miscWhere(String where, boolean retrieveAssoc) throws Exception {
		ResultSet resultSet;
		ArrayList<Item> items = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Item i = buildItem(resultSet);
				if(retrieveAssoc) {
					//nothing
				}
				items.add(i);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbItem.dbLayer", e);
		}
		return items;
	}

}
