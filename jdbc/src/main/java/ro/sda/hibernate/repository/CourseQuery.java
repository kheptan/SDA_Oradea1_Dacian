package ro.sda.hibernate.repository;

import java.util.List;

import ro.sda.entities.Course;
import ro.sda.hibernate.request.CourseRequest;

public class CourseQuery {
		
	
	public static void createNewCourse(String name,String description) {
		int courseRequest = new CourseRequest().insert(new Course(name,description));
		if( courseRequest==1) { System.out.println("Succes!");}
		else { System.out.println("Not inserted"); }
	}
	
	
	public static List<Course> getAllCourses(){
		return new CourseRequest().selectAll();
	}
	
	
	public static Course getCourseByName(String byName) {
		return new CourseRequest().getCourse(byName);
	}
	
	
	public static void deleteCourse(String byName) {
		Course course = getCourseByName(byName);
		if(course!=null) {
			new CourseRequest().delete(course);
		} else {
			System.out.println("Didn't find the course");
		}
	}
}
