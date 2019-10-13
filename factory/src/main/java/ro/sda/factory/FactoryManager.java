package ro.sda.factory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import ro.sda.menu.Menu;
import ro.sda.utils.JsonFile;
import ro.sda.utils.ScannerUtils;

public class FactoryManager {
	private List<Employee> employees;
	
	public FactoryManager() {
		employees = new ArrayList<Employee>();
	}

	public void addEmployee() {
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
		if(name!=null && !employees.isEmpty()) {
			Optional<Employee> optional = employees.stream().filter(e->e.name.equalsIgnoreCase(name)).findFirst();
			if(optional.isPresent()) {
				System.out.println("What do you want me to do ?");
				String work = ScannerUtils.getNext();
				optional.get().setStatus(work);
				System.out.println("Now my status has changed to: " + optional.get().getStatus()); 
			} else {
				System.out.println("Employee not found");
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

	public void processJsonStream() {
		try {
			JsonFile.getFile();
			JsonFile.jsonParser();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
