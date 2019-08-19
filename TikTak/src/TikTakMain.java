import java.util.Scanner;

public class TikTakMain {

	public static void main(String[] args) {
		//initialise game controller
		GameController controller = new GameController();
		//get scanner
		Scanner scanner = controller.getScanner();
		
		//create two players
		controller.createPlayers(scanner);
        
        
        int i=0;
        while (i<5) {
           controller.playGame(scanner);
           if (controller.isWinner()) break;           
           i++;
        }
        
        if (!controller.isWinner()) {
        	System.out.println("No winner for this game ");
        	controller.drawGameResults();
        }
        scanner.close();
	}

}
