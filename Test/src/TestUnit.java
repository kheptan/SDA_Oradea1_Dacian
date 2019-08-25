import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUnit {
	private final static int MAXVALUE = 2147483647;
	private final static int MINVALUE = -2147483648;

	Calculator calc;

	public TestUnit() {
		calc = new Calculator();
	}

	@Test
	public void addition() {
		assertEquals(-1, calc.add(MAXVALUE, MINVALUE));
	}

	@Test
	public void sub() {
		// DEBUG
		assertEquals(0, calc.sub(10, 10));
	}

	/**
	 * @Test(expected = ArithmeticException.class) public void testAddEntry() {
	 *                calc.addWithExcep(MAXVALUE, MINVALUE); }
	 */

	@Test
	public void testOtherSum() {
		assertTrue("Dang..broken code!", calc.addWithExcep(1, MAXVALUE) == -1);
	}

}
