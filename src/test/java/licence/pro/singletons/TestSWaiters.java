package licence.pro.singletons;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSWaiters {
	
	private Thread[] waiters;
	
	@Before
	public void setUp() {
		waiters = SWaiters.getInstance();
	}
	
	@Test
	public void TestSWaiters_notNull(){
		assertNotNull(waiters);
	}
	
	@Test
	public void TestSWaiters_isInstanceOf(){
		assertTrue(waiters instanceof Thread[]);
	}
	
	@Test
	public void TestSWaiters_produceSameObject(){
		Thread[] waitersTest = SWaiters.getInstance();
		assertSame(waiters, waitersTest);
	}
	
}
