package modelLayer;

/**
 * Customer
 * 
 * @author Monika
 * @version 1.0
 */

public class Customer {
	private String name;
	private String city;
	private String street;
	private String phoneNr;
	private String email;
	private int discount;

	//constructor	
	public Customer (
			String name,
			String city,
			String street,
			String phoneNr,
			String email,
			int discount)	{
		this.setName(name);
		this.setCity(city);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
		this.setDiscount(discount);;
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
	
	//discount
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}	

}
