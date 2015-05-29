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
 * @version 1.0
 */

public class CtrAddress {
	
	private DbAddressInterface dbAddress;
	
	//constructor
	public CtrAddress() {
		dbAddress = new DbAddress();
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
	
	//returns 1 if successful
	//returns -1 if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertAddress(String country, String city) throws Exception{
		int success = 1;
		Address address = new Address(country, city);
		try {
			DbConnection.startTransaction();
			dbAddress.insertAddress(address);
			DbConnection.comitTransaction();
		} catch(Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("insertAddress.CtrAddress.controlLayer", r);
			}
			success = -1;
		}
		return success;
	}
	
	//returns 1 if successful
	//returns -1 if unsuccessful
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
			success = -1;
		}
		return success;
	}
	
	//returns 1 if successful
	//returns -1 if unsuccessful
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
			success = -1;
		}
		return success;
	}
}
