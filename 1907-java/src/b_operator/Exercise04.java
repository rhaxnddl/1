/*2019.11 이현경
 * 산술 연산자 예제문제
 * */
package b_operator;

public class Exercise04 {
	Exercise04 (){
		int pencils = 543;
		int students = 30;
		
		// 학생 한 명이 가지는 연필의 수 
		int a = (pencils / students);
		System.out.println("학생 한 명당 나눠줄 연필의 갯수 : " + a);
		
		// 남은 연필 수 
		int b = (pencils % students);
		System.out.println("학생들에서 연필을 다 나눠준 후 남은 연필의 갯수 : " + b);
		
	}
  public static void main(String[] args) {
	  new Exercise04 ();
  }
}
