package modelLayer;

/**
 * Address
 * 
 * @author futz
 * @version 1.0
 */

public class Address {
	
	private String country;
	private String city;
	private String street;
	
	//constructor
	public Address(
			String country,
			String city,
			String street) {
		this.setCountry(country);
		this.setCity(city);
		this.setStreet(street);
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
	
	//street
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

}
