package lambdaFeature;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course2 {
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudent;
		
	public Course2(String name, String category, int reviewScore, int noOfStudent) {
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
public class FP04CustomClassPractice 
{
	public static void main(String[] args) {
		List<Course2> courses = new ArrayList<Course2>();
		courses.add(new Course2 ("Spring","Framework", 98, 20000));
		courses.add(new Course2 ("Spring Boot","Framework", 95, 18000));
		courses.add(new Course2 ("API","Microservice", 97, 22000));
		courses.add(new Course2 ("Microservice","Microservice", 96, 25000));
		courses.add(new Course2 ("Fullstack","Fullstack", 91, 14000));
		courses.add(new Course2 ("AWS","Cloud", 98, 22000));
		courses.add(new Course2("Asure", "Cloud", 99, 21000));
		courses.add(new Course2 ("Docker","Cloud", 92, 20000));
		courses.add(new Course2 ("Kubernetes","Cloud", 91, 20000));
		

		
//		add all the students of the course
		 				
		System.out.println(
				courses.stream()
				.mapToInt(Course2::getNoOfStudent)
				.sum());
		
//		highest number of students
		
		System.out.println(
				courses.stream()
				.mapToInt(Course2::getNoOfStudent)
				.max());
		
//		return the complete course with highest number of review
		
		Comparator<Course2> comparing = Comparator.comparing(Course2::getReviewScore).reversed();
		
		Optional<Course2> course = courses.stream().sorted(comparing).findFirst();
		
		System.out.println(course);
		
		
		
		// return number of students for course which has reviews greater than 95
		
		Predicate<Course2> predicate = course2 -> course2.getReviewScore() > 95;
		
		System.out.println("**********************************");
		
		courses.stream().filter(predicate).forEach(System.out::println);
		
		int sum = courses.stream().filter(predicate).mapToInt(Course2::getNoOfStudent).sum();
		
		System.out.println(sum);
		
	}
}
