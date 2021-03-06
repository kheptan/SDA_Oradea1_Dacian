package ro.sda.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeam;
	private String name;
	private int maxStudents;
	
	
	@OneToMany(mappedBy = "team")
	private List<Person> persons;
	
	@OneToMany(mappedBy = "team")
	private List<Module> modules;
	
	public Team() {
		
	}
	public Team(int idTeam,String name, int maxStudents,List<Person> persons) {
		this.name = name;
		this.maxStudents = maxStudents;
		this.idTeam = idTeam;
		this.persons = persons;
	}
    
	//withoud IdTeam - autoGenerated, List<Persons> 	
	public Team(String name, int maxStudents) {
		this.name = name;
		this.maxStudents = maxStudents;
	}

	public String getName() {
		return name;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	

}
