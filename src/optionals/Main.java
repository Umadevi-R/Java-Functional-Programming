package optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Object val = Optional.ofNullable(null)
				.orElseGet(()-> "default value");
		System.out.println(val);

		Object val1 = Optional.ofNullable("Hello")
				.orElseGet(()-> "default value");
		System.out.println(val1);
		
		Optional.ofNullable(null)
		.ifPresentOrElse(email -> System.out.println("Sending email to"+email), 
				()->{System.out.println("Cannot send email!");}
				);
	}

}
