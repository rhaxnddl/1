/*
 * 2019.12.04 이현경
 *  3일 과제 풀이 (Exercise7)
 *  switch 문으로 작성
 * */
package c_control;

import java.util.Scanner;

public class Exam7 {
	Exam7() {
       boolean run = true;    	 
    	 int balance = 0;
    	 Scanner scanner = new Scanner(System.in);
    	 
    	 while(run) {
    		 System.out.println("_____________________________________");
    		 System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
    		 System.out.println("______________________________________");
    		 System.out.print("선택 > ");
    		 
    		int menu = scanner.nextInt(); // read는 한글자만 int는 21억 까지 받을 수 있음
    		switch(menu) {
    		case 1:     			
    			System.out.print("예금액 > " );
    			int v1 = scanner.nextInt();
    			balance += v1; // balance = balance + v1;
    			break;
    		case 2: 
    			System.out.print("출금액 > ");
                 int v2 = scanner.nextInt();
                 
                 if(v2>balance) {
                	 System.out.println("잔액이 부족합니다.");
                 } else {
                     balance -= v2; // balance = balance - v2;
                 }
    			break;
    		case 3: 
    			System.out.println("잔액 >" + balance);
    			break;
    		case 4: 
    			run = false;
    			break;		
    		}
  
    	 }
    	 System.out.println("프로그램 종료");
	}
     public static void main(String[] args) {
    	 new Exam7 ();
     }
}
