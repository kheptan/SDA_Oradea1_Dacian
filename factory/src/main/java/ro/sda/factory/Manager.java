package ro.sda.factory;

import java.time.LocalDate;

public class Manager extends Employee {

	public Manager(String name, double salary, JobLevel level, LocalDate date) {
		super(name, salary, level, date);
	}

	@Override
	void work() {
		System.out.println(this.status);	
	}

	@Override
	public void useTool() {
		setStatus(workTool.action());
	}

}
