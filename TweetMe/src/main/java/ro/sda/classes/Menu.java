package ro.sda.classes;

import java.util.HashMap;

import ro.sda.utils.ScannerUtils;

public class Menu {

	private static HashMap<Integer, String> menu;

	// display menu items
	public static void showMenu() {
		getMenu().forEach((i, name) -> System.out.println(i + "->" + name));
	}
	// get menu item
	private static int menuItem(int option) {
		return getMenu().entrySet().stream().filter(e -> e.getKey() == option).mapToInt(e -> e.getKey()).findFirst()
				.getAsInt();
	}

	// initialize menu list
	public static void createMenu() {
		System.out.println("Please select one operation: \n");
		getMenu().put(1, "Add user");
		getMenu().put(2, "Add user message");
		getMenu().put(3, "List user messages");
		getMenu().put(4, "Search");
		getMenu().put(5, "Quit");
	}

	private static HashMap<Integer, String> getMenu() {
		if (menu == null)
			return menu = new HashMap<Integer, String>();
		else
			return menu;
	}

	// return user selected menu item
	public static int itemSelected() {
		return menuItem(userEntry());
	}
	// read user input
	private static int userEntry() {
		return ScannerUtils.getNextInt();
	}

	
}
