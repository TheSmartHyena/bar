package licence.pro.singletons;

public class SCustomers {
	
	// Named A, in case of if we want to add more waiter
	private static Thread[] instance = null;
	private static final int NB_CUSTOMERS = 3;
	
	public static Thread[] getInstance() {
		if(instance == null) {
			instance = new Thread[NB_CUSTOMERS];
			for (int i=0; i<NB_CUSTOMERS; i++) {
				instance[i] = new Thread(SCustomer.getInstance());
			}
		}
		return instance;
	}
}
