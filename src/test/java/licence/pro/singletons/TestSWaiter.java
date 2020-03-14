package licence.pro.singletons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import licence.pro.models.Waiter;

//import licence.pro.singletons.*;

public class TestSWaiter {
	
	private Waiter waiterA;

	@Before
	public void setUp() {
		waiterA = SWaiter.getInstanceA();
	}
	
	@Test
	public void testSWaiterA_notNull() {
		assertNotNull(waiterA); 
	}
	
	@Test
	public void testSWaiterA_shouldReturnWaiterInstance() {
		assertTrue(waiterA instanceof Waiter);
	}
	
	@Test
	public void testSWaiterA_shouldReturnWaiterOnlyOneInstance() {
		Waiter waiterTest = SWaiter.getInstanceA();
		assertSame(waiterA, waiterTest);
	}
	
	@Test
	public void testSWaiterA_shouldBeNamedBob() {
		assertEquals(waiterA.getName(), "Bob");
	}
	
}
