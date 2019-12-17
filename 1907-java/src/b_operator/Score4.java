package b_operator;

public class Score4 {
	/*int a=90;
	 *int b=50;
	 *int c=40;
	 *int t=0;
	 *double d=0.0;
	 *boolean r;
	 *String str=null;
	 * */
 Score4(){
	 /*t = a+b+c;
	  * d = (double)t/3
	  * 
	  * r = a>=40 && b>=40 && c>=40 && d>=60;
	  * str = (r)? "합격" : "불합격";
	  * 
	  * r = a<40 || b<40 || c<40; 
	  * str = (r)? "불합격" : "합격";
	  * */
	 int kor = 50;
	 int eng = 50;
	 int mat = 50;
	 int total = kor+eng+mat;
	 double a = (double) total/3; // int c = total/3;
	 
	 boolean b = kor<40 && eng<40 && mat<40 && a<=60;
	 String c = (b)? "합격":"불합격"; 
	 // String b = (kor<40)&&(eng<40)&&(math<40)&&(a<60)? "합격":"불합격";
	 
	 System.out.println("----------------------------");
	 System.out.println("합격 통지 여부");
	 System.out.println("----------------------------");
	 System.out.println("국어 : " + kor);
	 System.out.println("영어 : " + eng);
	 System.out.println("수학 : " + mat);
	 System.out.println("총점 : " + total);
	 System.out.println("평균 : " + a);
	 System.out.println("결과 : " + c);//System.out.println("결과 : " + b); //System.out.println("결과 : " + str);
	 System.out.println("----------------------------");
	}
 public static void main(String[] args) {
	 new Score4();
	
	/*대입 연산자 
	 int a=10;
	 int b = 20;
	 int c = 0;
	 c += a; // c =c=a; 의미 
	 c -= a; // c = c-a;
	 c %= 2; // c = c%2;*/
 }
}
