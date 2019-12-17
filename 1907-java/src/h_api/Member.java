//2019.12.12 이현경
// clone (복사)
package h_api;

import java.util.Arrays;

public class Member implements Cloneable{
	public String id, name, password;
	public int age;
	public boolean adult;
	public int[] scores;
	public Car car;
	
	public Member(String id, String name, String pa, int age, boolean ad) {
		this.id = id;
		this.name = name;
		this.password = pa;
		this.age = age;
		this.adult = ad;
		scores = new int[] {10,20,30};
		car = new Car("벤츠");
		}
	
	public Member getMember() {
		Member cloned = null;
		
		try {
			cloned = (Member)clone();
			
			cloned.scores = Arrays.copyOf(this.scores, this.scores.length); // 깊은 복제를 하기 위한 작성 이부분을 부석처리하면 얕은복제로 되어 본연의 값이 변경됨 
			
			cloned.car = new Car(this.car.model); // 원본은 바뀌지 않고, 사본만 바뀜
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return cloned;
	}
}
