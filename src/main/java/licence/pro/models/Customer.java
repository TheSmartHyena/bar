package licence.pro.models;

import licence.pro.singletons.SBar;

public class Customer implements Runnable {
	
	private static final int CUSTOMER_TICK = 100;
	
    public void run() {

        try {
           while (!Thread.currentThread().isInterrupted()) {
             Thread.sleep(CUSTOMER_TICK) ;
                    
             Beer beer = SBar.getInstance().takeBeer();
             if(beer != null) {            	 
            	 System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] sip sip");
             }else {
            	 System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] I'm thirsty");
             }             	            
          }

       }  catch (InterruptedException e) {
          System.out.println("[" + Thread.currentThread().getName() +  "] I'm stopping") ;
       }
    }
	
}
