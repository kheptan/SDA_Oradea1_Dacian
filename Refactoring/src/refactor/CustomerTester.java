package refactor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTester {
	@Test
	void testOk() {
		Customer customer = new Customer("Even");
		Movie release  = new Movie("Movie_1", Movie.NEW_RELEASE);
		Movie children  = new Movie("Movie_1", Movie.CHILDRENS);
		Movie regular = new Movie("Movie_1", Movie.REGULAR);
		
		Rental kidRental = new Rental(release, 2);
		Rental regularRental = new Rental(regular,8);
		Rental releaseRental = new Rental(release,4);
		
		
		customer.addRental(kidRental);
		customer.addRental(regularRental);
		customer.addRental(releaseRental);
		
		String x = customer.statement();
		
		assertEquals("Rental Record for Even\n" + 
				"	Movie_1	6.0\n" + 
				"	Movie_1	11.0\n" + 
				"	Movie_1	12.0\n" + 
				"Amount owed is 29.0\n" + 
				"You earned 5 frequent renter points",x);
		
	}
}
