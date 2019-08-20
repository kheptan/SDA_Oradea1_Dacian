import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameController {
	private static final int MAXIM = 2;
	private static final int MINIM = 0;
	private static final int RANGE = 1;    
        private int counter = 0;
	private int[][] results;
	private boolean isFirstPlayer = false;	
	private boolean winner = false;	
	private int winnerValue=0;
	private Player player1;
	private Player player2;
	
	private void initScoreTable() {
		if (results == null) {
			results = new int[3][3];
		}
	}
	public void resetGame() {
		player1 = null;
		player2 = null;
		winner = false;
		winnerValue = 0;
		counter = 0;
		isFirstPlayer = false;		
		results = null;
		Util.setScanner(null);
	}
	
	//Initialise two players and set name for each
	public void createPlayers(Scanner sc) {
		if (player1 == null) {
		     player1 = new Player(setPlayerName(sc));
		} 
		if (player2 == null) {
			player2 = new Player(setPlayerName(sc));
		}		
	}
	//set a player name
	private String setPlayerName(Scanner sc) {
		System.out.println("Enter Player name : ");
		return sc.nextLine();
	}
        //entry point in game
	public void playGame(Scanner scanner) {
		initScoreTable();
		setPlayers(player1, player2, scanner);
	}
        //check if a first player exist, if not generate randomly first player
	//continue with reading each player entries
	private void setPlayers(Player p1, Player p2, Scanner scanner) {
		if (!isFirstPlayer ) setFirstPlayer(randomPlayers(p1, p2));
		readPlayerEntries(p1, p2, scanner);		
	}
	//read entries for each player
	private void readPlayerEntries(Player player1, Player player2, Scanner scanner) {
		read(player1, player2, scanner);
	}
	//read coordinates in player order
	private void read(Player player1,Player player2, Scanner scanner) {
		if (firstPlayer(player1)) {
			startReading(player1, scanner);
			startReading(player2, scanner);
		}else {
			startReading(player2, scanner);
			startReading(player1, scanner);
		}
	}
	//check if player is firts player
	private boolean firstPlayer(Player p) {
		if (p.isFirst())  { 
			return true;
		} else {
			return false;
		}
	}
	//return true if we have a winner
	private boolean checkWinner() {
		if (winnerWasFound()) {
			drawGameResults();
			setWinner(true);
			return true;
		} else {
			return false;
		}
	}
	//before reading a player entry check if there is a winning line	
	private void startReading(Player player,Scanner scanner) {
		if(checkWinner()) {
			 System.out.println("We have a winner : " + winnerName());		     
		} else if (player.isFirst() || (!player.isFirst() && counter < 8)) {
			readAndSetResult(player, scanner);
		}
	}
        //write each person entries in the game
	private void writeResults(Player p) {
		results[p.getX()][p.getY()] = p.getValue();
		counter= counter+1; // counter increased by 1 and not more than 9
	}
	
        //set person coordinates (X and Y)
	private Player readEntries(Player player , Scanner s) {
			System.out.println("X coordinate for player " + player.getName() + " :");
			try { 
				player.setX(s.nextInt());
			    System.out.println("Y coordinate for player " + player.getName() + " :");
			    player.setY(s.nextInt());
			    return player;
			} catch (Exception e) {
				System.out.println("\n Oooo thats a nasty crack!!! - Please enter only numbers \n");
			}
			return null;
	}
        //validate each player entries
	private void readAndSetResult(Player player, Scanner scanner) {
		if (validateEntries(player, scanner)) {
			setPlayerValues(player);
			writeResults(player);
		}
	}
	//check for duplicates and validate coordinates
	private boolean validateEntries(Player player,Scanner scanner)  {
		if (checkPlayerCoordinates(readEntries(player, scanner))) {
				return validateEntries(player, scanner);
		}
		if (findDuplicates(player)){
			System.out.println("There is already an entry with this coordinates\n"
					+ "Please enter new coordinates!!");
			return validateEntries(player, scanner);
		} else {
			return true;
		}		
	}
	//each coordinate should be between 0 and 2
	private boolean checkPlayerCoordinates(Player player) {
		if (player.getX() <0 || player.getX() >2) {
			System.out.println("Set X to be a number between 0 and 2");
			return true;
		} else if (player.getY() <0 || player.getY() > 2) {
			System.out.println("Set Y to be a number between 0 and 2");
			return true;
		} else {
			return false;
		}
	}
	//check for duplicate coordinate
        private boolean findDuplicates(Player player) {
		boolean duplicate = false;		
		for (int i=0; i<3;i++) {
			for (int j=0; j<3;j++) {
				if (results[player.getX()][player.getY()]!=0) {
					duplicate =  true;
				} 
			}
		}
		return duplicate;
	}
	
	//set person value field (10 or 100)
	private void setPlayerValues(Player p) {
		if (p.isFirst()) {
			p.setValue(10);
		} else {
			p.setValue(100);
		}
	}
	
	//set person field isFirts to true
	private void setFirstPlayer(Player p) {
		p.setFirst(true);
		isFirstPlayer = true;
	}
	
	//generate random number between 0-2 and return it
	private Player randomPlayers(Player p1, Player p2) {
		Player[] arr = new Player[] { p1, p2 }; 
		return arr[randomNumber()];
	}
	
	//get a scanner
	public Scanner getScanner() {
		return Util.getScanner();
	}
	
	public int[][] getResult() {
		return results;
	}
	
	public boolean winnerWasFound() {
		if (findWinner()) {
				return true;
		} else {
			return false;
		}
	}
	
	private boolean findWinner() {
         return (checkVertical(results) ||
        		 checkLinear(results) ||
        		 checkDiagonal(results) ||
        		 checkInverseDiagonal(results));
	}
	
	public boolean isWinner() {
		return winner;
	}
	
        public void setWinner(boolean winner) {
		this.winner = winner;
	}
        //check if we have a win on diagolan
        private boolean checkDiagonal(int[][] results) {
		int lineTotalValue = 0;
		
		for (int i=0; i<3; i++) {
			lineTotalValue = lineTotalValue + results[i][i];
		}		
		return winnerFound(lineTotalValue);			
	}
  
	private boolean checkInverseDiagonal(int[][] results) {
		int lineTotalValue = 0;
		
		for (int i=0; i<3; i++) {
			lineTotalValue = lineTotalValue + results[i][2-i];
		}		
		return winnerFound(lineTotalValue);			
	}
	//check if we have a win on a vertical line	
	private boolean checkVertical(int[][] results) {
		boolean winner = false;
		int lineTotalValue = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				lineTotalValue = lineTotalValue + results[j][i];
			}       	 
			if(winnerFound(lineTotalValue)) {
				winner = true;
				break;
			} else {
				lineTotalValue = 0;
			}
        }        
		return winner;
		
	}
	//check if we have a win on a plane line
	private boolean checkLinear(int[][] results) {
		boolean winner = false;
		int lineTotalValue = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				lineTotalValue = lineTotalValue + results[i][j];
			}       	 
			if(winnerFound(lineTotalValue)) {
				winner = true;
				break;
			} else {
				lineTotalValue = 0;
			}
        }        
		return winner;
	}
	
	private boolean winnerFound(int total) {
		if (total == 30 || total == 300) {
      		 setWinnerValue(total / 3); 
      		 return true;
      	 } else {
      		 return false;
      	 }
	}
	
	private void setWinnerValue(int value) {
		winnerValue = value;		
	}
	//draw the game
	public void drawGameResults() {
		char bar = '|';
		char codeChar = ' ';
		for (int i = 0; i<3; i++) {
			System.out.println("");
			for (int j=0; j <3; j++) {
				codeChar = drawChar(results[i][j]);
				String formated = String.format("%5c %5c", codeChar,bar);
				System.out.print(formated);
				if(j==2) System.out.print("\r");
			}			
			System.out.print("\n");			
			System.out.println("");
		}
	}
	//draw X and O on screen
	private char drawChar(int value) {
		char charCode = ' ';		
		switch(value) {
			case 10 :
				charCode = 'X';
				break;
			case 100 : 
				charCode = 'O';
				break;
		}
		return charCode;
	}
	
	public int getCounter() {
		return counter;
	}
	
	private int randomNumber() {
	    Random rd = new Random();
	    return rd.ints(RANGE,MINIM,MAXIM).findFirst().getAsInt();
	}
	
	private String winnerName() {
		player1.getValue();
		if (player1.getValue() == getWinnerValue()) {
			return player1.getName();
		} else {
			return player2.getName();
		}
	}

	private int getWinnerValue() {
		// TODO Auto-generated method stub
		return winnerValue;
	}
	
}
