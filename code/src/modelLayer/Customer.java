package modelLayer;

/**
 * Customer
 * 
 * @author Monika + futz
 * @version 1.4
 */

public class Customer {
	
	private int id_customer;
	private String name;
	private Address address;
	private String street;
	private String phoneNr;
	private String email;

	//constructor	
	public Customer (
			int id_customer,
			String name,
			Address address,
			String street,
			String phoneNr,
			String email) {
		this.setId_customer(id_customer);
		this.setName(name);
		this.setAddress(address);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
	}
    
	//id_customer
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
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
