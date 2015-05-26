package dbLayer;

import java.util.ArrayList;

import modelLayer.Address;

/**
 * DbAddressInterface
 * 
 * @author futz
 * @version 1.2
 */

public interface DbAddressInterface {
	
	public ArrayList<Address> getAllAddresses() throws Exception;
	public Address findAddress(int id_address) throws Exception;
	public ArrayList<Address> searchAddressByCountry(String country) throws Exception;
	public ArrayList<Address> searchAddressByCity(String city) throws Exception;
	public int insertAddress(Address a) throws Exception;
	public int updateAddress(Address a) throws Exception;
	public int removeAddress(Address a) throws Exception;

}
