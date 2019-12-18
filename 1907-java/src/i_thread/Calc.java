package i_thread;

public class Calc {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) { // 메소드 선언에서 'synchronize' 키워드를 붙여 동기화 블록을 만들면 User1과 User2의 값을 정상적으로 실행 될 수있다.
		this.memory = memory;
		
		try {
			Thread.sleep(2000); // 2초 뒤 살행(일시정지 상태)
		} catch (InterruptedException e) {	}
		
		System.out.println(Thread.currentThread().getName()+ " : " + this.memory);
	}	
}
