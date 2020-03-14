package licence.pro.singletons;

public class SWaiters {
	
	// Named A, in case of if we want to add more waiter
	private static Thread[] instance = null;
	private static final int NB_WAITERS = 2;
	
	public static Thread[] getInstance() {
		if(instance == null) {
			instance = new Thread[NB_WAITERS];
			for (int i=0; i<NB_WAITERS; i++) {
				instance[i] = new Thread();
			}
		}
		return instance;
	}
}
