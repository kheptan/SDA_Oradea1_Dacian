import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestUnit {
	private final static int MAXVALUE = 2147483647;
	private final static int MINVALUE = -2147483648;

	Calculator calc;

	@Parameters
	public static Collection<Integer[]> params() {
		return Arrays.asList(new Integer[][] { { 2, 2, 0 }, { 4, 2, 2 }, { 10, 2, 8 } });
	}

	@Parameter(0)
	public int arg0;

	@Parameter(1)
	public int arg1;

	@Parameter(2)
	public int expected;

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
		assertEquals(expected, calc.sub(arg0, arg1));
	}

	/**
	 * @Test(expected = ArithmeticException.class) public void testAddEntry() {
	 *                calc.addWithExcep(MAXVALUE, MINVALUE); }
	 *
	 * 
	 * @Test public void testOtherSum() { assertTrue("Dang..broken code!",
	 *       calc.addWithExcep(MAXVALUE, 100) == 0); }
	 */

	@Before
	public void init() {
		System.out.println("init calculator");
		calc = new Calculator();
	}

	@After
	public void destroy() {
		System.out.println("destroy");
	}

	@BeforeClass
	public static void initBeforeClass() {
		System.out.println("init static");

	}

	@AfterClass
	public static void destroyAfterClass() {
		System.out.println("destroy static");
	}


}
