package callbackslikejs;

import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
		hello("Uma",null,val ->{
			System.out.println("Last Name Not provided for "+val);
		});
		
		hello2("Uma",null,() ->
			System.out.println("Last Name Not provided "));

	}
	
	static void hello(String fName,String lName,Consumer<String>callback) {
		System.out.println(fName);
		if(lName != null) {
			System.out.println(lName);
		} else {
			callback.accept(fName);
		}
	}
	
	static void hello2(String fName,String lName,Runnable callback) {
		System.out.println(fName);
		if(lName != null) {
			System.out.println(lName);
		} else {
			callback.run();
		}
	}

}
