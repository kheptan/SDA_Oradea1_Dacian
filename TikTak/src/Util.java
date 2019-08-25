import java.util.Scanner;

public class Util {
    public static Scanner sc;
    
    public static Scanner getScanner() {
    	if(sc==null) {
    		return new Scanner(System.in);
    	} else {
    		return sc;
    	}
    	
    }
    
    public static void setScanner(Scanner scanner) {
    	sc = scanner;
    }
}
