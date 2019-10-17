package ro.sda.factory;

import java.time.LocalDate;

public class Director extends Employee {

	public Director(String name, double salary, JobLevel level, LocalDate date) {
		super(name, salary, level, date);
	}

	@Override
	void work() {
		System.out.println(this.getStatus());
	}

	@Override
	public void useTool() {
		setStatus(workTool.action());;
	}

}
