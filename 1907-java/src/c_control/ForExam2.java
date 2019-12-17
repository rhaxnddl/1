/*---------------------------------------------
 * 2019.12.02 이현경
 * 구구단 출력
 *---------------------------------------------*/
package c_control;

public class ForExam2 {
   ForExam2 (){
	  
	   /*-------------------------------------------
	    * for (int m =2; m<=99; m++) {
	      System.out.println(m + " 단 입니다.");
	     for(int n=1 ; n<=9 ; n++) {
	     System.out.println(m + " X " + n + " = " + (m*n));
	     } >> 2단 부터 99단 까지 출력
	     -------------------------------------------*/
	    
	   int m = 2;
	   
	   System.out.println(m + " 단 입니다.");
	   
	   for(int n=1 ; n<=9 ; n++) {
	   System.out.println(m + " X " + n + " = " + (m*n));
	   }
	   
	   m = 3;
	   System.out.println(m + " 단 입니다.");
	   for(int n=1 ; n<=9 ; n++) {
	   System.out.println(m + " X " + n + " = " + (m*n));
     }
  }
 }
