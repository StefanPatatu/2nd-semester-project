package dbLayer;

import java.util.ArrayList;

import modelLayer.Supplier;

/**
 * 
 * @author Kool-kat
 * @Version 1.0
 */

public interface DbSupplierInterface {
	
	public ArrayList<Supplier> getAllSuppliers();
	public Supplier findSupplier(int id_supplier);
	public ArrayList<Supplier> searchSupplierByName(String name);
	public int insertSupplier(Supplier sp);
	public int updateSupplier(Supplier sp);

}
