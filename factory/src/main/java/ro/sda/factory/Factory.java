package ro.sda.factory;

import java.io.IOException;

import ro.sda.menu.Menu;
import ro.sda.utils.JsonFile;
import ro.sda.utils.ScannerUtils;

public class Factory {
	private static FactoryManager fm = new FactoryManager();
	
	public static void main(String[] args) {
	    startFactory();
	    ScannerUtils.closeScanner();
	}

	private static void startFactory() {
		int itemSelected = 0;
		int quit = Menu.MenuItems.QUITING.getPos();
		
		while(itemSelected!= quit) {
			Menu.show();
			itemSelected = ScannerUtils.getNextInt();
			pick(itemSelected);
			System.out.println("\r------------------------------------------\r");
		}
	}

	private static void pick(int itemSelected) {
		switch (itemSelected) {
		  case  1 : fm.addEmployee();break;
		  case  2 : fm.listEMployees();break;
		  case  3 : fm.doWork();break;
		  case  4 : fm.showStatus();break;
		  case  5 : fm.processJsonStream();break;
		  case  6 : System.out.println("Quit");break;
		}
		try {
			JsonFile.closeBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
