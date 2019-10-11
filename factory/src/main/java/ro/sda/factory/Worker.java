package ro.sda.factory;

import java.time.LocalDate;

public class Worker extends Employee {

	public Worker(String name, double salary, JobLevel level,LocalDate date) {
		super(name, salary, level, date);
		this.status = "new worker..give me some work";
	}

	@Override
	void work() {
       System.out.println(this.status);		
	}

}
