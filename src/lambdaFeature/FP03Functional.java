package lambdaFeature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FP03Functional {

	public static void main(String[] args) {
		
		/*
		there are 2 types of operations in streams
		1) intemediate operations - the methods that returns stream in return is called intermediate operation
				eg(distinct, sorted, map, filter)
		2) terminal operations - the method that dose not stream is called terminal operation
				eg(forEach, collect, reduce)
		*/
		
		printAllNumbersInListFunctional(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		List<String> courses = 
				Arrays.asList("AWS","Microservices","Java Persistence","GCP","Kubernetes","Ansible","AWS","GCP");
		
		courses.stream().distinct().sorted().forEach(System.out::println);
		
		System.out.println("###################");
		
		courses.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		System.out.println("###################");
		
		courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("###################");
		
		courses.stream().distinct().sorted(Comparator.comparing(x -> x.length())).forEach(System.out::println);
	}
	
	public static int addAllNumbersInList(int a, int b) {
		return a + b;
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {

		System.out.println(numbers.stream().reduce(0, FP03Functional::addAllNumbersInList));
		
		/*
		 * now that the addAllnumbersInList is a static method also we can replicate it
		 * in lambda expression
		 */
		
		System.out.println(numbers.stream().reduce(0, (x,y) -> x+y));
		
		System.out.println(numbers.stream().reduce(0, Integer::sum));
	}
}
