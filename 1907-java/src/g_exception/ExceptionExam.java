// 2019.12.11 이현경
// 예외처리 & 예외조치

package g_exception;

import ex.NullPointlnException;

public class ExceptionExam {
 
	public static void main(String[] args) {
		// NullPointerException
		//String타입의 데이터가 null이기 때문에 오류 
		// 에러는 출력문에서 났지만, 실제 오류는 실행문에서 오류가 남 (11행이 오류가 아니라 10이 오류)
		// null 대신 "", 문자를 넣음녀 오류 없이 출력 (String data = ""; / String data = "abc";)
		String data = null;   // String data = ""; (nullpointexception 오류가 아님)/
		try {	
		System.out.println(data.toString()); 
		System.out.println("오류가 없는 경우 실행됨");
		}catch(NullPointerException ex2) {
			System.out.println("Null Pointer Error !!!!!!");
			
			// 오류메세지를 출력하고 싶다면 아래 두가지 방법 중에 사용
            System.out.println(ex2.toString()); // 반환형은 String
		    ex2.printStackTrace(); // 오류 메세지가 콘솔에 출력(반환형은 void)
		    
		}catch(Exception ex) { // NullPointer없이 Exception만 있으면 모든 오류를 예외
			System.out.println("문자열 변수에 data 값이 없음.");
		}finally {
			System.out.println("오류 발생과 상관없이 무조건 실행");
		}
		// try,catch,finally문을 사용하여 예외조치 
		// 예외처리 할때에는 높은 곳에서 아래로 내려오기때문에 오류 예외 범위가 작은 순대로 위에서 부터 작성
		// Exception은 모든 예외를 처리하기 때문에 예외처리 문을 여러번 쓴다면 제일 마지막에 작성
		
		// ArrayIndexOutOfBoundsException(첨자오류)
		int[] s = {1,2,3};
		try {
		for(int i=0; i<3; i++) { // 0 베이스이기 때문에 숫자가 3개라도 i<= 3이 아니라 i<3으로 해야 오류가 없다.(배열의 크기를 벗어난 오류)
			System.out.println(s[i]);
			}
		}catch(Exception ex) {
			    ex.printStackTrace();
			    
				//System.out.println("배열의 크기를 벗어남");
			}
	//	System.out.println(s[3]);
		
		// NumberFormatException
		try {
		data = "123";
		int su = Integer.parseInt(data);
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
		}finally {
			System.out.println("예외가 발생되어도 다음처리가 발생됨");
		}
		try {
		data = "123a";
		int su2 = Integer.parseInt(data); 
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			System.out.println("예외가 발생되어도 다음처리가 발생됨");
		}
		// 메소드를 이용하면 문자열을 숫자로 변환될 수 있다면 숫자를 리턴, 숫자가 변환될 수 없는 문자가 포함되어있으면 오류 발생
		// 숫자로 바꿀수 없는 문자열을 숫자로 바꿀려고 해서 오류 발생
		
		// ClassCastException (형변환 오류)
		try {
		Car myCar = new Car();
		SportsCar c = (SportsCar)myCar;
		}catch(Exception ex) {
			System.out.println("형 변환 오류가 발생");
		} finally {
			System.out.println("끝~~~");
		}
		
		// 부모클래스를 만들어서 자식클래스에 대입할 수는 없어서 오류 발생 (부모 > 자식  X)
		// 반대로 자식클래스를 만들어서 부모클래스에 대입하는 것은 가능 (자식 > 부모   O)
		// 상속관계가 아닌 서로 연관이 없는 클래스를 대입하는 것도 오류발생
	}
} // 불완전하게 종료된다. 
// 불완전 종료를 사전에 예방하는것이 예외처리 
