package controlLayer;

public enum Errors {
	
	INSERT_ADDRESS(-1, "Insert operation failed. Rolling back."),
	UPDATE_ADDRESS(-2, "Update operation failed. Rolling back."),
	REMOVE_ADDRESS(-3, "Remove operation failed. Rolling back."),
	
	INSERT_CUSTOMER(-4, "Insert operation failed. Rolling back."),
	UPDATE_CUSTOMER(-5, "Update operation failed. Rolling back."),
	REMOVE_CUSTOMER(-6, "Remove operation failed. Rolling back."),
	
	INSERT_EMPLOYEE(-7, "Insert operation failed. Rolling back."),
	UPDATE_EMPLOYEE(-8, "Update operation failed. Rolling back."),
	REMOVE_EMPLOYEE(-9, "Remove operation failed. Rolling back."),
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
