package ro.sda.factory;

import java.time.LocalDate;

import ro.sda.worktool.WorkTool;

public class Director extends Employee {

	public Director(String name, double salary, JobLevel level, LocalDate date) {
		super(name, salary, level, date);
		this.status = "new director..give me some work";
	}

	@Override
	void work() {
		System.out.println(this.getStatus());
	}

	@Override
	public void useTool(WorkTool tool) {
		tool.action();
	}

}
