package ro.sda.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtils {
	private static Scanner scanner;

	public static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
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
			getScanner().next();
			value = getNextDouble();
		}
		return value;
	}

	public static String getNextString() {
		String value;
		String regex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		try {
			// value = getScanner().nextLine();
			value = bufferRead();
		} catch (Exception e) {
			System.out.println("Input Error ");
			value = getNextString();
		}
		return value;
	}

	public static String bufferRead() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			return in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
