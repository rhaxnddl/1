package h_api2;

// String의 속도와 StringBuilder의 속도 비교
public class StringBuilerExam {
	
	public StringBuilerExam() {
		// String 속도
		long sTime = 0, eTime = 0;
		String str = "";
		
		sTime = System.nanoTime();
		for(int i=0; i<50000; i++) {
			str +="a";
		}
		
		eTime = System.nanoTime();
		
		System.out.println("String 처리 시간 : " + (eTime-sTime) );
		
		
		// StringBuilder
		StringBuilder sd = new StringBuilder(100); 
		sTime = System.nanoTime();
		for(int i=0; i<50000; i++) {
			sd.append("a");
		}
		eTime = System.nanoTime();
		
		System.out.println("StringBuiler 처리 시간 : " + (eTime-sTime));
		
	}

	public static void main(String[] args) {
		new StringBuilerExam();

	}

}
