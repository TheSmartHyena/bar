package licence.pro.models;

import licence.pro.factories.FBeer;
import licence.pro.singletons.SBar;

public class Waiter implements Runnable {
	
	private static final int WAITER_TICK = 100;
	private String name;
	
	public Waiter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public  void run() {

		try {
			while (true) {

				// Every tick, a waiter poor a beer
				Thread.sleep(WAITER_TICK) ;
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
