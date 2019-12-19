// 2019.12.19
package i_thread;

public class YieldB extends Thread{
	boolean stop = false;
	boolean work = true;
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("YieldB...");
			} else {
				yield();
			} // if
		} // while
		System.out.println("YieldB Á¾·á...");
	}
}
