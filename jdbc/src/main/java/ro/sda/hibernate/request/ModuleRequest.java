package ro.sda.hibernate.request;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.Attendence;
import ro.sda.entities.Attendence_;
import ro.sda.entities.ClassRoom;
import ro.sda.entities.ClassRoom_;
import ro.sda.entities.Course;
import ro.sda.entities.Course_;
import ro.sda.entities.Module;
import ro.sda.entities.Module_;
import ro.sda.entities.Person;
import ro.sda.entities.Person_;
import ro.sda.entities.Team;
import ro.sda.entities.Team_;
import ro.sda.request.Request;

public class ModuleRequest implements Request<Module> {
	private static final Session session = BootStrap.getSession();
	private static final CriteriaBuilder builder = session.getCriteriaBuilder(); 
	
	public List<Team> getTeamByLocation(String location) {
		CriteriaQuery<Team> criteria = builder.createQuery(Team.class);
		Root<Module> root = criteria.from(Module.class);
		
		Join<Module,ClassRoom> mt = root.join(Module_.CLASSROOM);
		Join<Module,Team> mc = root.join(Module_.TEAM);
		criteria.select(mc);
		criteria.where(mt.get(ClassRoom_.NAME).in(location));
		criteria.groupBy(root.get(Module_.TEAM));
		return session.createQuery(criteria).getResultList();
	}
	
	public List<Team> getTeamsInMarch(String location) {
		CriteriaQuery<Team> criteria =  builder.createQuery(Team.class);
		Root<Module> root  = criteria.from(Module.class);
		
		Join<Module,ClassRoom> mt = root.join(Module_.CLASSROOM);
		Join<Module,Team> mc = root.join(Module_.TEAM);
		
		criteria.select(mc);
		criteria.where(mt.get(ClassRoom_.NAME).in(location),
				builder.equal(builder.function("MONTH", 
						Integer.class,
						root.get(Module_.START_DATE)), 3)); //call mysql MONTH function
		return session.createQuery(criteria).getResultList();
	}
	
	public List<Person> getStudentsWithSqlFinished() {
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Module> root = criteria.from(Module.class);
		
		Join<Module,Course> modTocourse = root.join(Module_.COURSE);
		Join<Module,Team> modToteam = root.join(Module_.TEAM);
		Join<Team,Person> teamToperson = modToteam.join(Team_.PERSONS);
	
		criteria.select(teamToperson);
		criteria.where(modTocourse.get(Course_.ID_COURSE).in(3),
				builder.lessThan(root.get(Module_.END_DATE), builder.currentDate()),
				teamToperson.get(Person_.IS_TRAINER).in(0));
		return session.createQuery(criteria).getResultList();
	}
	
	public List<Person> getStudentsWithIntegralAttendence(){
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Attendence> root = criteria.from(Attendence.class);
		Join<Attendence,Person> joinPerson = root.join(Attendence_.PERSON);
		criteria.select(joinPerson);
		criteria.groupBy(root.get(Attendence_.PERSON));
		Expression<Integer> getAttendenceStatus = builder.min(root.get(Attendence_.IS_PRESENT));
		Expression<Boolean> isPresent = builder.greaterThan(getAttendenceStatus,0);
		criteria.having(isPresent);
		return session.createQuery(criteria).getResultList(); 
	}
	
	public List<Person> getAllJavaTrainers(){
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Module> root = criteria.from(Module.class);
		Join<Module,Person> joinPerson = root.join(Module_.PERSON);
		Join<Module,Course> joinCourse = root.join(Module_.COURSE);
		criteria.where(root.get(Module_.COURSE).in(1),
				joinPerson.get(Person_.IS_TRAINER).in(1));
		criteria.groupBy(root.get(Module_.PERSON));
		criteria.select(joinPerson);
		return session.createQuery(criteria).getResultList();
	}
	
	public List<Person> getAllTrainersAtLocation(String location) {
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Module> root = criteria.from(Module.class);
		
		Join<Module,ClassRoom> joinClassroom = root.join(Module_.CLASSROOM);
		Join<Module,Person> joinPerson = root.join(Module_.PERSON);
		criteria.select(joinPerson);
		criteria.where(joinClassroom.get(ClassRoom_.NAME).in(location),
				joinPerson.get(Person_.IS_TRAINER).in(1));
		criteria.groupBy(root.get(Module_.PERSON));
		return session.createQuery(criteria).getResultList();
	}
	
	public List<Tuple> getTrainerWithIntegralStudents(){
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
		Root<Attendence> root = criteria.from(Attendence.class);
		Join<Attendence,Module> joinModule = root.join(Attendence_.MODULE);
		Join<Module,Team> joinTeam = joinModule.join(Module_.TEAM);		
		Join<Team,Person> joinTeacher = joinTeam.join(Team_.PERSONS);
		
		Expression<Boolean> isTeacher = builder.equal(joinTeacher.get(Person_.IS_TRAINER), 1);
		Expression<Integer> getAttendenceStatus = builder.min(root.get(Attendence_.IS_PRESENT));
		Expression<Boolean> isPresent = builder.greaterThan(getAttendenceStatus,0);
		
		Path<Integer> idStudent = root.get(Attendence_.PERSON);
		Path<String> name = joinTeacher.get(Person_.FIRST_NAME);
		Path<String> lastname = joinTeacher.get(Person_.LAST_NAME);
		
		criteria.where(isTeacher);
		criteria.groupBy(idStudent,name,lastname);
		criteria.multiselect(name,lastname).distinct(true);
		criteria.having(isPresent);
		
		return session.createQuery(criteria).getResultList();
	}
	
	@Override
	public int insert(Module t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Module t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Module> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Module t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
