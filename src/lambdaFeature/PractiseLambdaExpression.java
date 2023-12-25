package lambdaFeature;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PractiseLambdaExpression {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5,8,2,4,12,11,51,16,3);
		
		Function<Integer, Integer> squaredFunction = i -> i*i;
		
		Function<Integer, Integer> cubeFunction = i -> i*i*i;
		
		System.out.println("cubeFunction test : " + cubeFunction.apply(2));
		
		System.out.println("########## Squared Function ############");
		
		computeTheCollectionList(numbers, squaredFunction).forEach(System.out::println);
		
		System.out.println("########## Cubed Function ############");
		
		computeTheCollectionList(numbers, cubeFunction).forEach(System.out::println);
		
		
		BinaryOperator<Integer> sumFunction = (x,y) -> x+y;
		
		System.out.println("Sum of all number of the list: " + reduceFunction(numbers, sumFunction));
		
		Predicate<Integer> evenPredicate = x -> x%2 == 0;
		
		
		Predicate<Integer> oddPredicate = x -> x%2 != 0;
		
		System.out.println("******** Even List **********");
		filterPredicate(numbers, evenPredicate).forEach(System.out::println);
		
		System.out.println("******** Odd List **********");
		filterPredicate(numbers, oddPredicate).forEach(System.out::println);
		
		System.out.println("Random Nuumber : " + ((Supplier<Integer>) () -> {
			Random random = new Random();
			return random.nextInt(10);
		}).get());
		
	}



	public static List<Integer> filterPredicate(List<Integer> numbers, Predicate<Integer> filterPredicate) {
		return numbers.stream().filter(filterPredicate).collect(Collectors.toList());
	}

	

	public static List<Integer> computeTheCollectionList(List<Integer> numbers, Function<Integer, Integer> function) {
		return numbers.stream().map(function).collect(Collectors.toList());
	}
	
	public static Integer reduceFunction(List<Integer> numbers, BinaryOperator<Integer> reduceFunction) {
		return numbers.stream().reduce(0, reduceFunction);
	}
}
