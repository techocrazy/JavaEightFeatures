package lambdaFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudent;
		
	public Course(String name, String category, int reviewScore, int noOfStudent) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudent = noOfStudent;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudent="
				+ noOfStudent + "]";
	}
	
			
}
public class FP04CustomClass 
{
	public static void main(String[] args) {
		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course ("Spring","Framework", 98, 20000));
		courses.add(new Course ("Spring Boot","Framework", 95, 18000));
		courses.add(new Course ("API","Microservice", 97, 22000));
		courses.add(new Course ("Microservice","Microservice", 96, 25000));
		courses.add(new Course ("Fullstack","Fullstack", 91, 14000));
		courses.add(new Course ("AWS","Cloud", 98, 22000));
		courses.add(new Course("Asure", "Cloud", 99, 21000));
		courses.add(new Course ("Docker","Cloud", 92, 20000));
		courses.add(new Course ("Kubernetes","Cloud", 91, 20000));
		

		Predicate<Course> reviewScoreGreaterThan95predicate = course -> course.getReviewScore() > 95;
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95predicate));
		
		Predicate<Course> reviewScoreGreaterThan90predicate = course -> course.getReviewScore() > 90;
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90predicate));
		
		System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan90predicate));
		
		Predicate<? super Course> noOfStudentsGreaterThan1800Predicate = course -> course.getNoOfStudent() > 18000;
		System.out.println(courses.stream().anyMatch(noOfStudentsGreaterThan1800Predicate));
		System.out.println(courses.stream().allMatch(noOfStudentsGreaterThan1800Predicate));
		System.out.println(courses.stream().noneMatch(noOfStudentsGreaterThan1800Predicate));
		
		
		// this is used to compare the number of students in ascending or descending using .reverse() method.
		
		Comparator<Course> comparingNumberOfStudents 
				= Comparator.comparing(Course::getNoOfStudent)
				.reversed();
		
		courses.stream().sorted(comparingNumberOfStudents).forEach(System.out::println);
		
		System.out.println("*************** comparingNumberOfStudentsAndReviews *******************");
		
		// this is used to compare the number of students and the reviewScore in ascending or descending order.
		// instead of using the comparing() method in the below sort we can use the comparingInt() method which
		// saves the boxing and unboxing of object if they are primitive.
		
		Comparator<Course> comparingNumberOfStudentsAndReviews 
				= Comparator.comparing(Course::getNoOfStudent)
							.thenComparing(Course::getReviewScore)
							.reversed();
		courses.stream().sorted(comparingNumberOfStudentsAndReviews).forEach(System.out::println);
		
		Comparator<Course> comparingNumberOfStudentsAndReviewsPrimitive 
		= Comparator.comparingInt(Course::getNoOfStudent)
					.thenComparingInt(Course::getReviewScore)
					.reversed();
		
		courses.stream().sorted(comparingNumberOfStudentsAndReviewsPrimitive).forEach(System.out::println);
		
		System.out.println("*************** comparingName *******************");
		
		Comparator<Course> comparingName = Comparator.comparing(Course::getName);
		
		courses.stream().sorted(comparingName).forEach(System.out::println);
		
		System.out.println("*************** Limit *******************");
		
		System.out.println(courses.stream().count());
		
		courses.stream()
			.limit(3)
			.forEach(System.out::println);
		
		System.out.println("*************** skip *******************");
		
		System.out.println(courses.stream().count());
		
		courses.stream()
			.skip(3)
			.forEach(System.out::println);
		
		System.out.println("*************** skip and limit *******************");
		
		System.out.println(courses.stream().count());
		
		courses.stream()
			.skip(3)
			.limit(4)
			.forEach(System.out::println);
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95predicate)
				.mapToInt(Course::getNoOfStudent)
				.sum());
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95predicate)
				.mapToInt(Course::getNoOfStudent)
				.average());
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95predicate)
				.mapToInt(Course::getNoOfStudent)
				.count());
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95predicate)
				.mapToInt(Course::getNoOfStudent)
				.max());
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95predicate)
				.mapToInt(Course::getNoOfStudent)
				.min());
		
		
		
		/* ************************************ grouping by methods ******************************** */
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory)));
		
		//{Microservice=[Course [name=API, category=Microservice, reviewScore=97, noOfStudent=22000], Course [name=Microservice, category=Microservice, reviewScore=96, noOfStudent=25000]], 
		//Cloud=[Course [name=AWS, category=Cloud, reviewScore=98, noOfStudent=22000], Course [name=Asure, category=Cloud, reviewScore=99, noOfStudent=21000], Course [name=Docker, category=Cloud, reviewScore=92, noOfStudent=20000], Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudent=20000]], 
		//Fullstack=[Course [name=Fullstack, category=Fullstack, reviewScore=91, noOfStudent=14000]], 
		//Framework=[Course [name=Spring, category=Framework, reviewScore=98, noOfStudent=20000], Course [name=Spring Boot, category=Framework, reviewScore=95, noOfStudent=18000]]}
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//{Microservice=2, Cloud=4, Fullstack=1, Framework=2}
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, 
							Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//{Microservice=Optional[Course [name=API, category=Microservice, reviewScore=97, noOfStudent=22000]], Cloud=Optional[Course [name=Asure, category=Cloud, reviewScore=99, noOfStudent=21000]], Fullstack=Optional[Course [name=Fullstack, category=Fullstack, reviewScore=91, noOfStudent=14000]], Framework=Optional[Course [name=Spring, category=Framework, reviewScore=98, noOfStudent=20000]]}
		
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, 
							Collectors.mapping(Course::getName, Collectors.toList()))));
		//{Microservice=[API, Microservice], Cloud=[AWS, Asure, Docker, Kubernetes], Fullstack=[Fullstack], Framework=[Spring, Spring Boot]}

		
		/* ************************* Flat Map example ****************************** */
		

		// "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Asure", "Docker", "Kubernetes"
		
		String[] str = {"Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Asure", "Docker", "Kubernetes"};
		List<String> coursesName = Arrays.asList(str);
				
		System.out.println(
				coursesName.stream().collect(Collectors.joining(" ")));
		
		System.out.println(
				coursesName.stream().collect(Collectors.joining(",")));
		
		String[] arr = "String".split("");
		List<String> str1 = Arrays.asList(arr);
		str1.forEach(System.out::println);
		
		// "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Asure", "Docker", "Kubernetes"
		// In the below code the above list of strings  are streamed and mapped to a new list who's elements are arrays of characters
		// due to this we get hashcodes in the o/p
		// to tackle this issue we use flatMap which converts the elements that are arrays to streams
		
		System.out.println(
				coursesName.stream()
					.map(course -> course.split(""))
					.collect(Collectors.toList()));
		
		System.out.println(
				coursesName.stream()
				.map(course -> course.split(""))
				.flatMap(Arrays::stream).collect(Collectors.toList()));
		
		System.out.println(
				coursesName.stream()
				.map(course -> course.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList()));
		
		/* ************** tuples ****************** */
		
		List<String> coursesName2 = Arrays.asList(str);
		
		System.out.println(
				coursesName.stream()
						.flatMap(course -> coursesName2.stream()
						.map(course2 -> Arrays.asList(course, course2))).collect(Collectors.toList()));
		
		System.out.println(
				coursesName.stream()
						.flatMap(course -> coursesName2.stream()
						.map(course2 -> Arrays.asList(course, course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
		
		System.out.println(
				coursesName.stream()
						.flatMap(course -> coursesName2.stream().filter(course2 -> course2.length()==course.length())
						.map(course2 -> Arrays.asList(course, course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
	
		
		Predicate<Course> reviewScoreGreaterThan95predicate2 = createPredicateWithCutoffReviewScore(95);
		
		
		Predicate<Course> reviewScoreGreaterThan90predicate2 = createPredicateWithCutoffReviewScore(90);
		
		
		// "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Asure", "Docker", "Kubernetes"
		// if we want to get the courses who's string length is greater than 11 and we want to uppercase all the letters of that o/p
		// and only get the first element of it.
		
		System.out.println("List of courses : " +
				coursesName.stream()
					.filter(course -> course.length() > 5)
					.map(String::toUpperCase)
		//			.findFirst()
					.collect(Collectors.toList()));
		
		System.out.println(
				coursesName.stream().peek(System.out::println)
					.filter(course -> course.length() > 11)
					.map(String::toUpperCase)
					.peek(System.out::println)
					.findFirst());
		
		
	}

	
	//this is a higher order function which means a function that returns a function back
	
	public static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
		return course -> course.getReviewScore() > cutoffReviewScore;
	}
	
}
