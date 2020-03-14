package licence.pro.singletons;

import licence.pro.models.Waiter;

public class SWaiter {
	
	// Named A, in case of if we want to add more waiter
	private static Waiter instanceA = null;
	
	public static Waiter getInstanceA() {
		if(instanceA == null) {
			instanceA = new Waiter("Bob");
		}
		return instanceA;
	}
}
