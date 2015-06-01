package guiLayer;



import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Customer;

public class TestForWrapper {
	public static void main(String[] args) {
	
		
/*	class Customer
	{ public String namee=null;

		public Customer(String name, Address address,  String baba, String babat, String email ) {
	namee=name;
		}
		public String getName()
		{
			return namee;
		}
	}
	*/
	
	
	ArrayList<GuiCustomerWrapper<Customer>> gcw=new ArrayList<>();
	Customer customer = new Customer("Ana", new Address("ro", "baia mare"), "50", "280895", "f@me.ro");
	gcw.add(new GuiCustomerWrapper<Customer>(customer, customer::getName));
	System.out.println(gcw.get(0).toString());
	}
	}
	
	


