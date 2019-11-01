package ro.sda.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.Team;

public class TeamRepository {
	private Session session;
	
	public void connect() {
		session  = BootStrap.getSession();
	}
	
	public void getTeam() {
		Team team = session.find(Team.class,44);
		System.out.println(team.getName());
	}
	
	public List<Team> getTeamCriteria() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Team> criteria = builder.createQuery(Team.class);
		Root<Team> root = criteria.from(Team.class);
		CriteriaQuery<Team> all = criteria.select(root);
		return  session.createQuery(all).getResultList();
	}
}
