package a_begin;

public class PromotionExample {
	int a=80;//class안에서 필드로서 실행된것
	int b=90;
	int c=50;
//연산식이기 때문에 실행이 안됨-> 연산식은필드를 정의하는 요소가 아니기 때문
//액션이 취해지는 요소는 메소드 안에서만 가능
   
   //생성자로 불려지는 메서드(반드시 클래스 명과 동일해야함, 반드시 ()가 붙어야하고, {}가 반드시 있어야 함)
   PromotionExample(){  
	   c=a+b;
	   System.out.println(c);
	   
	   byte byteValue = 10;
	   int intValue = byteValue;
	   
	   System.out.println(intValue);
	   
	   char charValue = '가';
	   intValue = charValue;
	   System.out.println("가의 유니코드=" + intValue);
	   
	   intValue = 500;
	   long longValue = intValue;
	   System.out.println(longValue);
	   
	   intValue = 200;
	   double doubleValue = intValue;
	   System.out.println(doubleValue);
	   
	   
	   
	   
	   
   }
   
   public static void main(String[] args) {
    	 new PromotionExample();
    	 
     }
}

