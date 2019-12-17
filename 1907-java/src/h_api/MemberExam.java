// 2019.12.12이현경
// clone
package h_api;

import java.util.Arrays;

public class MemberExam {

	public static void main(String[] args) {
		Member ori = new Member("blue", "hong", "1234", 25, true);
		
		Member cloned = ori.getMember();
	
		System.out.println("복제된 객체의 필드값");
		System.out.println("id : " + cloned.id);
		System.out.println("name : " + cloned.name);
		System.out.println("password : " + cloned.password);
		System.out.println("age : " + cloned.age);
		System.out.println("adult : " + cloned.adult);
		
		// 얕은 복제 ( 본연의 값이 변경됨)
		// 깊은 복제 (본연의 값은 변경안되고, 복제된 값만 변경)
		
		cloned.scores[0] = 100;
		
		System.out.println(Arrays.toString(ori.scores)); 
		System.out.println(Arrays.toString(cloned.scores));
		
		cloned.car.model = "소나타";
		
		System.out.println(ori.car.model);
		System.out.println(cloned.car.model);
	}
}
