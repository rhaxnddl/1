/*
 * 2019.12.02 이현경
 * 예제 5)
 * 1~1000까지의 합계가 5000이 넘는 순간의 수를 출력하시오
 * */
package c_control;

public class ForExam5 {
   ForExam5 (){
	   
	   int sum = 0;
	   int i = 0;
	   
	   for ( i = 1 ; i<= 1000; i++) {
	      sum = sum+i;   
		//  sum += i ; 		   
		   if (sum>=5000) { 
			  System.out.println(i + ", " + sum);
			  System.out.println(i);
			  break; 
		   }
	  // System.out.println((i-1) + "," + sum);
	   }	 
   }
}
