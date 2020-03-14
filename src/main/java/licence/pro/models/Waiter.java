package licence.pro.models;

import licence.pro.constants.ProjectConstants;
import licence.pro.factories.FBeer;
import licence.pro.singletons.SBar;
import licence.pro.singletons.SBeerStock;

public class Waiter implements Runnable {
	
	public Waiter() {

	}
	
	public  void run() {

		try {
			while (!Thread.currentThread().isInterrupted()) {

				// Every tick, a waiter poor a beer
				Thread.sleep(ProjectConstants.WAITER_TICK) ;
				if ( SBeerStock.getInstance().getAvailableBeer() < 1 ) {
					// System.out.println("[" + Thread.currentThread().getName() +  "]" + " Out of order.");
					// Thread.currentThread().interrupt();
					continue;
				}
										
				if (SBar.getInstance().addBeer( FBeer.getBeer() )) {
					System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] Poored a beer.");
				}  else {
					System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] Cannot poor more beers.");
                           
				}
			}
	      }  catch (InterruptedException e) {
	         System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
	      }
	   }
	
}
