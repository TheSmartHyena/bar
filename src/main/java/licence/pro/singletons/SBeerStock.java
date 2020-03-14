package licence.pro.singletons;

import licence.pro.models.BeerStock;

public class SBeerStock {
	private static BeerStock instance = null;
	public static BeerStock getInstance() {
		if (instance == null) 
			instance = new BeerStock(50);		
		return instance;
	}
}
