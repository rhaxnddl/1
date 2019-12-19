// 2019.12.19
package i_thread;

public class YieldA extends Thread{
	boolean stop = false;
	boolean work = true;
	public void run() {
		while(!stop) {
			if(work){
			System.out.println("YieldA...");
		} else {
			yield();
	    	}// if
		} // while
		System.out.println("YieldA Á¾·á...");
	}
}
