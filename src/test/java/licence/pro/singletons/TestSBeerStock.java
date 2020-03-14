package licence.pro.singletons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import licence.pro.models.BeerStock;

//import licence.pro.singletons.*;

public class TestSBeerStock {
	
	private BeerStock beerStock;

	@Before
	public void setUp() {
		beerStock = SBeerStock.getInstance();
	}
	
	@Test
	public void testSBeerStock_notNull() {
		assertNotNull(beerStock); 
	}
	
	@Test
	public void testSBeerStock_shouldReturnBeerStockInstance() {
		assertTrue(beerStock instanceof BeerStock);
	}
	
	@Test
	public void testSBeerStock_shouldReturnWaiterOnlyOneInstance() {
		BeerStock beerStockTest = SBeerStock.getInstance();
		assertSame(beerStock, beerStockTest);
	}
	
}
