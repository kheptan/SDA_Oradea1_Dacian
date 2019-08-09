import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Reverse {
 
	static Scanner sc = new Scanner(System.in);
	static String CONTINUE = "continue";
	static String QUIT = "quit";
	
	public static void main(String[] args) {
        swapWords();
	}
    
	private static void swapWords() {
		String s = null;
		
		while (true) {
			s = sc.next();
			if (s.contains(CONTINUE)) {
				continue;
			} else if (s.contains(QUIT)) {
				System.out.println("Good Bye!!!");
				break;
			}
            
			for (int i=1; i<=s.length(); i++) {
				System.out.print(s.charAt(s.length()-i));
			}
		}
	}
}
