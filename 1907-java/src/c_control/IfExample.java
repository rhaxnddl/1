/*
 * 2019.11.28 이현경
 * 조건문( if 문) 예시
 * */
package c_control;

public class IfExample {
	
	public static void main(String[] args) {
	     // new IfExample(); JVM이 매개변수가 없는 생성자를 임대, 익명 객체라고 함
		IfExample obj = new IfExample(); // 클래스와 이름이 동일 하기 때문에 참조형 
		int k = obj.type1(); // 메서드를 호출하는 실행문
		System.out.println(k);
		System.out.println(obj.type1());
		System.out.println("-----------------------------------");
		
		String m = obj.type2();
		System.out.println(m);
		System.out.println("-----------------------------------");
		
		System.out.println(obj.type3()); // 변수를 만들지 않고 출력하는 방법
		char a = obj.type3();
		System.out.println(a);
		System.out.println("-----------------------------------------------");
		
		obj.type4();
	  }
   int type1(){
       int r = 0;
	   int score = 53;
    	
    	if( score >= 90 ) {
    		System.out.println("점수가 90보다 큽니다.");
    		System.out.println("등급은 A 입니다.");}
    	
    	if( score <90 ) 
    		System.out.println("점수가 90미만입니다.");
    		     System.out.println("등급은 B 입니다."); // 항상 실행
    	// 중괄호 안에 들어있지 않기 때문에 한 줄만 if문에 의해 실행, 그 다음 줄 부터는 항상 실행 
    	
  	    return r;}
   
   String type2() {
	   String r = null; // null은 '아직 가리켜야 할 주소가 없다'라는 의미
	   int s = 90;
	   
	   if ( s >=90 ) {
		  r = "90이상입니다.";
		  r +="\nA";
	   } else {
		   r = "90미만입니다.";
		   r += "\nB";
		     }
	   return r;
   }
   /*성적을 if~else if를 사용하여 학점을 구하여 r에 저장하시오.
    * 60미만이면 F 학점
    * */
   char type3() {
	   char r = ' '; //띄어쓰기 없이''라고 쓰면 null이 들어가서 오류가 남 >> 반드시 ' '한칸 띄고 써야 함 
	    int s = 85;
	    
	    if ( s >= 90) {
	    	r = 'A';
	    	} else if ( s >= 80) {
	    		r = 'B';
	    	} else if ( s >= 70) {
	    		r += 'C';
	    	} else if ( s >= 60) {
	    	r = 'D';
	    	} else {
	    		r += 'F';
	    		}
	   return r;
   }
    // void는 처리된 반환값이 없을 경우 사용, void를 사용할  경우 return문장을 쓰지 않아도 됨, 반환값이 없다고 해서 void를 생략할 수 없다. 
   
   /*
    * 성적이 0~100일 때만 60이상이면 '합격'
    * 60미만이면 '불합격'을 출력하고, 성적이 범위 밖이면 '성적오류'를 출력하시오.
    * */
   void type4(){
       int score = 60;
       String result = "";
       
        if(score <= 100 && score >= 0) {
    	   if (score >= 60) {
    		   result = "합격";	   
    	 } if(score <60) { // 'else if(score <60)'라고 써도 실행 가능, 'else{ }' 로 써도 가능
    		   result = "불합격";
         }
         } else  {
    	     result = "성적 오류";
        }         
         System.out.println(result); // 무조건 실행되는 것이 아니라 메인함수에서 호출을 해야 실행 가능
      } 
   }
