package a_begin;

public class CastingExample {
	CastingExample(){
		//int -> char
		int a = 44032;
		char c = (char)a;
		System.out.println(a + " to char type : " + c);
		
		
		//long -> int
		long l = 500;
		int b = (int)l;
		System.out.println(b);
		
		//double -> int
		double d = 3.14;
		int e = (int)d;
		
		System.out.println(d + " to int type : " + e);
		
		
		double d2 = 10/3; //정수형 연상의 답은 무조건 정수형이여서 결과가 3.0 -> double 타입이라도 변화 없음
		double d3 = 10/(double)3; // double 타입으로 강제로 캐스팅하여 결과가 변수형으로 나옴(3.3333333333333335)
		System.out.println(d2);
		System.out.println(d3);
		
		
	}
	public static void main(String[] args) {
		new CastingExample();
		/*public static void main(Sting[] args) {
		 * int intValue = 44032;
		 * char charValue = (char) intValue;
		 * System.out.println(charValue);
		 * 
		 * long longValue = 500;
		 * intValue = (int) longValue;
		 * System.out.println(intValue);
		 * 
		 *double doubleValue = 3.14;
		 *intValue = (int)doubleValue;
		 *System.out.println(intValue);
		 *}
		 * */
	}
}