package c_control;

import java.util.Scanner;
  
public class Exercise07 {
    Exercise07 () {
      boolean run = true;      
      int in = 0;
      int out = 0;
      int money = 0;  
      
      Scanner scanner = new Scanner(System.in);
            
      while(run) {
    	  System.out.println("______________________________________");
    	  System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료 ");
    	  System.out.println("______________________________________");
    	  System.out.print    	 ("선택 > ");
    	     
    	  int keyCode =   scanner.nextInt();
            
           if(keyCode == 1) {
          	   System.out.println("예금액 > " );
          	   in =   scanner.nextInt();
          	   money = money + in;
          	 
           } else if( keyCode == 2) {
        	   System.out.println("출금액 > ");
        	  out =  scanner.nextInt();
        	  money = money  - out;
        	
        	  
           } else if( keyCode == 3) {
       	   System.out.println("잔고 > " + money);
       	
           } else if( keyCode == 4) {
        	   run = false;
        	   System.out.println("프로그램 종료");
           }  
      } // end of while         
    }
    public static void main(String[] args) {
    	new Exercise07();
}
}
