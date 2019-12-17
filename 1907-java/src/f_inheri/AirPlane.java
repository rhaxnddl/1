// 2019.12.11 이현경
package f_inheri;

public class AirPlane {
	public  AirPlane() {
		System.out.println("일반비행기");
	}
	public AirPlane(int tire ) {
		System.out.println("타이어가" +  tire + "개인일반 비행기");
	}
   public void land() {
	   System.out.println("착륙");
   }
   public void fly() {
	   System.out.println("일반 비행");
   }
  
   public void takeOff() {
	   System.out.println("이륙합니다.");
   }
}
