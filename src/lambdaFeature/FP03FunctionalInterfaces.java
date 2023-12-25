package lambdaFeature;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
	
	/*
	 	boolean even(int a){
	 	 return a%2 ==0;
	 	}
	 	
	 	boolean squared(int a){
	 	 return a*a;
	 	}
	 	
	*/
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(12,34,23,56,13,12,34);
		
		Predicate<Integer> evenPredicate = x -> x%2==0;
		
		Predicate<Integer> evenPredicate2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				return x%2==0;
			}
			
		};
		
		
		Function<Integer,Integer> squaredFunction = x -> x*x;
		
		Function<Integer,Integer> squaredFunction2 = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer x) {
				return x*x;
			}
			
		};
		
		Consumer<Integer> sysConsumer = System.out::println;
		
		Consumer<Integer> sysConsumer2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer a) {
				System.out.print(a);
			}};
		
		numbers.stream()
					.filter(evenPredicate)
					.map(squaredFunction)
					.forEach(sysConsumer);
		
		
		BinaryOperator<Integer> binaryOperator = Integer::sum;
		
		BinaryOperator<Integer> binaryOperator2 = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}};
		
		numbers.stream()
					.reduce(binaryOperator);
	}

}
