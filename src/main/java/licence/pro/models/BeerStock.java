package licence.pro.models;

public class BeerStock {
	
	private int availableBeer;
	
	public BeerStock(int initialAmount) {
		this.availableBeer = initialAmount;
	}
	
	private boolean canDoPopBeers(int amount) {
		return amount <= this.availableBeer;
	} 
	
	// pop = remove one element
	public void popBeers(int amount) {
		if(this.canDoPopBeers(amount)) 
			this.availableBeer -= amount;		
	}
	
	public void addBeers(int amount) {
		this.availableBeer += amount;
	}
	
	public boolean isOutOfOrder() {
		return !this.canDoPopBeers(1);
	}
		
	public int getAvailableBeer() {
		return this.availableBeer;
	}
}
