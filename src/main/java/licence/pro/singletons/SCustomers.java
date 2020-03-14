package licence.pro.singletons;

import licence.pro.constants.ProjectConstants;

public class SCustomers {
	
	// Named A, in case of if we want to add more waiter
	private static Thread[] instance = null;
	
	public static Thread[] getInstance() {
		if(instance == null) {
			instance = new Thread[ProjectConstants.NB_CUSTOMERS];
			for (int i=0; i<ProjectConstants.NB_CUSTOMERS; i++) 
				instance[i] = new Thread(SCustomer.getInstance());			
		}
		return instance;
	}
}
