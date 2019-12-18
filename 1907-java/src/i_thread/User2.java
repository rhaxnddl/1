package i_thread;

public class User2 extends Thread{
	Calc calc;
	
	void setCalc(Calc calc) {
		this.calc = calc;
		this.setName("User2");
		
	}
	public void run() {
		calc.setMemory(50);
	}
}
