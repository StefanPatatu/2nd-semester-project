package controlLayer;

/**
 * Errors
 * 
 * @author futz
 * @version 2.5
 */

public enum Errors {
	
	INSERT_ADDRESS(-1, "Insert operation failed. Rolling back."),
	UPDATE_ADDRESS(-2, "Update operation failed. Rolling back."),
	REMOVE_ADDRESS(-3, "Remove operation failed. Rolling back."),
	
	INSERT_CUSTOMER(-4, "Insert operation failed. Rolling back."),
	UPDATE_CUSTOMER(-5, "Update operation failed. Rolling back."),
	REMOVE_CUSTOMER(-6, "Remove operation failed. Rolling back."),
	GET_DISCOUNT(-21, "Error while trying to calculate the discount."),
	GET_DISCOUNT_LOOP(-25, "Error while trying to calculate the discount."),
	GET_ALL_SALES_C(-22, "Unable to retrieve the sales from the database."),
	
	INSERT_EMPLOYEE(-7, "Insert operation failed. Rolling back."),
	UPDATE_EMPLOYEE(-8, "Update operation failed. Rolling back."),
	REMOVE_EMPLOYEE(-9, "Remove operation failed. Rolling back."),
	UNAUTHENTICATED_USER(-10, "User not authenticated. Please log in."),
	AUTHENTICATE_FAILED(-11, "Authentication operation failed. Please try again"),
	
	BARCODE_EXISTS(-12, "An item with this barcode already exists."),
	NAME_EXISTS(-13, "An item with this exact same name already exists."),
	CONFLICT_CHECK(-14, "An error occured while trying to check for conflcits."),
	INSERT_ITEM(-15, "Insert operation failed. Rolling back."),
	UPDATE_ITEM(-16, "Update operation failed. Rolling back."),
	
	UNABLE_TO_GET_ITEM(-17, "An error occured while trying to get the item object."),
	UNABLE_TO_GET_ID(-18, "An error occured while trying to get the item id."),
	UNABLE_TO_GET_PRICE(-19, "An error occured while trying to get the price."),
	INSERT_SALELINE(-20, "Insert operation failed. Rolling back."),
	
	SALE_TOTAL_PRICE(-24, "Error while trying to calculate the sale's total"),
	GET_ALL_SALELINES_FOR_SALE(-23, "Unable to retrieve the sale lines from the database."),
	
	
	;
	
	private final int code;
	private final String description;
	
	private Errors(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return code + ": " + description;
	}

}
