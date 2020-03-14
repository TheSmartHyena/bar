package licence.pro.models;

import licence.pro.constants.ProjectConstants;
import licence.pro.singletons.SBar;

public class Customer implements Runnable {	
	public void run() {
        try {
        	while (!Thread.currentThread().isInterrupted()) {        		   		
        		Thread.sleep(ProjectConstants.TICK_CUSTOMER);    
        		
        		// Every tick, the customer will try to take a beer from the queue     
        		Beer beer = SBar.getInstance().takeBeer();
        		if (beer != null) {            	 
        			System.out.println("[" + Thread.currentThread().getName() + "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] sip sip.");
        		}else {
        			System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] I'm thirsty.");
        		}             	            
           }
       } catch (InterruptedException e) {
    	   System.out.println("[" + Thread.currentThread().getName() +  "] No more beer to drink, i'm stopping") ;
       }
    }	
}