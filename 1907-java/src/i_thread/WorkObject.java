package i_thread;

public class WorkObject {	
	public synchronized void methodA() {
		System.out.println("TheardA의 methodA().....");
		notify(); // 실행 중지 되어있는 스레드를 깨움
		
		try {
			wait();
		} catch (InterruptedException e) {  }
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB().....");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {	}
	}
}
// notify()와 wait()를 없애면 출력할 때 마다 결과가 다르게 나온다.
// synchronized를 없애면 상호배타적 동기화가 이루어지지않아 출력결과가 다르게 나온다.