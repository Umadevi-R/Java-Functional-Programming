package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
		int increment=increment(1);
		System.out.println(increment);
		
		//Function 
		Function<Integer,Integer>incrementByOneFunction = 
				number -> number+1;
				
		//using apply method
		int increment2=incrementByOneFunction.apply(1);
		System.out.println(increment2);
		
		//using andThen
		Function<Integer,Integer> addBy1ThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
		System.out.println(addBy1ThenMultiplyBy10.apply(1));
		
		//using Bifunction
		System.out.println(incAndMul.apply(4,10));
		
	}
	//Function
	static Function<Integer,Integer> multiplyBy10Function = 
			number -> number*10;
			
	//BiFunction
	static BiFunction<Integer,Integer,Integer> incAndMul = (num,mul) -> (num+1)*mul;
	
			
	//Normal Function
	static int increment(int num) {
		return num+1;
	}
}
