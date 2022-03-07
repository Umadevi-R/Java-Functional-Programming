package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public interface CustomerRegistrationValidator
	extends Function<Customer,ValidationResult>{
	
	static CustomerRegistrationValidator isEmailValid() {
		return customer -> 
			customer.getEmail().contains("@")
			? ValidationResult.SUCCESS
			:ValidationResult.EMAIL_NOT_VALID;
	}
	
	static CustomerRegistrationValidator isPhNoValid() {
		return customer -> 
			customer.getPhNo().startsWith("+91")
			? ValidationResult.SUCCESS
			:ValidationResult.PHONE_NUMBER_NOT_VALID;
	}
	
	static CustomerRegistrationValidator isAdult() {
		return customer -> 
		Period.between(customer.getDob(), LocalDate.now()).getYears()>=18
			? ValidationResult.SUCCESS
			:ValidationResult.IS_NOT_AN_ADULT;
	}
	
	//Combinator pattern in action
	default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
		return cust ->{
			ValidationResult result = this.apply(cust);
			return result.equals(ValidationResult.SUCCESS)? other.apply(cust):result;
		};
	}
	
	enum ValidationResult{
		SUCCESS,
		PHONE_NUMBER_NOT_VALID,
		EMAIL_NOT_VALID,
		IS_NOT_AN_ADULT
	}
}
