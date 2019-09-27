package refactor;

import java.util.Iterator;

public class CustomerStatement {
	
	void printStatement(Customer customer) {
		PrintStatement printStatement = new PrintStatement();
		Iterator<Rental> iterator = customer.getRentals().iterator();
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		printStatement.printHeader(customer.getName());
		
		while (iterator.hasNext()) {
			double thisAmount = 0;
			Rental each = iterator.next();
			//determine amounts for each line
			thisAmount = each.amountFor();
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& 	each.getDaysRented() > 1) frequentRenterPoints ++;
			
			printStatement.addBody(each.getMovie().getTitle(), thisAmount);
			
			totalAmount += thisAmount;
		}
		
        printStatement.printFooter(totalAmount, frequentRenterPoints);
	}

}