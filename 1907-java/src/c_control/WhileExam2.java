package c_control;

public class WhileExam2 {
    WhileExam2() {
    	int sum = 0;
    	int i = 1;
    	
    	while (i<=100) {
    		sum = sum+i;    // sum += i;
    			i++;
    	}
    	System.out.println("1~" + (i-1) +" 합: " + sum );
    	System.out.println("-------------------------");
    	
    	int s = 0;
    	int a = 0;
    	
    	while (a<100) {
    		a++;
    		s = s+a;   		
    	}
    	System.out.println("1~" + a +" 합: " + s );
    }
}
// 출력 문장이 while문 '{ }' 안에 있으면 과정 까지 출력
// 출력 문장이 while문 '{ }' 밖에 있으면 결과만 출력