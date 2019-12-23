/*
 * 접근자 종류에 따른 접근 테스트
 * d_array.A.java, e_class.C.java
 * */
package d_array;

public class B {
  B(){
	  A a = new A();
	  a.f1 = 1;    // (O) public type
	  a.f2 = 1;    // (O) default type(package type)
	  a.f3 = 1;   // (X) private type
	  // 필요한 것만 외부로 보여주는 것 - 캡슐화
  }
}
