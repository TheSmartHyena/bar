package licence.pro.singletons;

import licence.pro.constants.ProjectConstants;

public class SCustomers {	
	private static Thread[] instance = null;	
	public static Thread[] getInstance() {
		if (instance == null) {
			instance = new Thread[ProjectConstants.NB_CUSTOMERS];
			for (int i=0; i<ProjectConstants.NB_CUSTOMERS; i++) 
				instance[i] = new Thread(SCustomer.getInstance());			
		}
		return instance;
	}
}
