// 2019.12.11 이현경
package f_inheri;

public class SuperAirPlane extends AirPlane { //항상 부모가 먼저 생성
  public static final int NORMAL = 1;
  public static final int SUPERSONIC = 2;
  
  public int flyMode = NORMAL;
  
  public SuperAirPlane() {
	  super(50);
	  System.out.println("초음속 비행기");
  }
  
  @Override
  public void fly() {
	  if(flyMode == NORMAL) {
		  super.fly();
	  } else {
		  System.out.println("초음속 비행합니다.");
	  }
  }
}
