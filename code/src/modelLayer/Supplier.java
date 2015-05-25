package modelLayer;

/**
 * 
 * @author Kool-kat
 * @version 1.0
 *
 */

public class Supplier {
	
	private int id_supplier;
	private String name;
	private Address address;
	private String street;
	private String phoneNr;
	private String email;
	private boolean isActive;
	
	//constructor
	public Supplier (
			int id_supplier,
			String name,
			Address address,
			String street,
			String phoneNr,
			String email,
			boolean isActive) {
		this.setId_supplier(id_supplier);
		this.setName(name);
		this.setAddress(address);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
		this.setActive(isActive);
		
	}

	//id_supplier
	public int getId_supplier() {
		return id_supplier;
	}
	public void setId_supplier(int id_supplier) {
		this.id_supplier = id_supplier;
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
	
	//active
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
