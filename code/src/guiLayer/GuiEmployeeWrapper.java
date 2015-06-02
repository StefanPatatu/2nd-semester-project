package guiLayer;
import java.util.function.Supplier;



public class GuiEmployeeWrapper <Employee> {
	private Employee object;
	
	
	private Supplier<String> f;
	
	
	public GuiEmployeeWrapper(Employee o, Supplier<String> f) {
		object = o;
		this.f = f; 
	}
	
	@Override
	public String toString() {
		
		return f.get(); 
	} 
	
	public Employee getObject() {
		return object;
	}
	
}
