package licence.pro.singletons;

import licence.pro.models.Waiter;

public class SWaiter {
	
	// Named A, in case of if we want to add more waiter
	private static Waiter instance = null;
	
	public static Waiter getInstance() {
		if(instance == null) {
			instance = new Waiter();
		}
		return instance;
	}
}
