package lambdaFeature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaExpressionInCollection {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(40);
		al.add(65);
		al.add(50);
		Comparator<Integer> c = (a,b) -> (a>b)?1:(a<b)?-1:0;
		Collections.sort(al,c);
		al.stream().forEach(System.out::println);
	}

}
