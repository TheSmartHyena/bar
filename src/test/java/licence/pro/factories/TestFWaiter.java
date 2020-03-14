package licence.pro.factories;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import licence.pro.models.Waiter;

public class TestFWaiter {
	
	private Waiter waiter;
	
	@Before
	public void setUp() {
		waiter = FWaiter.getWaiter();
	}
	
	@Test
	public void waiter() {
		assertNotNull(waiter);
	}
	
	@Test
	public void testFWaiter_isInstanceOfWaiter() {
		assertTrue(waiter instanceof Waiter);
	}
	
	
}
