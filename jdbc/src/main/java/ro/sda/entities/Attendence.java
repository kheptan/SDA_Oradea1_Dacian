package ro.sda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAttendents;

	private boolean isPresent;
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
	
	public Attendence(boolean isPresent, String comments) {
		this.isPresent = isPresent;
		this.comments = comments;
	}
	
	

	public void setIdAttendents(int idAttendents) {
		this.idAttendents = idAttendents;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	
	
}
