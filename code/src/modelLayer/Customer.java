package modelLayer;

/**
 * Customer
 * 
 * @author DarkSun + futz
 * @version 1.5
 */

public class Customer {
	
	private int id_customer;
	private String name;
	private Address address;
	private String street;
	private String phoneNr;
	private String email;

	//constructor full
	public Customer(
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
	
	//constructor no id
	public Customer(
			String name,
			Address address,
			String street,
			String phoneNr,
			String email) {
		this.setId_customer(-1);
		this.setName(name);
		this.setAddress(address);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
	}
    
	//constructor just id
	public Customer(
			int id_customer) {
		this.setId_customer(id_customer);
		this.setName(null);
		this.setAddress(null);
		this.setStreet(null);
		this.setPhoneNr(null);
		this.setEmail(null);
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
