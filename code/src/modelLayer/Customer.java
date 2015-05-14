package modelLayer;

/**
 * Customer
 * 
 * @author Monika + futz
 * @version 1.1
 */

public class Customer {
	private String name;
	private String city;
	private String street;
	private String phoneNr;
	private String email;

	//constructor	
	public Customer (
			String name,
			String city,
			String street,
			String phoneNr,
			String email) {
		this.setName(name);
		this.setCity(city);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
	}
    
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	//phoneNr
	public String getPhoneNr() {
		return phoneNr;
	}
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
