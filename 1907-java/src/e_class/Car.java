package e_class;

public class Car {
	String model = "그랜져";
	String color = "검정";
	int    maxSpeed = 0;
	
  Car() {	    }
  Car(String model) { 
	  this.model = model;  
  }       
  Car(String model, String color) {	
	  this.model = model;
	  this.color = color;
  }
  Car(String model, String color, int maxSpeed) {	
	  this.model = model;
	  this.color = color;
	  this.maxSpeed = maxSpeed;
  }
  void prn () {
	  System.out.println("model : " + this.model);
	  System.out.println("color : " + this.color);
	  System.out.println("max speed : " + this.maxSpeed);
  }
  
  public void speedUp() {
	  this.maxSpeed += 10;
  }
  public void speedDown() {
	  this.maxSpeed -= 10;
  }
  public static void main(String[] args) {
	  Car c1 = new Car();
	  Car c2 = new Car("이현경");
	  Car c3 = new Car("이현경", "파랑");
	  Car c4 = new Car("이현경", "파랑", 100);// 정수 하나만 가지고 있는 생성자가 없기 때문에 new Car(100);은 사용할 수 없음.
	  													    // 매개변수를 사용할 때에는 생성자 안의 매개변수 순서가 중요, 순서를 마음대로 바꿀 수는 없다. 	
	  c1.maxSpeed = 200;
	  
	  System.out.println("model : " + c1.model);
	  System.out.println("color : " + c1.color);
	  System.out.println("max speed : " + c1.maxSpeed);
	  System.out.println("---------------------------------------------");

	  System.out.println("color : " + c2.color);
	  System.out.println("max speed : " + c2.maxSpeed);
	  System.out.println("---------------------------------------------");
	  
	  System.out.println("model : " + c3.model);
	  System.out.println("color : " + c3.color);
	  System.out.println("max speed : " + c3.maxSpeed);
	  System.out.println("---------------------------------------------");
	  
	  System.out.println("c4 spac . . . . .");
	  System.out.println("model : " + c4.model);
	  System.out.println("color : " + c4.color);
	  System.out.println("max speed : " + c4.maxSpeed);
	  System.out.println("---------------------------------------------");
	  
	  c1.speedUp();
	  System.out.println("c1 max speed : " + c1.maxSpeed);
	  
  }	
}
