package licence.pro.entrypoint;

import licence.pro.models.Customer;
import licence.pro.models.Ia;
import licence.pro.models.Waiter;
import licence.pro.singletons.SWaiter;

public class EntryPoint {

	public static void main(String[] args) {
		
	   Waiter waiter =  SWaiter.getInstanceA();
	   Customer customer =  new Customer();

	   Thread [] waiters =  new Thread[1] ;
	   Thread [] customers =  new Thread[2] ;
	   
	   // Setup and run IA
	   Ia ia = new Ia();
	   Thread iaThread = new Thread(ia);
	   iaThread.start();

	    // preparing waiters
	    for (int i =  0 ; i < waiters.length ; i++) {
	    	waiters[i] =  new Thread(waiter) ;
	   }

	    // preparing customers
	    for (int i =  0 ; i < customers.length ; i++) {
	    	customers[i] =  new Thread(customer) ;
	   }
	    
	 // lauching waiters threads
	    for (int i =  0 ; i < waiters.length ; i++) {
	    	waiters[i].start() ;
	   }
	    
	    // lauching customers threads
	    for (int i =  0 ; i < customers.length ; i++) {
	    	customers[i].start();
	   }
	    
	    

	}

}
