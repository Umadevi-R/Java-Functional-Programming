package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

	public static void main(String[] args) {
		
		Function<String,String> upperCaseName = String::toUpperCase;//name -> name.toUpperCase();
		
		BiFunction<String,Integer,String>upperCaseName1 = (name,age)->{
			if(name.isBlank())throw new IllegalArgumentException("Name needed");
			System.out.println(age);
			return name.toUpperCase();
		};
		
		System.out.println(upperCaseName1.apply("Uma", 20));
		
	}

}
