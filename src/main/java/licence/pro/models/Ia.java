package licence.pro.models;

import licence.pro.singletons.SBar;
import licence.pro.singletons.SBeerStock;
import licence.pro.singletons.SCustomers;
import licence.pro.singletons.SWaiters;

public class Ia implements Runnable {
	
	private static final int IA_TICK = 20;
	private boolean waitersKilled = false;
	private boolean customersKilled = false;
	
	public  void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				// One tick equals 200ms
				Thread.sleep(IA_TICK);
				//System.out.println("Ia Tick, can do anything there");
				
				// New custommer incomming
				
				// Put some random disaster

				
				// If no more available beer, terminate all waiter thread
				if(SBeerStock.getInstance().isOutOfOrder() && !this.waitersKilled) {				
					 for (int i =  0 ; i < SWaiters.getInstance().length ; i++) {
						 SWaiters.getInstance()[i].interrupt();
					 }
					 System.out.println("Killed waiters threads");
					 this.waitersKilled = true;
				}
				
				// if queue is empty and no more waiters
				if (waitersKilled && (SBar.getInstance().getNbPeerPouredNotTook() < 1) ) {
					for (int i =  0 ; i < SCustomers.getInstance().length ; i++) {
						SCustomers.getInstance()[i].interrupt();
					}
					System.out.println("Killed customers threads");
					this.customersKilled = true;
				}
				
				// If no customers or waiters, suicide of the ia
				if (customersKilled && waitersKilled) {		
					Thread.currentThread().interrupt();
					System.out.println("Bar is closed");
					
				}
				
				// If no more available beer, terminate all waiter thread
				
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
