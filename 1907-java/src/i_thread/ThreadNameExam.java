package i_thread;

public class ThreadNameExam {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("메인 스레드명 : " + mainThread.getName());
		
		Thread t1 = new ThreadA();
		Thread t2 = new ThreadB();
		
		t1.start();
		t2.start();
	}
 // 실행 될때마다 스레드의 갯수나 숫자가 달라질 수 있다.
 // t1이 실행되면서 t2도 같이 실행되어 같이 출력됨
}
