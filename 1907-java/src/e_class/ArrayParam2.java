package e_class;

public class ArrayParam2 {

	void input(int s) {
		
	}
	void input(Student s) {
		s.prn();
	}
	//매개 변수 형이 Car인 메서드
	void input(Car c) {
	   c.prn();	    
	   System.out.println("-----------------------------");
	   System.out.println(c.model);
	   System.out.println(c.color);
	   System.out.println(c.maxSpeed);
	   
	}
	
	public static void main(String[] args) {
		ArrayParam2 ap2 = new ArrayParam2();
		
		Student std = new Student();
		ap2.input(std);
		
		Car c = new Car();
	    ap2.input(c);
	    System.out.println("-----------------------------");
	    Car c1 = new Car();
	    ap2.input(c1);
	    System.out.println("-----------------------------");
	    Car c2 = new Car("볼보", "빨강", 400);
	    ap2.input(c2);
	}
}
