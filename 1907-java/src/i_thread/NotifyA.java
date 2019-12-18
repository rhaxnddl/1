package i_thread;

public class NotifyA extends Thread{
	WorkObject obj;
	
	NotifyA(WorkObject obj){
		this.obj = obj;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			obj.methodA();
		}
	}
}
