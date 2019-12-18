package i_thread;

public class NotifyExam {

	public static void main(String[] args) {
		WorkObject obj = new WorkObject();
		
		NotifyA t1 = new NotifyA(obj);
		NotifyB t2 = new NotifyB(obj);
		
		t1.start();
		t2.start();
		
//			try{
//			Thread.notifyAll();
//		}catch(Exception ex) { }
	}
}
