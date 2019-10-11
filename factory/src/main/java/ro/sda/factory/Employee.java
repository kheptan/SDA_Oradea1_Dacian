package ro.sda.factory;

import java.time.LocalDate;

public abstract class Employee {
	String name;
	static LocalDate date;
    double salary;
    String status;
	final JobLevel level;
	
	public Employee(String name, double salary, 
			JobLevel level, LocalDate date) {
		this.name = name;
		this.salary = salary;
		this.level = level;
		this.date = date;
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
	
	
}
