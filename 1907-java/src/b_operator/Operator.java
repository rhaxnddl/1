/*
 * 작성일자 : 2019.11
 * 작성자 : 이현경
 * 각종 연산자에 대한 샘플
 */
package b_operator;
 
public class Operator {
	Operator(){
		//나머지 연산자 
		System.out.println("12%5 => " + (12%5));
		
		//나머지 연산자와 삼항연산자
		int n = 122;
		
		String r = (n%2==0)? "짝수" : "홀수";//System.out.println("짝수"); : System.out.println("홀수");
		System.out.println( n + "==>" + r);
		
		
		/*증감 연산자
		전치/후치*/
		int a = 10;
		int b = 10;
		a++;//(a=a+1)
		++b;//(b=b+1)
		System.out.println(a + "," + b);
		
		int c = a++;
		int d = ++b;
		System.out.println(c + "," + d);
		System.out.println(a + "," + b);
		
		//문자열 비교 연산자
		
		String name = "이";
		String irum = "이";
		
		String irum2 = new String("이");
		
		System.out.println(name==irum);  //메소드가 같기 때문에 출력값이 ture
		System.out.println(name==irum2); //메서드가 따로 만들어졌기 때문에 false
		
		System.out.println(name.equals(irum));
		System.out.println(name.equals(irum2));
		
		
	}
 public static void main(String[] args) {
	 new Operator(); //new뒤에는 항상 생성자를 작성, 클래스명 아님
 }
}















