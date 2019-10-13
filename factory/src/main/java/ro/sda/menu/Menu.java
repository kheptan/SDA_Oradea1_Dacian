package ro.sda.menu;

import java.util.Scanner;

import ro.sda.factory.JobLevel;
import ro.sda.utils.ScannerUtils;

public class Menu {
	
	public enum MenuItems {
	    ADDEMPLOYEE("ADD EMPLOYEE",1),
	    LISTEMPLOYEES("LIST EMPLOYEES",2),
	    GIVEORDERS("GIVE ORDERS",3),
	    EMPLOYEESTATUS("EMPLOYEE STATUS",4),
	    IMPORTJSON("ADD JSON FILE",5),
	    QUITING("QUIT",6);
		
		private final String item;
		private final int position;
		
		private MenuItems(String item, int position) {
			this.item = item;
			this.position = position;
		}
		
		public int getPos() {
			return position;
		}
		
		public String getItem() {
			return item;
		}
	}
	
	Scanner sc = ScannerUtils.getScanner();
	
	public static void show() {
	   for(MenuItems item : MenuItems.values()) {
		   System.out.println(item.position + " )" + item.item);
	   }
	}
	
	public static void showLevel() {
		   System.out.println("Choose the type of employee");
		   for(JobLevel item : JobLevel.values()) {
			   System.out.println(item.getLevel() + ")" + item.name());
		   }
    }
}
