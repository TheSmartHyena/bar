package licence.pro.models;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import licence.pro.singletons.SBeerStock;

public class Bar {
	
	private BeerStock beerStock = SBeerStock.getInstance();
	
    // The bar can make available a maximum of 20 beer
    private BlockingQueue<Beer> queue =  new ArrayBlockingQueue<Beer>(20) ;
    
    // SBeerStock.getInstance()
    
    // Waiter add a beer
    public boolean  addBeer(Beer beer)  throws InterruptedException {
    	boolean result = queue.offer(beer,  200, TimeUnit.MILLISECONDS);
    	if (result)
			SBeerStock.getInstance().popBeers(1);
    	return result;
    }
    
    // Customer get a beer
    public Beer takeBeer ()  throws InterruptedException {
       return queue.poll(200, TimeUnit.MILLISECONDS) ;
    }
    
    // How much beer can be taken by customers
    public  int getNbPeerPouredNotTook() {
       return queue.size() ;
   }

}
