package i_thread;

public class PriorityExam {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			Thread t = new CalcThread("thread" + i);			
			
			if(i!=10) {
				t.setPriority(Thread.MIN_PRIORITY);  // t.setPriority(1);  이렇게 사용해도 (가장 작은 값을 넣어도) 가능
			} else {
				t.setPriority(Thread.MAX_PRIORITY); // t,setPriority(10); 이렇게 사용해도 (가장 큰 값을 넣어도) 가능
			}
			
			t.start();
		}
	}
}
