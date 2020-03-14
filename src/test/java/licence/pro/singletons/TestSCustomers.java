package licence.pro.singletons;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSCustomers {

	private Thread[] customers;
	
	@Before
	public void setUp() {
		customers = SCustomers.getInstance();
	}
	
	@Test 
	public void TestSCustomers_notNull() {
		assertNotNull(customers);
	}
	
	@Test 
	public void TestSCustomers_isInstanceOfCustomer() {
		assertTrue(customers instanceof Thread[]);
	}
	
	@Test 
	public void TestSCustomers_produceSameObject() {
		Thread[] customersTest = SCustomers.getInstance();
		assertSame(customers, customersTest);
	}
	
}
