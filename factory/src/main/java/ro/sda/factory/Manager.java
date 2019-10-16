package ro.sda.factory;

import java.time.LocalDate;

import ro.sda.worktool.WorkTool;

public class Manager extends Employee {

	public Manager(String name, double salary, JobLevel level, LocalDate date) {
		super(name, salary, level, date);
		this.status = "new manager..give me some work";
	}

	@Override
	void work() {
		System.out.println(this.status);	
	}

	@Override
	public void useTool(WorkTool tool) {
		tool.action();
	}

}
