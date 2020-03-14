package licence.pro.entrypoint;

import licence.pro.models.Ia;
import licence.pro.singletons.SCustomers;
import licence.pro.singletons.SWaiters;

public class EntryPoint {

	public static void main(String[] args) {
		
		// Setup and start IA thread
		Ia ia = new Ia();
	   	Thread iaThread = new Thread(ia);
	   	iaThread.start();
	    
	   	// Start all waiters threads
	    for (int i =  0 ; i < SWaiters.getInstance().length ; i++) {
	    	System.out.println(i);
	    	SWaiters.getInstance()[i].start();	    	
	    	System.out.println(SWaiters.getInstance()[i].isInterrupted());
	    }
	    
	    // Start all Customers thread
	    for (int i =  0 ; i < SCustomers.getInstance().length ; i++) {
	    	System.out.println(i);
	    	SCustomers.getInstance()[i].start();	    	
	    	System.out.println(SCustomers.getInstance()[i].isInterrupted());
	    }
	    
	}
}
