package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public class Main {

	public static void main(String[] args) {
		
		Customer cust = new Customer(
				"Alice",
				"alice@gmail.com",
				"+918080234512",
				LocalDate.of(2022, 8, 12)
			);
		//Normal Way
		CustomerValidatorService serv = new CustomerValidatorService();
		System.out.println(serv.isValid(cust));
		
		//Using combinator pattern
		ValidationResult res = CustomerRegistrationValidator
			.isEmailValid()
			.and(CustomerRegistrationValidator.isPhNoValid())
			.and(CustomerRegistrationValidator.isAdult())
			.apply(cust);
		System.out.println(res);
		
		if(res != ValidationResult.SUCCESS) {
			throw new IllegalStateException(res.name());
		}
	}

}
