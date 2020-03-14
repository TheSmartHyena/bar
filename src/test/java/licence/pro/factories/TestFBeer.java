package licence.pro.factories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import licence.pro.models.Beer;

public class TestFBeer {
	
	private Beer beer;
	
	@Before
	public void setUp() {
		beer = FBeer.getBeer();
	}
	
	@Test
	public void TestFBeer_notNull() {
		assertNotNull(beer);
	}
	
	@Test
	public void TestFBeer_isInstanceBeer() {
		assertTrue(beer instanceof Beer);
	}

}
