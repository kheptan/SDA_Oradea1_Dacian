package ro.sda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.metamodel.StaticMetamodel;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerson;
	private String firstName;
	private String lastName;
	private String email;
	private byte isTrainer;

	@ManyToOne
    @JoinColumn(name="idTeam")
	private Team team;
	
	public Person() {}
	
	public Person(int idPerson, String firstName,
			String lastName, String email,
			byte isTrainer,int idTeam) 
	{
		this.idPerson = idPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isTrainer = isTrainer;
	}
	
	
	
	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public byte getIsTrainer() {
		return isTrainer;
	}

	public void setIsTrainer(byte isTrainer) {
		this.isTrainer = isTrainer;
	}
	
	
}
