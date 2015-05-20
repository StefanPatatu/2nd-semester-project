package modelLayer;

/**
 * Address
 * 
 * @author futz
 * @version 1.2
 */

public class Address {
	
	private int id_address;
	private String country;
	private String city;
	
	//constructor
	public Address(
			int id_address,
			String country,
			String city) {
		this.setId_address(id_address);
		this.setCountry(country);
		this.setCity(city);
	}
	
	//constructor
	public Address(
			int id_address) {
		this.setId_address(id_address);
		this.setCity(null);
		this.setCountry(null);
	}
	
	//id_address
	public int getId_address() {
		return id_address;
	}
	public void setId_address(int id_address) {
		this.id_address = id_address;
	}

	//country
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	//city
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
