package licence.pro.models;

import licence.pro.singletons.SBar;

public class Customer implements Runnable {
	
	private static final int CUSTOMER_TICK = 100;
	
    public void run() {

        try {
           while (true) {
              // nos mangeurs mangent de façon aléatoire...
             Thread.sleep(CUSTOMER_TICK) ;
             
             /*if(SBar.getInstance().getNbPeerPouredNotTook() > 0) {
            	 SBar.getInstance().takeBeer();
            	 System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] glou glou");
             }else {
            	 System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] j'ai soif");
             }*/
             
             Beer beer = SBar.getInstance().takeBeer();
             if(beer != null) {            	 
            	 System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] glou glou");
             }else {
            	 System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] j'ai soif");
             }
             	             
              /*if (beer != null) {
                System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] glou glou");
                                    
             }  else {
                System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + SBar.getInstance().getNbPeerPouredNotTook() +  "] j'ai soif");
                                    
             }*/
          }

       }  catch (InterruptedException e) {
          System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
       }
    }
	
}
