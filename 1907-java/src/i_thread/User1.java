package i_thread;

public class User1 extends Thread{
	Calc calc;
	
	
	public void setCalc(Calc calc) {
		this.calc = calc;
		this.setName("User1");
	}

	@Override
	public void run() {
		calc.setMemory(100);
	}
}
