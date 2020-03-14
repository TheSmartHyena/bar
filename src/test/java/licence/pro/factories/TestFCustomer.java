package licence.pro.factories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import licence.pro.models.Customer;

public class TestFCustomer {
	
	private Customer customer;
	
	@Before
	public void setUp() {
		customer = FCustomer.getCustomer();
	}
	
	@Test
	public void TestFCustomer_notNull() {		
		assertNotNull(customer);
	}
	
	@Test
	public void TestFCustomer_isInstanceOfCustomer() {
		assertTrue(customer instanceof Customer);
	}
	
}
