package controlLayer;

import java.util.ArrayList;

import modelLayer.Address;
import dbLayer.DbAddressInterface;
import dbLayer.DbAddress;
import dbLayer.DbConnection;

/**
 * CtrAddress
 * 
 * @author futz
 * @version 1.1
 */

public class CtrAddress {
	
	private DbAddressInterface dbAddress;
	
	//constructor
	public CtrAddress() {
		dbAddress = new DbAddress();
	}
	
	//creates a new address using the country and city provided,
	//inserts it into the database and returns the address object,
	//In case the address already exists, it is just returned.
	public Address createNewAddress(String country, String city) throws Exception {
		if(insertAddress(country, city) == 1) {
			return findAddressbyCountryAndCity(country, city);
		} else {
			throw new Exception("createNewAddress.CtrAddress.controlLayer");
		}
	}
	
	public ArrayList<Address> getAllAddresses() throws Exception {
		ArrayList<Address> addresses = new ArrayList<>();
		addresses = dbAddress.getAllAddresses();
		return addresses;
	}
	
	public Address findAddress(int id_address) throws Exception {
		return dbAddress.findAddress(id_address);
	}
	
	public ArrayList<Address> searchAddressByCountry(String country) throws Exception {
		return dbAddress.searchAddressByCountry(country);
	}
	
	public ArrayList<Address> searchAddressByCity(String city) throws Exception {
		return dbAddress.searchAddressByCity(city);
	}
	
	public Address findAddressbyCountryAndCity(String country, String city) throws Exception {
		return dbAddress.findAddressByCountryAndCity(country, city);
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertAddress(String country, String city) throws Exception {
		int success = 1;
		if(findAddressbyCountryAndCity(country, city) == null) {
			Address address = new Address(country, city);
			try {
				DbConnection.startTransaction();
				dbAddress.insertAddress(address);
				DbConnection.comitTransaction();
			} catch (Exception e) {
				try {
					DbConnection.rollbackTransaction();
				} catch (Exception r) {
					throw new Exception("insertAddress.CtrAddress.controlLayer", r);
				}
				success = Errors.INSERT_ADDRESS.getCode();
			}
		}
		return success;
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateAddress(int id_address, String country, String city) throws Exception {
		int success = 1;
		Address address = new Address(id_address, country, city);
		try {
			DbConnection.startTransaction();
			dbAddress.updateAddress(address);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("updateAddress.CtrAddress.controlLayer", r);
			}
			success = Errors.UPDATE_ADDRESS.getCode();
		}
		return success;
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int removeAddress(int id_address) throws Exception {
		int success = 1;
		Address address = new Address(id_address);
		try {
			DbConnection.startTransaction();
			dbAddress.removeAddress(address);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("removeAddress.CtrAddress.controlLayer", r);
			}
			success = Errors.REMOVE_ADDRESS.getCode();
		}
		return success;
	}
	
}
