package licence.pro.models;

public class BeerStock {
	
	private int availableBeer;
	
	public BeerStock(int initialAmount) {
		this.availableBeer = initialAmount;
	}
	
	/* @return {boolean} if it's possible to poor the amount of beer asked. */
	private boolean canDoPopBeers(int amount) {
		return amount <= this.availableBeer;
	} 
	
	/* Decreases the amount of available beers by the number in param. */
	public void popBeers(int amount) {
		if(this.canDoPopBeers(amount)) 
			this.availableBeer -= amount;		
	}
	
	/* Increase the amount of available beers by the number in param. */
	public void addBeers(int amount) {
		this.availableBeer += amount;
	}
	
	/* @return {boolean} if the amount of available beers is 0. */
	public boolean isOutOfOrder() {
		return !this.canDoPopBeers(1);
	}
	
	/* @return {int} the amount of available beers. */
	public int getAvailableBeer() {
		return this.availableBeer;
	}
}
