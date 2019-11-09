package ro.sda.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModule;
	
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "idTeam")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "idTrainer")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "idCourse")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "idClassroom")
	private ClassRoom classroom;
	
	@OneToMany(mappedBy = "module")
	private List<Attendence> attendence;
	
	public Module() {
	}

	public Module(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
