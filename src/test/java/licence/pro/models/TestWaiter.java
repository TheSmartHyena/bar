package licence.pro.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TestWaiter {
	
	private Waiter instance;

	@Before
	public void setUp() {
		instance = new Waiter("Bob");
	}
	
	@Test
	public void testWaiter_nameNotNull() {
		assertNotNull(instance.getName());
	}
	
	@Test
	public void testWaiter_nameShouldBeBob() {
		assertEquals("Bob", instance.getName());
	}
	
	
	
	
}
