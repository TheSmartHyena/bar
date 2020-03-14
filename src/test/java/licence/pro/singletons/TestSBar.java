package licence.pro.singletons;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import licence.pro.models.Bar;

public class TestSBar {
	
	private Bar bar;
	
	@Before
	public void setup() {
		bar = SBar.getInstance();
	}
	
	@Test
	public void TestSBar_notNull(){
		assertNotNull(bar);
	}
	
	@Test
	public void TestSBar_isInstanceOfBar(){
		assertTrue(bar instanceof Bar);
	}
	
	@Test
	public void TestSBar_produceSameObject(){
		Bar barTest = SBar.getInstance();
		assertSame(bar, barTest);
	}
	
}
