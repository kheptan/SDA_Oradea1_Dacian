package ro.sda.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner;

	public static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in).useDelimiter("\n");;
		}
		return scanner;
	}

	public static void closeScanner() {
		scanner.close();
	}

	public static int getNextInt() {
		int value;
		try {
			value = getScanner().nextInt();
		} catch (Exception e) {
			System.out.println("Input Error ");
			getScanner().nextLine();
			value = getNextInt();
		}
		return value;
	}

	public static double getNextDouble() {
		double value;
		try {
			value = getScanner().nextDouble();
		} catch (Exception e) {
			System.out.println("Input Error ");
			getScanner().nextLine();
			value = getNextDouble();
		}
		return value;
	}

	public static String getNextString() {
		String value;
		try {
			value = getScanner().nextLine();
		} catch (Exception e) {
			System.out.println("Input Error ");
			value = getNextString();
		}
		return value;
	}
	
	public static String getNext() {
		String value;
		try {
			value = getScanner().next();
		} catch (Exception e) {
			System.out.println("Input Error ");
			value = getNext();
		}
		return value;
	}
	
}
