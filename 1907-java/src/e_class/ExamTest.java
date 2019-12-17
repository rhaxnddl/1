package e_class;

public class ExamTest {

	public static void main(String[] args) {
		Exam1 e1 = new Exam1();
		
		int r1 = e1.sum(20, 30);
		System.out.println("두 수의 합 : " + r1);
		System.out.println("-------------------------------");
		
		int r2 = e1.sum2(1, 100);
		System.out.println("합계 : " + r2);
		System.out.println("-------------------------------");
		
		double r3 = e1.sum3(10.0, 20.0);
		System.out.println("사각형의 넓이 : " + r3);
		System.out.println("-------------------------------");
		
		String r4 = e1.gugudan(2);		
		System.out.println("구구단");
		System.out.println(r4);
	}
}
