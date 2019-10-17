package ro.sda.factory;

import java.time.LocalDate;

import ro.sda.worktool.Tools;
import ro.sda.worktool.WorkTool;

public abstract class Employee implements Tools {
	String name;
	static LocalDate date;
    double salary;
    String status;
	final JobLevel level;
	WorkTool workTool;
	
	public Employee(String name, double salary, 
			JobLevel level, LocalDate date) {
		this.name = name;
		this.salary = salary;
		this.level = level;
		this.date = date;
		this.status="Waiting for new orders...";
	}

	abstract void work();

	public JobLevel getLevel() {
		return level;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public WorkTool getWorkTool() {
		return workTool;
	}

	public void setWorkTool(WorkTool workTool) {
		this.workTool = workTool;
	}
	
	
}
