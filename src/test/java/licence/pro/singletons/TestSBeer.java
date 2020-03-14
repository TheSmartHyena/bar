package licence.pro.singletons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import licence.pro.models.BeerStock;

//import licence.pro.singletons.*;

public class TestSBeer {
	
	private BeerStock instance;

	@Before
	public void setUp() {
		instance = SBeerStock.getInstance();
	}
	
	@Test
	public void testSBeerStock_notNull() {
		assertNotNull(instance); 
	}
	
	@Test
	public void testSBeerStock_shouldReturnBeerStockInstance() {
		assertTrue(instance instanceof BeerStock);
	}
	
	@Test
	public void testSBeerStock_shouldReturnWaiterOnlyOneInstance() {
		BeerStock beerStockTest = SBeerStock.getInstance();
		assertSame(instance, beerStockTest);
	}
	
}
