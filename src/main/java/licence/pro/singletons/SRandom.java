package licence.pro.singletons;

import java.util.Random;

public class SRandom {
	private static Random random;
	public static Random getInstance() {
		if (random == null)
			random = new Random();
		return random;
	}
}
