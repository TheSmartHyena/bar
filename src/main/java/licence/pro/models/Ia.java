package licence.pro.models;

import licence.pro.singletons.SBar;
import licence.pro.singletons.SBeerStock;
import licence.pro.singletons.SWaiters;

public class Ia implements Runnable {
	
	private static final int IA_TICK = 20;
	private boolean waitersKilled = false;
	
	public  void run() {
		try {
			while (true) {
				// One tick equals 200ms
				Thread.sleep(IA_TICK);
				//System.out.println("Ia Tick, can do anything there");
				
				// New custommer incomming
				
				// Put some random disaster
				
				// If no more available beer, terminate all waiter thread
				if(SBeerStock.getInstance().isOutOfOrder() && !this.waitersKilled) {				
					 for (int i =  0 ; i < SWaiters.getInstance().length ; i++) {
						 SWaiters.getInstance()[i].interrupt();
						 // System.out.println(SWaiters.getInstance()[i].isInterrupted());
						 
						 System.out.println("Killed waiter thread");
					 }
					 waitersKilled = true;
				}
				
				// TEST
				// System.out.println("Beer available:" + SBeerStock.getInstance().getAvailableBeer());
				// System.out.println("Beer poured:" + SBar.getInstance().getNbPeerPouredNotTook());
				
			}
         
		}  catch (InterruptedException e) {
			// System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
			System.out.println("Bar is closing due to error");
		}
	}
}
