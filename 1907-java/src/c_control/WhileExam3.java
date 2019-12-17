package c_control;

import java.io.IOException;

public class WhileExam3 {
       WhileExam3() throws IOException {
    	   boolean run = true;
    	   int speed = 0;
    	   int keyCode = 0;
    	   
    	   while (run) {
    		   if(keyCode!=13 && keyCode!=10) {
    			   System.out.println("_____________________________");
    			   System.out.println("1. 증속 | 2. 감속 | 3. 중지");
    			   System.out.println("_____________________________");
    			   System.out.print("선택: ");
    		   }
    		   keyCode = System.in.read( ) ;
    		   
    		   if (keyCode == 49) {
    			   speed++;
    			   System.out.println("현재속도 = " + speed);
    		   } else if (keyCode == 50) {
    			   speed--;
    			   System.out.println("현재속도 =" + speed);
    		   } else if (keyCode == 51) {
    			   run = false;
    		   }
    	   }
    	          System.out.println("시스템 종료");
      }
}
