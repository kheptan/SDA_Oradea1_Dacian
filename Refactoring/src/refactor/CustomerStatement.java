package refactor;

public class CustomerStatement {
	
	void printStatement(Customer customer) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		//Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + customer.getName() + "\n";
		
		while (customer.getRentals().iterator().hasNext()) {
			double thisAmount = 0;
			Rental each = customer.getRentals().iterator().next();
			//determine amounts for each line
			thisAmount = each.amountFor();
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& 	each.getDaysRented() > 1) frequentRenterPoints ++;
		    //show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(thisAmount) + "\n";
		    totalAmount += thisAmount;
		}

		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) +
		"\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
		+
		" frequent renter points";
		
	}
}