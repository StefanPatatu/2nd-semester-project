package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.SaleLine;
import modelLayer.Item;

/**
 * DbSaleLine
 * 
 * @author DarkSun + futz
 * @version 1.1
 */

public class DbSaleLine implements DbSaleLineInterface {
	
	private DbItemInterface dbItem = new DbItem();

	@Override
	public ArrayList<SaleLine> getAllSaleLinesForASale(int id_sale) throws Exception {
		return miscWhere("id_s=" + id_sale, false);
	}

	@Override
	public SaleLine findSaleLine(int id_saleLine) throws Exception {
		SaleLine sl = singleWhere("id_saleLine=" + id_saleLine, true);
		return sl;
	}

	@Override
	public int insertSaleLine(SaleLine sl, int id_sale) throws Exception {
		int result = 0;
		String string = "INSERT INTO" + authLayer.DbConfig.DBTablePrefix + "SaleLine (quantity, price, id_i, id_s) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setInt(1, sl.getQuantity());
			statement.setDouble(2, sl.getPrice());
			statement.setInt(3, sl.getItem().getId_item());
			statement.setInt(4, id_sale);
			result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_saleLine = new GeneratedKey().getGeneratedKey(statement);
			sl.setId_saleLine(id_saleLine);
		} catch (SQLException sqle) {
			throw new SQLException ("insertSaleLine.DBSaleLine.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertSaleLine.DBSaleLine.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "SELECT * FROM " + authLayer.DbConfig.DBTablePrefix + "SaleLine";
		if (where != null && where.length() > 0) {
			string += " WHERE " + where;
		}
		return string;
	}
	
	private SaleLine buildSaleLine(ResultSet resultSet) throws Exception {
		SaleLine sl = null;
		try {
			sl = new SaleLine(
					resultSet.getInt("id_saleLine"),
					resultSet.getInt("quantity"),
					resultSet.getDouble("price"),
					new Item(resultSet.getInt("id_item")));
		} catch (Exception e) {
			throw new Exception("buildSaleLine.DbSaleLine.dbLayer");
		}
		return sl;
	}
	
	private SaleLine singleWhere(String where, boolean retrieveAssoc) throws Exception {
		ArrayList<SaleLine> saleLines = miscWhere(where, retrieveAssoc);
		if(saleLines.size() > 0) {
			if (retrieveAssoc) {
				saleLines.get(0).setItem(dbItem.findItemById_Item(saleLines.get(0).getItem().getId_item()));
			}
			return saleLines.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<SaleLine> miscWhere(String where, boolean retrieveAssoc) throws Exception {
		ResultSet resultSet;
		ArrayList<SaleLine> saleLines = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while (resultSet.next()) {
				SaleLine sl = buildSaleLine(resultSet);
				if(retrieveAssoc) {
					//nothing
				}
				saleLines.add(sl);
			}
		} catch (Exception e) {
			throw new Exception("miscWhere.DbSaleLine.dbLayer", e);
		}
		return saleLines;
	}

}
