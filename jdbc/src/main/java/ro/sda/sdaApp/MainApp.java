package ro.sda.sdaApp;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.hibernate.repository.ModuleQuery;

public class MainApp {
	
	private static final Session session = BootStrap.getSession();
	
	public static void main(String[] args) {
		//Get all students - DONE
		//PersonQuery.printAllPersons();
		
		//Get a team by id  - DONE
		//PersonQuery.printPersonByTeam(3);
		
		//Get teams by Location - Done
		//ModuleQuery.printTeamsByLocation("intesa");
		
		//Get teams in march - Done
		ModuleQuery.printTeamsInMarch("Inspectorat");
		
		//ClassRoomQuery.createNewClassRoom("New ClassRoom", "in space");
		//ClassRoomQuery.deleteClassRoom("New ClassRoom");
		//List<ClassRoom> classes = ClassRoomQuery.getAllClassRooms();
		//classes.forEach(e->System.out.println(e.getName()));
		
		//CourseQuery.createNewCourse("Curs Hibernate", "hibernate basics");
		//List<Course> courses = CourseQuery.getAllCourses();
		//CourseQuery.deleteCourse("Hibernate");
		/*
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
		
		Root<Team> root = criteria.from(Team.class);
		Join<Team,Person> owner = root.join(Team_.PERSONS);
		
		Path<String> fname = owner.get(Person_.FIRST_NAME);
		Path<String> sname = owner.get(Person_.LAST_NAME);
		Path<String> email = owner.get(Person_.EMAIL);
		
		criteria.multiselect(fname,sname,email);
		criteria.where(root.get(Team_.NAME).in("oradea"));
		
		List<Tuple> result = session.createQuery(criteria).getResultList();
		
		result.forEach(e-> {
			System.out.print(e.get(fname)+" ");
			System.out.print(e.get(sname)+" ");
			System.out.println(e.get(email)+" ");
			});
		session.close();
		*/
	}
	
		
}
