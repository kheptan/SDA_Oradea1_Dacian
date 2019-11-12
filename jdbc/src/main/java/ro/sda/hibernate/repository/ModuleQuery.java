package ro.sda.hibernate.repository;

import java.util.List;

import javax.persistence.Tuple;

import ro.sda.entities.Person;
import ro.sda.entities.Team;
import ro.sda.hibernate.request.ModuleRequest;

public class ModuleQuery {
	public static void printTeamsByLocation(String location) {
		List<Team> teams = new ModuleRequest().getTeamByLocation(location);
		if (teams!=null) {
			teams.forEach(e->{
				System.out.println(e.getName());
			});
		}
	}
	
	public static void  printTeamsInMarch(String location){
		List<Team> teams = new ModuleRequest().getTeamsInMarch(location);
		if (teams!=null) {
			teams.forEach(e->{
				System.out.println(e.getName());
			});
		}
	}
	
	public static void printStudentsWithSqlFinished() {
		List<Person> students = new ModuleRequest().getStudentsWithSqlFinished();
		System.out.println("\n");
		System.out.println("Students that already finished the SQL module");
		if(students !=null) {
			students.forEach(e->{
				System.out.println(e.getFirstName() + 
						" " + e.getLastName() +
						" " + e.getTeam().getIdTeam());
			});
		}
	}
	
	public static void printStudentsWithNoAbsence() {
		List<Person> students = new ModuleRequest().getStudentsWithIntegralAttendence();
		System.out.println("\n");
		System.out.println("All students with 100% attendence");
		if(!students.isEmpty()) {
			students.forEach(e->{
				System.out.println(e.getFirstName()+
						" " + e.getLastName());
			});
		}
	}
	
	public static void printAllJavaTrainers() {
		List<Person> trainers = new ModuleRequest().getAllJavaTrainers(); 
		System.out.println("\n");
		System.out.println("Print all java trainers");
		if(!trainers.isEmpty()) {
			trainers.forEach(e->{
				System.out.println(e.getFirstName()+
						" " + e.getLastName());
			});
		}
	}
	
	public static void printAllTrainersAtLocation(String location) {
		List<Person> trainers = new ModuleRequest().getAllTrainersAtLocation(location);
		System.out.println("\n");
		System.out.println("Print all java trainers at " + location);
		if(!trainers.isEmpty()) {
			trainers.forEach(e->{
				System.out.println(e.getFirstName()+
						" " + e.getLastName());
			});
		}
	}
	
	public static void printTeacherWithIntegralStudents() {
		List<Tuple> trainers = new ModuleRequest().getTrainerWithIntegralStudents();
		System.out.println("\n");
		System.out.println("Print all trainers who taught students with 100% attendence " );
		if(!trainers.isEmpty()) {
			trainers.forEach(e->{
				//System.out.println(e.get(1));
				System.out.println(e.get(0) + " " + e.get(1));
			});
		}
	}
}
