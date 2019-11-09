package ro.sda.hibernate.request;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.Course;
import ro.sda.entities.Course_;
import ro.sda.request.Request;

public class CourseRequest implements Request<Course> {
	private static final Session session = BootStrap.getSession();
	private static final CriteriaBuilder builder = session.getCriteriaBuilder(); 

	@Override
	public int insert(Course t) {
		session.getTransaction().begin();
		session.save(t);
		session.getTransaction().commit();
		
		TransactionStatus committed = session.getTransaction().getStatus();
		
		if(committed.name().equals("COMMITTED")) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int update(Course t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Course getCourse(String byName) {
		CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
		Root<Course> root = criteria.from(Course.class);
		criteria.select(root);
		criteria.where(root.get(Course_.NAME).in(byName));
		return session.createQuery(criteria).getSingleResult();
	}
	
	@Override
	public List<Course> selectAll() {
		CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
		Root<Course> root = criteria.from(Course.class);
		criteria.select(root);
		return session.createQuery(criteria).getResultList();
	}

	@Override
	public int delete(Course t) {
		session.getTransaction().begin();
		session.delete(t);
		session.getTransaction().commit();
		return 0;
	}

}
