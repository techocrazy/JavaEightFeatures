package lambdaFeature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterizationPractise {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(2,5,6,21,12,9,15,3);
		
		List<Integer> squaredFunction0 = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		
		List<Integer> squaredFunction = compute(numbers, x -> x*x);
		
		List<Integer> cubedFunction = compute(numbers, x -> x*x*x);
		
		List<Integer> evenNumber = evenOrOddfilter(numbers, (Predicate<Integer>) x -> x % 2==0);
		
		List<Integer> oddNumber = evenOrOddfilter(numbers, (Predicate<Integer>) x -> x % 2!=0);
		
		squaredFunction.forEach(System.out::println);
		
		cubedFunction.forEach(System.out::println);
	}

	public static List<Integer> evenOrOddfilter(List<Integer> numbers, Predicate<? super Integer> predicateFunction) {
		return numbers.stream().filter(predicateFunction).collect(Collectors.toList());
	}

	public static List<Integer> compute(List<Integer> numbers, Function<Integer, Integer> function) {
		return numbers.stream().map(function).collect(Collectors.toList());
	}
	
	
}
