package controlLayer;

import java.util.ArrayList;

import modelLayer.SaleLine;
import modelLayer.Item;
import dbLayer.DbSaleLineInterface;
import dbLayer.DbSaleLine;
import dbLayer.DbConnection;

/**
 * CtrSaleLine
 * 
 * @author futz
 * @version 1.1
 */

public class CtrSaleLine {
	
	private DbSaleLineInterface dbSaleLine;
	private CtrItem ctrItem;
	
	//constructor
	public CtrSaleLine() {
		dbSaleLine = new DbSaleLine();
		ctrItem = new CtrItem();
	}
	
	public ArrayList<SaleLine> getAllSaleLinesForSale(int id_sale) throws Exception {
		ArrayList<SaleLine> saleLines = new ArrayList<>();
		saleLines = dbSaleLine.getAllSaleLinesForASale(id_sale);
		return saleLines;
	}
	
	public SaleLine findSaleLine(int id_saleLine) throws Exception {
		return dbSaleLine.findSaleLine(id_saleLine, true);
	}
	
	//the price is automatically retrieved based on barcode
	//returns 1 if successful
	//returns -17 if unable to get item
	//returns -19 if unable to get price
	//returns -20 if unable to insert saleLine
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertSaleLine(int quantity, String barcode, int id_sale) throws Exception {
		int success = 1;
		Item item = null;
		double price = -1;
		//get the item object
		try {
			item = ctrItem.findItemByBarcode(barcode);
		} catch (Exception e) {
			success = Errors.UNABLE_TO_GET_ITEM.getCode();
		}
		//get price
		try {
			price = item.getPrice();
		} catch (Exception e) {
			success = Errors.UNABLE_TO_GET_PRICE.getCode();
		}
		if(success == 1) {
			//it means the item object and the price have been successfully obtained
			SaleLine saleLine = new SaleLine(quantity, price, item);
			try {
				DbConnection.startTransaction();
				dbSaleLine.insertSaleLine(saleLine, id_sale);
				DbConnection.comitTransaction();
			} catch (Exception e) {
				try {
					DbConnection.rollbackTransaction();
				} catch (Exception r) {
					throw new Exception("insertSaleLine.CtrSaleLine.controlLayer");
				}
				success = Errors.INSERT_SALELINE.getCode();
			}
		}
		return success;
	}
	
	//returns a saleLine object if successful
	//returns null otherwise
	public SaleLine createSaleLine(int quantity, String barcode) {
		int success = 1;
		Item item = null;
		double price = -1;
		SaleLine saleLine = new SaleLine();
		saleLine.setQuantity(quantity);
		try {
			item = ctrItem.findItemByBarcode(barcode);
			saleLine.setItem(item);
		} catch (Exception e) {
			success = Errors.UNABLE_TO_GET_ITEM.getCode();
		}
		try {
			price = item.getPrice();
			saleLine.setPrice(item.getPrice());
		} catch (Exception e) {
			success = Errors.UNABLE_TO_GET_PRICE.getCode();
		}
		if(success == 1) {
			return saleLine;
		} else {
			return null;
		}
		
	}

}
