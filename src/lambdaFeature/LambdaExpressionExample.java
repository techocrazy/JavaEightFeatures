package lambdaFeature;

import java.util.function.Function;

@FunctionalInterface	
interface Test
{
	public int testMethod(int a, int b);
//	public void test2Method(int x, int y);
}

public class LambdaExpressionExample {

	public static void main(String[] args)
	{
		Test t = (a, b) -> a+b;
		System.out.println(t.testMethod(10,20));
		Function<Integer, Integer> f = i -> i*i;
		System.out.println(f.apply(4));
	}
}
