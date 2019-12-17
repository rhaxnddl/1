package c_control;

public class ForExam3 {
   ForExam3(){
	   int x = 0;
	   int y = 0;
	   
	   for (x = 1; x<=100; x++) {
	     y = 3 * x + 1;
	      System.out.printf("(%4d,%4d) \n", x,y);	  
	      System.out.println("--------------------------------");
	      System.out.println("(" + x + "," + y + ")");
	      System.out.println("--------------------------------");
	   } 
    }   
 }
