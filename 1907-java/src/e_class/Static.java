package e_class;

public class Static {
	// 정적 형(공용자원) - 모든 객체가 동일한(하나의) 값을 사용한다.
	// 초기화는 한번만 가능
	// 클래스명.멤버 또는 객체명.멤버 으로 모두 접근 가능.
   static int v1 = 5000; 
   int v2 = 5000; // 인스턴스 형 (객체가 가지고 있는 변수이다.)
   
	public static void main(String[] args) {
		Static s1 = new Static();
		s1.v1 = 1000;
		s1.v2 = 1000;
		
		Static s2 = new Static();
		System.out.println(s2.v1); // v1은 static변수이기 때문에 1000으로 한번만 초기화 되어 값이 1000
		System.out.println(Static.v1);
		System.out.println(s2.v2); // v2는 다시 초기화되어 값이 5000
		

	}

}
