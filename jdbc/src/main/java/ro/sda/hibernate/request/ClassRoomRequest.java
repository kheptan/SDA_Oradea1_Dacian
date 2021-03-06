package ro.sda.hibernate.request;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.ClassRoom;
import ro.sda.entities.ClassRoom_;
import ro.sda.request.Request;

public class ClassRoomRequest implements Request<ClassRoom> {
	private static final Session session = BootStrap.getSession();
	private static final CriteriaBuilder builder = session.getCriteriaBuilder();
	
	public ClassRoom getClassRoom(String byName) {
		CriteriaQuery<ClassRoom> criteria = builder.createQuery(ClassRoom.class);
		Root<ClassRoom> root = criteria.from(ClassRoom.class);
		criteria.select(root);
		criteria.where(root.get(ClassRoom_.NAME).in(byName));
		return session.createQuery(criteria).getSingleResult();
	}
	
	@Override
	public int insert(ClassRoom t) {
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
	public int update(ClassRoom t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ClassRoom> selectAll() {
		CriteriaQuery<ClassRoom> criteria = builder.createQuery(ClassRoom.class);
		Root<ClassRoom> root = criteria.from(ClassRoom.class);
		criteria.select(root);
		return session.createQuery(criteria).getResultList();
	}

	@Override
	public int delete(ClassRoom t) {
		session.getTransaction().begin();
		session.delete(t);
		session.getTransaction().commit();
		return 0;
	}
	
	
}
