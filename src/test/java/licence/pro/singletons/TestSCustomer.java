package licence.pro.singletons;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import licence.pro.models.Customer;

public class TestSCustomer {

	private Customer customer;
	
	@Before
	public void setUp() {
		customer = SCustomer.getInstance();
	}
	
	@Test 
	public void TestSCustomer_notNull() {
		assertNotNull(customer);
	}
	
	@Test 
	public void TestSCustomer_isInstanceOfCustomer() {
		assertTrue(customer instanceof Customer);
	}
	
	@Test 
	public void TestSCustomer_produceSameObject() {
		Customer customerTest = SCustomer.getInstance();
		assertSame(customer, customerTest);
	}
	
}
