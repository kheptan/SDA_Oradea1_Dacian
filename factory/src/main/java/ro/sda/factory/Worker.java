package ro.sda.factory;

import java.time.LocalDate;

import ro.sda.worktool.Tools;
import ro.sda.worktool.WorkTool;

public class Worker extends Employee implements Tools {

	public Worker(String name, double salary, JobLevel level,LocalDate date) {
		super(name, salary, level, date);
		this.status = "new worker..give me some work";
	}

	@Override
	void work() {
       System.out.println(this.status);		
	}

	@Override
	public void useTool(WorkTool work) {
		
	}


}
