package modelLayer;

/**
 * Customer
 * 
 * @author Monika + futz
 * @version 1.2
 */

public class Customer {
	
	private String name;
	private Address address;
	private String phoneNr;
	private String email;

	//constructor	
	public Customer (
			String name,
			Address address,
			String phoneNr,
			String email) {
		this.setName(name);
		this.setAddress(address);
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
	
    //address
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
