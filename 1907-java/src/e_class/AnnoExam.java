package e_class;

public class AnnoExam {
	
	@Override
	public String toString() { // 재정의, 반드시 toString의 반환형을 써야하고, 매개변수는 없어야 한다.
		return "이현경";
	}
//	public void toString(String str) {
//		// 추가 정의
//	}
	
  public static void main(String[] args) {
	  AnnoExam a = new AnnoExam();
	  
	  System.out.println(a);
  }
}
