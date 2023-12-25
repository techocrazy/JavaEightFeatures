package lambdaFeature;

import java.util.Arrays;
import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		
		printAllNumbersInListFunctional(Arrays.asList(1,2,3,4,5,6,7,8,9));
	}
	
	public static void print(int number) {
		System.out.println(number);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream().forEach(FP02Functional::print);
		
	}
}
