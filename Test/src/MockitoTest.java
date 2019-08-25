import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

	@Test
	public void mockTest() {
		Calculator calc = mock(Calculator.class);
		when(calc.add(10, 1)).thenReturn(1001);

		assertEquals(1001, calc.add(10, 1));
	}

}
