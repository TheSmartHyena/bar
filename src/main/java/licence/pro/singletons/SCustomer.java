package licence.pro.singletons;

import licence.pro.models.Customer;

public class SCustomer {	
	private static Customer instance = null;	
	public static Customer getInstance() {
		if (instance == null) 
			instance = new Customer();		
		return instance;
	}
}
