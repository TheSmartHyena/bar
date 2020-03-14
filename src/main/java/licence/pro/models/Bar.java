package licence.pro.models;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import licence.pro.singletons.SBeerStock;

public class Bar {
	
	private BeerStock beerStock = SBeerStock.getInstance();
	private Object key =  new Object() ;
	
    // The bar can make available a maximum of 20 beer
    private BlockingQueue<Beer> queue =  new ArrayBlockingQueue<Beer>(20) ;
    
    // SBeerStock.getInstance()
    
    // Waiter add a beer
    public synchronized boolean addBeer(Beer beer)  throws InterruptedException {
    	synchronized(key) {
	    	boolean result = queue.offer(beer,  200, TimeUnit.MILLISECONDS);
	    	if (result)
				SBeerStock.getInstance().popBeers(1);
	    	return result;
    	}
    }
    
    // Customer get a beer
    public synchronized Beer takeBeer ()  throws InterruptedException {
    	synchronized(key) {
    		return queue.poll(200, TimeUnit.MILLISECONDS) ;
    	}
    }
    
    // How much beer can be taken by customers
    public  int getNbPeerPouredNotTook() {
       return queue.size() ;
   }

}
