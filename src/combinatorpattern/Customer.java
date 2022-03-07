package combinatorpattern;

import java.time.LocalDate;

public class Customer {
	private final String name;
	private final String email;
	private final String phNo;
	private final LocalDate dob;
	
	public Customer(String name, String email, String phNo, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.phNo = phNo;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhNo() {
		return phNo;
	}

	public LocalDate getDob() {
		return dob;
	}
	
	
	
}
