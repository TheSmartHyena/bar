package licence.pro.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import licence.pro.singletons.SBeerStock;

public class TestBeerStock {
	
	private BeerStock instance;

	@Before
	public void setUp() {
		instance = new BeerStock(50);
	}
	
	@Test
	public void testBeerStock_shouldBe50avaibleBeer() {
		assertEquals(instance.getAvailableBeer(), 50);
	}
	
	@Test
	public void testBeerStock_popBeerShouldBe49After() {
		instance.popBeers(1);
		assertEquals(49, instance.getAvailableBeer());
	}
	
	@Test
	public void testBeerStock_popBeerShouldBe40After() {
		instance.popBeers(10);
		assertEquals(40, instance.getAvailableBeer());
	}
	
	@Test
	public void testBeerStock_popMoreThanAvaibleShouldntChangeAvaibleNumber() {
		instance.popBeers(51);
		assertEquals(50, instance.getAvailableBeer());
	}
	
	@Test
	public void testBeerStock_addBeerShouldBe51After() {
		instance.addBeers(1);
		assertEquals(51, instance.getAvailableBeer());
	}
	
	@Test
	public void testBeerStock_addBeerShouldBe60After() {
		instance.addBeers(10);
		assertEquals(60, instance.getAvailableBeer());
	}
	
}
