import java.util.Scanner;

public class TikTakMain {
	private static final int MAX = 5;
	static Scanner scanner = Util.getScanner();
	
	public static void main(String[] args) {
		GameController game = new GameController();
			
		
		while(true) {
			initGame(game);
			play(game);
			gameResults(game);
			if (!playAgain(game)) break;
		}
	}
	
	private static void play(GameController game) {
		int i=0;
        while (i<MAX) {
           game.playGame(scanner);
           if (game.isWinner()) break;           
           i++;
        }
        
	}
    
	private static void initGame(GameController game) {
		game.createPlayers(scanner);
    }
	
	private static void gameResults(GameController game) {
		if (!game.isWinner()) {
        	System.out.println("No winner for this game ");
        	game.drawGameResults();        	
        }
	}

    private static boolean playAgain(GameController game) {
    	System.out.println("Are you in the mood for playing this again?");
    	System.out.println("Enter Y or N");
    	char response = scanner.next().charAt(0);
    	boolean b =  playNextGame(response,scanner);
    	if (b) {
    		game.resetGame();
    		Util.setScanner(null);
    		scanner = Util.getScanner();
    		return true;
    	} else {
    		return false;
    	}
    	
    }

	private static boolean playNextGame(char response,Scanner scanner) {
    	if (response == 'y' || response == 'Y') {
			return true;
		} else if (response == 'n' || response == 'N') {			
			scanner.close();
			return false;			
		} else {
			System.out.println("Please choose between Y (continue)  or N (quit)");
			return playNextGame(scanner.next().charAt(0),scanner);
		}
    }
}
