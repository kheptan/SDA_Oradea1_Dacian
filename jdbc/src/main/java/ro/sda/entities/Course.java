package ro.sda.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourse;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "course")
	private List<Module> module;
	
	public Course() {
	}

	public Course(Long idCourse, String name, String description) {
		this.idCourse = idCourse;
		this.name = name;
		this.description = description;
	}
	
	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}
	
	
}
