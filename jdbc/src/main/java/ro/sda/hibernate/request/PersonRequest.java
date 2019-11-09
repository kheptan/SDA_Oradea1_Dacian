package ro.sda.hibernate.request;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.Person;
import ro.sda.entities.Person_;
import ro.sda.entities.Team;
import ro.sda.request.Request;

public class PersonRequest implements Request<Person>{
	private static final Session session = BootStrap.getSession();
	private static final CriteriaBuilder builder = session.getCriteriaBuilder();
	
	@Override
	public int insert(Person t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Person t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> selectAll() {
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Person> root = criteria.from(Person.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get(Person_.IS_TRAINER), 0));
		return session.createQuery(criteria).getResultList();
	}

	public List<Person> selectByTeam(int id) {
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Person> root = criteria.from(Person.class);
		Join<Person,Team> owner = root.join(Person_.TEAM);
		criteria.select(root);
		criteria.where(builder.equal(root.get(Person_.TEAM),id),
				builder.equal(root.get(Person_.IS_TRAINER),0));
		return session.createQuery(criteria).getResultList();
	}	
	
	@Override
	public int delete(Person t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
