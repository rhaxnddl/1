/*
 * 2019.11.29 이현경
 * 로또 실행 프로그램
 * */
package c_control;

public class Lotto {
	int n[] = new int[6]; // 원래 일반형이지만 ,new로 만들어지는 순간 참조형
	int count = 0;
	
	void process() {
		boolean b = false; //중복되지 않았다.
		this.n[count] = (int)(Math.random()*45)+1;
     	
		for(int i=0 ; i<count ; i++) {
		   if( n[i] == n[count]) {
			   b = true;
		   }
		}
		
		if(!b) {
     		count++;
     		prn();
      }
	}
	
	void prn() {
		System.out.println(n[count-1]);
	}
	  public static void main(String[] args) { // static에서 선언된 변수는 자동으로 static 형이다.
		Lotto k = new Lotto();
		int a = 6;
		//a는 for문 안에서 선언했기 때문에 for문 안에서만 사용 가능
		for( ;k.count<a; ) {
		k.process(); 
	   }
	 }
   }


