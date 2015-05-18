package dbLayer;

import java.util.ArrayList;

import modelLayer.Address;

/**
 * DbAddressInterface
 * 
 * @author futz
 * @version 1.0
 */

public interface DbAddressInterface {
	
	public ArrayList<Address> getAllAddresses();
	public Address findAddress(int id_address);
	public ArrayList<Address> searchAddressByCountry(String country);
	public ArrayList<Address> searchAddressByCity(String city);
	public int insertAddress(Address a);
	public int updateAddress(Address a);
	public int removeAddress(Address a);

}
