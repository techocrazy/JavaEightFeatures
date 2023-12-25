package lambdaFeature;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(2,5,6,21,12,9,15,3);
		
		List<Integer> squaredNumber = compute(numbers, (Function<Integer, Integer>) x -> x*x);
		
		List<Integer> cubedNumber = compute(numbers, (Function<Integer, Integer>) x -> x*x*x);
		
		List<Integer> multipliedNumbers = multipliedByNumbers(numbers, (Function<Integer, Integer>) x -> x*5);
		
		List<Integer> multipliedNumbers2 = multipliedByNumbers(numbers, (Function<Integer, Integer>) x -> x*6);
		
		// the statement to the right of = should be extracted to a method which will take the collection as the first input
		// and the second input as behavior as parameterization 
		
		List<Integer> multipliedBy7 = numbers.stream().map(x -> x*7).collect(Collectors.toList());
		
		System.out.println("########## squared number ##########");
		
		Consumer<Integer> consumer = System.out::println;
		
		squaredNumber.forEach(consumer);
		
		System.out.println("########## cubed number ##########");
		
		cubedNumber.forEach(consumer);
		
		
		Predicate<Integer> predicate = x -> x%2 == 0;
		
		Function<Integer, String> function = x -> x + " ";
		
		BinaryOperator<Integer> binaryOperator = (x,y) -> x+y;
		numbers.stream().reduce(0, binaryOperator);
		
		
		Supplier<Integer> randomNumber = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		System.out.println("********* Random Number **********");
		System.out.println(randomNumber.get());
		
		Supplier<String> supplier = String::new;
		
		System.out.println(supplier.get());
		
	}

	public static List<Integer> multipliedByNumbers(List<Integer> numbers,	Function<Integer,Integer> numberX5) {
		return numbers.stream().map(numberX5).collect(Collectors.toList());
	}

	public static List<Integer> compute(List<Integer> numbers, Function<? super Integer, ? extends Integer> function) {
		return numbers.stream().map(function).collect(Collectors.toList());
	}

}
