package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		
		greetCustomer(new Customer("Uma","12345"));

		greetCustomerConsumer.accept(new Customer("Uma","12345"));
		
		greetCustomerConsumerV2.accept(new Customer("Uma","12345"),false);
	}
	
	//Consumer
	static Consumer<Customer> greetCustomerConsumer = cus ->
		System.out.println("Hello "+cus.cusName +" , "+cus.cusNum);
	
	//Consumer
	static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 = (cus,showNum) ->
		System.out.println("Hello "+cus.cusName +" , "
				+(showNum?cus.cusNum:""));
		
	//Normal Way
	static void greetCustomer(Customer cus) {
		System.out.println("Hello "+cus.cusName +" , "+cus.cusNum);
	}
	
	static class Customer {
		private final String cusName;
		private final String cusNum;
		public Customer(String cusName, String cusNum) {
			super();
			this.cusName = cusName;
			this.cusNum = cusNum;
		}
		
	}
}
