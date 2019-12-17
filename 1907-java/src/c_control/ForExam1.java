package c_control;

public class ForExam1 {
 ForExam1() {
	 int sum = 0;
     for(int i=0 ; i<=100 ; i=i+2) { //1~100 , 
   // for(int i=0 ; i<=100 ; i=i+2) 짝수만 더한 값을 구하는 방법
   // for(int i=1 ; i<=100 ; i=i+2) 홀수만 더한 값을 구하는 방법 
   // for(int i=1 ; i<=100 ; i++)   모두 더한 값을 구하는 방법 
    	 
    	 sum = sum+i; //sum +=i
         System.out.println(i + " 까지의 합 : " + sum); // 더하는 과정까지 보겠다.
         
     }
         System.out.println(sum); // 최종 결과만 보겠다.
 }
 
}
