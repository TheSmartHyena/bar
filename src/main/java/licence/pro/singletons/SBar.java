package licence.pro.singletons;

import licence.pro.models.Bar;

public class SBar {
	private static Bar instance = null;
	public static Bar getInstance() {
		if (instance == null) 
			instance = new Bar();	
		return instance;
	}
}
