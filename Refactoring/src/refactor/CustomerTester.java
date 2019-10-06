package refactor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTester {
	@Test
	void testOk() {
		Customer customer = new Customer("Even");
		Movie release  = new Movie("Movie_NewRelease", Movie.NEW_RELEASE);
		Movie children  = new Movie("Movie_Kids", Movie.CHILDRENS);
		Movie regular = new Movie("Movie_Regular", Movie.REGULAR);
		
		Rental kidRental = new Rental(release, 2);
		Rental regularRental = new Rental(regular,8);
		Rental releaseRental = new Rental(release,4);
		
		customer.addRental(kidRental);
		customer.addRental(regularRental);
		customer.addRental(releaseRental);
		
		CustomerStatement customerStatement = new CustomerStatement();
		customerStatement.printStatement(customer);
		
		assertNotNull("Not null object", customer.getRentals());
	}
}
