package i_thread;

public class NotifyB extends Thread{
	WorkObject obj;
	NotifyB(WorkObject obj){
		this.obj = obj;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			obj.methodB();
		}
	}
}
