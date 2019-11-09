package ro.sda.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClassRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClassroom;
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "classroom")
	private List<Module> module;
	
	public ClassRoom() {
	}
	
	public ClassRoom(int idClassroom, String name, String address) {
		this.idClassroom = idClassroom;
		this.name = name;
		this.address = address;
	}

	public ClassRoom(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public int getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(int idClassroom) {
		this.idClassroom = idClassroom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}
	
	
}
