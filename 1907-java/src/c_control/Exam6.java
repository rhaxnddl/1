package c_control;

public class Exam6 {
   Exam6(){
	   for(int i=1; i<=5; i++) {
		   for(int j =1; j<=i; j++) {
		// for(int j=1; j<=(6-i); j++) => 역순으로 별 나열 
			   System.out.print("*");
		   }
		   System.out.println();
	   }
   }
     public static void main(String[] args) {
    	 new Exam6();
     }
}
