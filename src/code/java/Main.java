package code.java;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("Joe",Gender.FEMALE),
				new Person("Jim",Gender.MALE)
				);
		//Imperative Approach
		List<Person> female = new ArrayList();
		for(Person p : people) {
			if(Gender.FEMALE==p.gender) {
				female.add(p);
			}
		}
		for(Person p : female) {
			System.out.println(p);
		}
		
		//Declarative Approach
		people.stream()
		.filter(person -> Gender.FEMALE.equals(person.gender))
		.forEach(System.out::println);
		
		//OR
		List<Person> femaleList=people.stream()
				.filter(person -> Gender.FEMALE.equals(person.gender))
				.collect(Collectors.toList());
		femaleList.forEach(System.out::println);
		
		//Predicates
		Predicate<Person> pred = person -> Gender.FEMALE.equals(person.gender);
		List<Person> femaleLists=people.stream()
				.filter(pred)
				.collect(Collectors.toList());
		femaleLists.forEach(System.out::println);
	}
	static class Person{
		private final String name;
		private final Gender gender;
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
		
	}
	enum Gender{
		MALE,FEMALE;
	}
}
