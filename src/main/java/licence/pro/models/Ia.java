package licence.pro.models;

import licence.pro.constants.ProjectConstants;
import licence.pro.singletons.SBar;
import licence.pro.singletons.SBeerStock;
import licence.pro.singletons.SCustomers;
import licence.pro.singletons.SRandom;
import licence.pro.singletons.SWaiters;

public class Ia implements Runnable {
	
	private static final int IA_TICK = 20;
	private boolean waitersKilled = false;
	private boolean customersKilled = false;
	
	public  void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {				
				Thread.sleep(IA_TICK);

				// Put some random disaster
				if (SRandom.getInstance().nextInt(ProjectConstants.CHANCES_OF_FIRE) == ProjectConstants.CHANCES_OF_FIRE -1)
					interupEverything();
					
				// If no more available beer, terminate all waiter thread
				if (SBeerStock.getInstance().isOutOfOrder() && !this.waitersKilled) {									 
					interupWaiters();					
				}
				
				// if queue is empty and no more waiters
				if (waitersKilled && (SBar.getInstance().getNbPeerPouredNotTook() < 1) ) {
					interupCustomers();
				}
				
				// If no customers or waiters, suicide of the ia
				if (customersKilled && waitersKilled) {		
					interupIa();		
				}				
			}         
		}  catch (InterruptedException e) {
			System.out.println("Bar is closing due to error");
		}
	}
	
	private void interupEverything() {
		System.out.println("Bar took fire, please evacuate in calm.");
		interupCustomers();
		interupWaiters();
		interupIa();
	}
	
	private void interupCustomers() {
		for (int i =  0 ; i < SCustomers.getInstance().length ; i++) 
			SCustomers.getInstance()[i].interrupt();
		
		System.out.println("Killed customers threads");
		this.customersKilled = true;
	}
	
	private void interupWaiters() {
		for (int i =  0 ; i < SWaiters.getInstance().length ; i++) 
			 SWaiters.getInstance()[i].interrupt();
		System.out.println("Killed waiters threads");
		this.waitersKilled = true;
	}
	
	private void interupIa() {
		Thread.currentThread().interrupt();
		System.out.println("Bar is closed");	
	}
}
