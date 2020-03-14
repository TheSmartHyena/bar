package licence.pro.factories;

import org.junit.Test;
import static org.junit.Assert.*;

import licence.pro.models.Beer;

public class TestFBeer {
	
	@Test
	public void TestFBeer_notNull() {
		assertNotNull(FBeer.getBeer());
	}
	
	@Test
	public void TestFBeer_isInstanceBeer() {
		assertTrue(FBeer.getBeer() instanceof Beer);
	}

}
