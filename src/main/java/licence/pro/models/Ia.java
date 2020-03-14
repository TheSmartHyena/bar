package licence.pro.models;

import licence.pro.singletons.SBeerStock;

public class Ia implements Runnable {
	
	private static final int IA_TICK = 200;
	
	public  void run() {
		try {
			while (true) {
				// One tick equals 200ms
				Thread.sleep(IA_TICK);
				//System.out.println("Ia Tick, can do anything there");
				
				// New custommer incomming
				
				// Put some random disaster
				
				// If no more available beer, closes the bar
				if(SBeerStock.getInstance().isOutOfOrder()) {
					// Kills Every Thing
				}
				
				// TEST
				System.out.println("Beer available:" + SBeerStock.getInstance().getAvailableBeer());
				
			}
         

		}  catch (InterruptedException e) {
			// System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
			System.out.println("Bar is closing due to error");
		}
	}
}
