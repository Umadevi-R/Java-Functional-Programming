package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
	
	public boolean isEmailvalid(String email) {
		return email.contains("@");
	}
	
	public boolean isPhnoValid(String phNo) {
		return phNo.startsWith("+91");
	}
	
	public boolean isAdult(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears()>=18;
	}
	
	public boolean isValid(Customer cus) {
		return isEmailvalid(cus.getEmail()) &&
				isPhnoValid(cus.getPhNo())&&
				isAdult(cus.getDob());
	}
}
