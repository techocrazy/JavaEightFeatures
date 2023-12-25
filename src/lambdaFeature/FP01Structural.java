package lambdaFeature;

import java.util.Arrays;
import java.util.List;

public class FP01Structural {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		System.out.println("**************even number print**********");
		
		numbers.stream().filter(x -> x%2 == 0).forEach(System.out::print);
		
		System.out.println("**************odd number print***********");
		
		numbers.stream().filter(x -> x%2 != 0).forEach(System.out::print);
		
		List<String> courses = Arrays.asList("Spring","Spring-boot","Microservices","Hibernate","JPA");
		
		System.out.println("*************courses filter*************");
		
		courses.stream()
					.filter(x -> x.contains("Spring"))
					.forEach(System.out::println);
		
		courses.stream()
					.filter(x -> x.length() < 7)
					.forEach(System.out::println);
		
		System.out.println("***********length of each string*********");
		
		courses.stream().map(x -> x +" : "+ x.length()).forEach(System.out::println);;
		
		System.out.println("***********square of each number**********");
		
		numbers.stream().map(x -> x*x).forEach(System.out::println);
		
		
//		printAllNumbersInListStructure(numbers);
		
	}

	private static void printAllNumbersInListStructure(List<Integer> numbers) {

		for(int number :numbers)
		{
			System.out.println(number);
		}
		
	}

}
