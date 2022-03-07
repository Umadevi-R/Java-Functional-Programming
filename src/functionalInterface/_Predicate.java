package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {
		
		System.out.println(isNumValidPredicate.test("07000000000"));
		
		System.out.println(isNumValidPredicate.and(containsNumber3).test("07000000003"));
		
		System.out.println(isNumValidPredicate.or(containsNumber3).test("07000000000"));
		
	}

	static Predicate<String> isNumValidPredicate =
			num -> num.startsWith("07") && num.length()==11;
			
	static Predicate<String> containsNumber3 = num->
		num.contains("3");
}
