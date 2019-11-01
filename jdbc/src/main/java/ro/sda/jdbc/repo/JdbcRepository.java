package ro.sda.jdbc.repo;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import ro.sda.entities.ClassRoom;
import ro.sda.entities.Team;
import ro.sda.jdbc.request.ClassRoomRequest;
import ro.sda.jdbc.request.TeamRequest;
import ro.sda.request.Request;

public class JdbcRepository {
	private List<Team> teams = null;
	private List<ClassRoom> classes = null;
	
	
	public JdbcRepository() {
		this.teams = getAllTeams();
		this.classes = getAllClasses();
	}

	private static final Request<Team> requestTeam = new TeamRequest();
	private static final Request<ClassRoom> requestClassRoom = new ClassRoomRequest();
	
	private static void mysqlJdbcConnect(Connection conn) {
		if (conn!=null) {
			//select all teams
			//teams = JdbcConnector.selectAllTeams(conn);
			//insert new team
			//insertNewTeam("NewTeam",100);
			
			//updateTeam("NewTeam","Updated",150);
			//deleteTeamRow("New Team");
			//classes = getClasses(conn);
			//updateClassroom("OradeaSda", "", "Strada Mihai X");
			//insertClassroom("OradeaSda", "fara adresa");
			//classes.forEach(e->System.out.println(e.getName() + " " + e.getAddress()));
			//updateClassroom("oradea3", "update3", "addressNew");
			//deleteClassroom("zac");
		}
	}

	public  List<Team> getAllTeams() {
		return teams = requestTeam.selectAll();
	}
	
	public void insertTeam(String name,int max) {
    	int result = requestTeam.insert(new Team(name,max));
    	if(result==1) {
    		System.out.println("Succes");
    	} else {
    		System.out.println("Insert error");
    	}
	}
	
	public void deleteTeam(String name) {
    	Optional<Team> team = teams
    			    .stream()
    			    .filter(t->t.getName().equalsIgnoreCase(name))
    			    .findFirst();
    	if(team.isPresent()) {
    		requestTeam.delete(team.get());
    	}
    }
    
	public void updateTeam(String name,String update,int maxStudents) {
    	Optional<Team> opt = teams
			    .stream()
			    .filter(t->t.getName().equalsIgnoreCase(name))
			    .findFirst();
		if(opt.isPresent()) {
			Team team = opt.get();
			team.setName(update);
			team.setMaxStudents(maxStudents);
			requestTeam.update(team);
		} else {
			System.out.println("Name not found");
		}
    }
    
	public void showAllTeams() {
		teams.forEach(t->{
			System.out.println("\n"+t.getName());
			System.out.println("--------------------------");
			t.getPersons()
			.stream().forEach(p->{
				      System.out.println(p.getFirstName()
				    		  .concat(" "+p.getLastName()));
			});
		});
	}
	
	public List<ClassRoom> getAllClasses() {
		return classes = requestClassRoom.selectAll();
	}
	
	private void insertClassroom(String name,String address) {
		requestClassRoom.insert(new ClassRoom(name,address));
    }
	
	public void deleteClassroom(String name) {
    	Optional<ClassRoom> classroom = classes
    			    .stream()
    			    .filter(t->t.getName().equalsIgnoreCase(name))
    			    .findFirst();
    	if(classroom.isPresent()) {
    		requestClassRoom.delete(classroom.get());
    	} else {
    		System.out.println("Name not found");
    	}
    }
	
	public void updateClassroom(String name,String update,String address) {
    	Optional<ClassRoom> opt = classes
			    .stream()
			    .filter(t->t.getName().equalsIgnoreCase(name))
			    .findFirst();
		if(opt.isPresent()) {
			ClassRoom classroom = opt.get();
			classroom.setName(update);
			classroom.setAddress(address);
			requestClassRoom.update(classroom);
		} else {
			System.out.println("nu am gasit nimic");
		}
    }


}
