package ro.sda.sdaApp;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.Person;
import ro.sda.entities.Person_;
import ro.sda.entities.Team;
import ro.sda.entities.Team_;

public class MainApp {
	
	private static final Session session = BootStrap.getSession();
	
	public static void main(String[] args) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
		Root<Team> root = criteria.from(Team.class);
		Join<Team,Person> owner = root.join(Team_.PERSONS);
		
		Path<String> fname = owner.get(Person_.FIRST_NAME);
		Path<String> sname = owner.get(Person_.LAST_NAME);
		Path<String> email = owner.get(Person_.EMAIL);
		criteria.multiselect(fname,sname,email);
		criteria.where(root.get(Team_.NAME).in("dacian"));
		
		List<Tuple> result = session.createQuery(criteria).getResultList();
		result.forEach(e-> {
			System.out.print(e.get(fname)+" ");
			System.out.print(e.get(sname)+" ");
			System.out.println(e.get(email)+" ");
			});
		session.close();
	}
	
		
}
