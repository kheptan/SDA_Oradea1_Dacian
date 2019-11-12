package ro.sda.sdaApp;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;

public class MainApp {
	
	private static final Session session = BootStrap.getSession();
	
	public static void main(String[] args) {
		//Get all students 
		//PersonQuery.printAllPersons();
		
		//List all students for a group 
		//PersonQuery.printPersonByTeam(2);
		
		//List all groups that had classes in location Intensa
		//ModuleQuery.printTeamsByLocation("intesa");
		
		//List all groups that had classes in location Inspectorat in March 2019
		//ModuleQuery.printTeamsInMarch("Inspectorat");
		
		//List all students that already finished the SQL module
		//ModuleQuery.printStudentsWithSqlFinished();
		
		//List all students with 100% attendance rate
		//ModuleQuery.printStudentsWithNoAbsence();
		
		// List all trainers that teach Java Fundamentals
		//ModuleQuery.printAllJavaTrainers();
		
		//List all trainers that teach at Intensa location
		//ModuleQuery.printAllTrainersAtLocation("Intesa");
		
		//List all trainers that taught students with 100% attendance rate
		//ModuleQuery.printTeacherWithIntegralStudents();
		
	}
	
		
}
