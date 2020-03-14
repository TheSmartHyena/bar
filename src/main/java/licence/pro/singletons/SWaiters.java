package licence.pro.singletons;

import licence.pro.constants.ProjectConstants;

public class SWaiters {
	private static Thread[] instance = null;
	public static Thread[] getInstance() {
		if (instance == null) {
			instance = new Thread[ProjectConstants.NB_WAITERS];
			for (int i=0; i<ProjectConstants.NB_WAITERS; i++)
				instance[i] = new Thread(SWaiter.getInstance());			
		}
		return instance;
	}
}
