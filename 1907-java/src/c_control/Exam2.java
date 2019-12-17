/*2019.12.02 이현경
 * 예제 2
 * */
package c_control;

public class Exam2 {
   Exam2 (){
	   int base = 2000;
	   int basePrice = 3000;
	   int totM = 4530;
	   int m = 0;
	   int mPrice = 500;
       int totPrice = 0; 
	   m = totM - base;
 
	   if(m > 0) {
			int v = m/200;
			if(m%200>0) {
				v++;
			}
			totPrice = basePrice + (mPrice*v);
		   } else {
		    totPrice = 3000;
	   }
	   System.out.println(totPrice);
   }
	public static void main(String[] args) {
	   new Exam2();
   } 
}
