package guiLayer;
import java.util.function.Supplier;


//public class Wrapper <T extends NameableIF>{
public class GuiItemWrapperGood <Item> {
	private Item object;
	
	// An instance variable of type java.util.function.Supplier<String>
	// The type parameter is String, as it is supposed to replace the +Nameable.getName():String method. 
	private Supplier<String> f;
	
	// Not, the constructor has an additional parameter: A functional interface that can return a String value that we can use to fill in a combobox!
	public GuiItemWrapperGood(Item o, Supplier<String> f) {
		object = o;
		this.f = f; //let's save the function reference for posterity!
	}
	
	@Override
	public String toString() {
		//return object.getName();
		
		// But what happens here?
		// We trust that the Supplier<String> reference contains a valid function that we can use to fill in a combobox! W
		// We therefore call +Supplier.get(): String
		return f.get(); 
	} 
	
	public Item getObject() {
		return object;
	}
	
}
