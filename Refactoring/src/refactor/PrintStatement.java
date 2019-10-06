package refactor;

import java.util.ArrayList;
import java.util.List;

public class PrintStatement {
	double totalAmount;
	int frequentRenterPoints;
	List<StatementBody> stateBody = new ArrayList<StatementBody>();
	
	public void printHeader(String title) {
		System.out.println("Rental Record for " + title + "\n");
	}
	
	public void addBody(String title, double amount) {
			stateBody.add(new StatementBody(title, amount));
	}
	
	public void printFooter(double totalAmount,int frequentRenterPoints) {
		for(StatementBody sb : stateBody) {
			System.out.println( "\t" + sb.getTitle() 
			                    + "\t" +sb.getAmount()+ "\n");
		}
		System.out.println("Amount owed is " 
	                        + totalAmount +"\n");
		System.out.println("You earned "
	                        + frequentRenterPoints
	                        +" frequent renter points");
	}
}
