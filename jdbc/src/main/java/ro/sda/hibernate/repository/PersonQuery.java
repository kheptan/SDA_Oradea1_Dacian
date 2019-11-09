package ro.sda.hibernate.repository;

import java.util.List;

import ro.sda.entities.Person;
import ro.sda.hibernate.request.PersonRequest;

public class PersonQuery {
	public static List<Person> getAllPersons() {
		return new PersonRequest().selectAll();
	}
	
	public static List<Person> getStudentsByTeam(int id) {
		return new PersonRequest().selectByTeam(id);
	}

	public static void printPersonByTeam(int id) {
		List<Person> persons =PersonQuery.getStudentsByTeam(id);
		System.out.println("\nShow all students");
		System.out.println("--------------------------------------");
		persons.forEach(e->{
			System.out.println(e.getFirstName() +
					" - " + e.getLastName() +
					" -> " + e.getEmail()+
					" " + e.getTeam().getIdTeam());
		});
	}
	
	public static void printAllPersons() {
		List<Person> persons = PersonQuery.getAllPersons();
		System.out.println("\nShow all students");
		System.out.println("--------------------------------------");
		persons.forEach(e->{
					System.out.println(e.getFirstName() +
							" - " + e.getLastName() +
							" -> " + e.getEmail()+
							" " + e.getTeam().getIdTeam());
			});
	}
	
	
}
