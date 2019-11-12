package ro.sda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Attendents")
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAttendents;

	private int isPresent;
	private String comments;
	
	@ManyToOne()
	@JoinColumn(name = "idStudent")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "idModule")
	private Module module;

	public int getIdAttendents() {
		return idAttendents;
	}
	
	public Attendence() {}
	
	public Attendence(int isPresent, String comments) {
		this.isPresent = isPresent;
		this.comments = comments;
	}
	
	

	public void setIdAttendents(int idAttendents) {
		this.idAttendents = idAttendents;
	}

	public int isPresent() {
		return isPresent;
	}

	public void setPresent(int isPresent) {
		this.isPresent = isPresent;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}


	
	
}
