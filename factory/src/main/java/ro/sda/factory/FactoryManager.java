package ro.sda.factory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import ro.sda.menu.Menu;
import ro.sda.utils.JsonFile;
import ro.sda.utils.ScannerUtils;
import ro.sda.worktool.WorkTool;

public class FactoryManager {
	private List<Employee> employees;
	private Map<Integer,String> worktools = JsonFile.getWorktools();
	
	public FactoryManager() {
		employees = new ArrayList<Employee>();
	}

	public void addEmployee() {
		System.out.println("First, default json file will be imported...");
		processJsonStream();
		Menu.showLevel();
		int levelSelected = ScannerUtils.getNextInt();
        pick(levelSelected);
	}

	private void pick(int levelSelected) {
		switch (levelSelected) {
		  case  1 : addDirector();break;
		  case  2 : addManager();break;
		  case  3 : addWorker();break;
		  default : return;
		}	
	}

	private void addWorker() {
		System.out.println("Enter employee name: ");
		String name = ScannerUtils.getNext();
		
		System.out.println("Enter salary: ");
		double salary = ScannerUtils.getNextDouble();
		
		employees.add(new Worker(name, salary, JobLevel.WORKER,LocalDate.now()));
		System.out.println("Employee was added!");
	}

	private void addManager() {
		System.out.println("Enter manager name: ");
		String name = ScannerUtils.getNext();
		
		System.out.println("Enter salary: ");
		double salary = ScannerUtils.getNextDouble();
		
		employees.add(new Manager(name, salary, JobLevel.MANAGER,LocalDate.now()));
		System.out.println("Employee was added!");	
	}

	private void addDirector() {
		System.out.println("Enter director name: ");
		String name = ScannerUtils.getNext();
		
		System.out.println("Enter salary: ");
		double salary = ScannerUtils.getNextDouble();
		
		employees.add(new Director(name, salary, JobLevel.DIRECTOR,LocalDate.now()));
		System.out.println("Employee was added!");			
	}
	
	public void listEMployees() {
		System.out.println("");
		if(employees.isEmpty()) {
			System.out.println("There are no employees in the list, add some");
		} else {
			employees.stream().forEach(e-> 
			{
				System.out.println("Employee name is: "+ e.name+", Level : " + e.getLevel().name());
			});	
		}
		
	}

	public void doWork() {
		System.out.println("Select a user name from list : ");
		listEMployees();
		
		String name = ScannerUtils.getNext();
		if(name!=null && !employees.isEmpty() || worktools.isEmpty()) {
			Optional<Employee> employee = employees.stream().filter(e->e.name.equalsIgnoreCase(name)).findFirst();
			if(employee.isPresent()) {
				System.out.println("Give me a tool to work with, select a number from list below");
				worktools.entrySet()
				.forEach(e-> {
					System.out.println(e.getKey()+" ->"+e.getValue());
				});
				Integer key = ScannerUtils.getNextInt();
				String worktool = worktools.get(key);
				if(worktool!=null) {
					try {
						Class c = Class.forName("ro.sda.worktool."+worktool);
						employee.get().setWorkTool((WorkTool) c.newInstance());
						employee.get().useTool();
						c.newInstance();
						String status = employee.get().getStatus();
						System.out.println("Now status is " + status);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("Cant find any worktool");
				}
			} else {
				System.out.println("Employee not found and/or you don't import json file");
			}
		}
	}

	public void showStatus() {
		System.out.println("Select a user name from list : ");
		listEMployees();
		
		String name = ScannerUtils.getNext();
		if(name!=null && !employees.isEmpty()) {
			Optional<Employee> optional = employees.stream().filter(e->e.name.equalsIgnoreCase(name)).findFirst();
			if(optional.isPresent()) {
			    System.out.println("Employee status is: " + optional.get().getStatus());
			} else {
				System.out.println("Employee not found");
			}
		}
	}

	private void processJsonStream() {
		try {
			JsonFile.getFile();
			JsonFile.jsonParser();
			JsonFile.closeBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------");
	}
}
