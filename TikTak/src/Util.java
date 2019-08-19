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
}
