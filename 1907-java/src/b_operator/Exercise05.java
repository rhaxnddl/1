/*2019.11 이현경
 * 확인 문제 5번
 * - 10 단위라면 100으로 나눈 후 100으로 곱함
 * - 단 단위하면 10으로 나눈 후 10으로 곱함
 * - 이자계산. 10단위라면 99.999을 더한 후 100으로 나눈 후 100을 곱함.
 * ---------------------------------------------
 * 1. 십의 자리 이하를 버리는 코드 
 * 2. 세금계산. 10단위 이하의 금액은 무조건 절삭하여 과금하시오. 12,340 ==> 12,300
 * 3. 이자계산. 10단위 이하의 금액은 무조건 절상하여 과금하시오. 12,340 ==> 12,400
 * */
package b_operator;

public class Exercise05 {
	Exercise05 (){
		//1 번
		int value = 356;        
		System.out.println(value/100*100);  // 십의 자리 이하를 버리는 코드 출력문
		System.out.println(value/10*10);  // 일의 자리 이하를 버리는 코드 출력문
		//2번
        int a = 12340;         
        int d = a/100*100;
        
        System.out.println(a/100*100);
        System.out.println(d);
        //3번
        //변수를 출력할 때 정수로 변환하여 출력하는 경우
		double b = 12340.5;
		//또 다른 방법
		int e = 12340;
		int e2 = (int)(e+99.999)/100*100;
		
		System.out.println(((int) b/100)*100+100);        
		System.out.println((int)(b + 99.999)/100*100);    
		System.out.println(e2);
		//변수를 정수로 변환하여 출력하는 경우  
		int c = (int)12340.5; 
		System.out.println((c/100)*100+100);                    
       
	}
 public static void main(String[] args){
   new Exercise05 ();
 }
 }
