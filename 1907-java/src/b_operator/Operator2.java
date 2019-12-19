/*2019.11 이현경
 * 논리 연산자 */

package b_operator;

public class Operator2 {
 Operator2(){
	 int kor = 60;
	 int eng = 60;
	 
	 //국어 성적이 60이상이고 영어 성적도 60이상일때 '합격'('이고'이기 때문에 논리곱<& , &&>)
	 boolean b = (kor>=60)&&(eng>=60);
	 System.out.println(b);
	 
	 //국어 성적이 60이상 이거나 영어 성적이 60이상이면 '합격'('이거나'이기 때문에 논리합<|| , |>
	 b = (kor>=60)||(eng>=60); //위에 boolean이 선언됐기 때문에 다시 선언 안해도 됨
	 System.out.println(b);
	 System.out.println(!b); // '!'가 부정이기 때문에 위에가 참일때 거짓, 위에가 거짓일때 참
	 
	 }
 public static void main(String[] args) {
	 new Operator2();
 }
}
