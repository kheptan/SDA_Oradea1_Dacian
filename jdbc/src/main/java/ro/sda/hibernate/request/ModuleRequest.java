package ro.sda.hibernate.request;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.ClassRoom;
import ro.sda.entities.ClassRoom_;
import ro.sda.entities.Module;
import ro.sda.entities.Module_;
import ro.sda.entities.Team;
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
		return session.createQuery(criteria).getResultList();
	}
	
	public List<Team> getTeamsInMarch(String location) {
		CriteriaQuery<Team> criteria =  builder.createQuery(Team.class);
		Root<Module> root  = criteria.from(Module.class);
		
		Join<Module,ClassRoom> mt = root.join(Module_.CLASSROOM);
		Join<Module,Team> mc = root.join(Module_.TEAM);
		criteria.select(mc);
		criteria.where(mt.get(ClassRoom_.NAME).in(location),
				builder.equal(builder.function("MONTH", Integer.class, root.get(Module_.START_DATE)),3)); //call mysql MONTH function
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
