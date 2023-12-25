package lambdaFeature;

import java.util.stream.LongStream;

public class FP05Parallelizing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();

		//0, 1000000000
//		System.out.println(LongStream.range(0, 1000000000).sum());
		
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());
		
		System.out.println(System.currentTimeMillis() - time);
	}

}
