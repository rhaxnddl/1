// 2019.12.11 이현경
// 예외 처리
// try,catch문을 쓰지 않고, throws문을 쓰면 오류가 계속 넘어가 어디에선가 try,catch문을 써야한다.
// 자바는 다중처리(thread)가 기본이기때문에 실행결과가 계속 달라짐
// throws가 아니라 throw new Exception을 작성하면 강제로 오류 발생
package g_exception;

public class ExceptionExam2 {
	
	public ExceptionExam2() throws Exception {
		this.method();
	}
	
	public void method() throws Exception {
		int su = 100;
		int su2 = 10;
		System.out.println(su/su2);
		throw new Exception("강제로 예외를 발생 시킨다.");
	}

	public static void main(String[] args) {
		try {
			new ExceptionExam2();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());// 오류메세지를 받아서 출력시켜라
		}
			System.out.println("끝~~~~~~~~~~~~~~~~~~~");
	}

} 
