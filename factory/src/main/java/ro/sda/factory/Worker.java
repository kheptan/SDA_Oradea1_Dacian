package ro.sda.factory;

import java.time.LocalDate;

import ro.sda.worktool.Tools;

public class Worker extends Employee implements Tools {

	public Worker(String name, double salary, JobLevel level,LocalDate date) {
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
