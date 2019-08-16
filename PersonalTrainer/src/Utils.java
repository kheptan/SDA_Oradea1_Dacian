import java.util.Scanner;

public class Utils {
	private static Scanner sc;

    public static Scanner getScanner() {
		// singleton scanner
		if (sc == null) {
			return sc = new Scanner(System.in);
		} else {
			return sc;
		}
	}

	public static void closeScanner() {
		sc.close();
    }
}
