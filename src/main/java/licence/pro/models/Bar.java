package licence.pro.models;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import licence.pro.singletons.SBeerStock;

public class Bar {
	
	// Required for synchronized code execution
	private Object key = new Object();
	
    // The bar can make available a maximum of 20 beers at a time
    private BlockingQueue<Beer> queue =  new ArrayBlockingQueue<Beer>(20);
        
    /* @return {boolean} if a beer was added to the queue. */
    public synchronized boolean addBeer(Beer beer) throws InterruptedException {
    	synchronized(key) {
	    	boolean result = queue.offer(beer,  200, TimeUnit.MILLISECONDS);
	    	if (result)
				SBeerStock.getInstance().popBeers(1);
	    	return result;
    	}
    }
    
    /* @return {Beer} take a beer from the queue. */
    public synchronized Beer takeBeer () throws InterruptedException {
    	synchronized(key) {
    		return queue.poll(200, TimeUnit.MILLISECONDS) ;
    	}
    }
    
    /* @return {int} amout of beers in the queue. */
    public  int getNbPeerPouredNotTook() {
       return queue.size() ;
   }

}
