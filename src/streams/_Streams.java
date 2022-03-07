package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class _Streams {

	public static void main(String[] args) {

		List<Person> people = List.of(
				new Person("Joe",Gender.FEMALE),
				new Person("Jim",Gender.MALE)
				);
		
		people.stream()
			.map(person -> person.gender)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		people.stream()
		.map(person -> person.name)
		.mapToInt(String::length)
		.forEach(System.out::println);
		
		Predicate<Person> female  = person -> Gender.FEMALE.equals(person.gender);
		boolean allFemales = people.stream()
				.allMatch(female);
		System.out.println(allFemales);
		
		boolean anyFemales = people.stream()
				.anyMatch(female);
		System.out.println(anyFemales);
		
		boolean noneMatchPeople = people.stream()
				.noneMatch(person -> Gender.PREFER_NOT_TO_SAY.equals(person.gender));
		System.out.println(noneMatchPeople);
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
		MALE,FEMALE,PREFER_NOT_TO_SAY;
	}
}
