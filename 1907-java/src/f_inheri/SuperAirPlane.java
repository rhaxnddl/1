// 2019.12.11 ������
package f_inheri;

public class SuperAirPlane extends AirPlane { //�׻� �θ� ���� ����
  public static final int NORMAL = 1;
  public static final int SUPERSONIC = 2;
  
  public int flyMode = NORMAL;
  
  public SuperAirPlane() {
	  super(50);
	  System.out.println("������ �����");
  }
  
  @Override
  public void fly() {
	  if(flyMode == NORMAL) {
		  super.fly();
	  } else {
		  System.out.println("������ �����մϴ�.");
	  }
  }
}