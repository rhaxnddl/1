
// HashSet은 중복저장은 안되지만, 대소문자는 구별하여 Java를 두개저장 하였지만 출력은 하나만 되었고,대문자였던  JAVA는 출력
// 내가 작성한 것은 6개 이지만, 출력문에서의 객체 수는 5개로 출력(Java가 두개 작성되어있기 때문에)
// 내가 작성한 순서로 출력되지 않고, 문자 순서대로 출력되지 않는다. (순서가 없다.)
// 반드시 리무브를 한다음 자료를 추가 저장해야 한다. (수정데이터가 없기 때문에)

package j_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("java");
		set.add("JDBC");
		set.add("selvlet/JSP");
		set.add("java");
		set.add("JAVA");
		set.add("myBatis");
		
		System.out.println("size : " + set.size());
		
		// iterator메소드 사용 (객체 검색)
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);
		}
		System.out.println("--------------------------------------------");
		
		// 향상된 for문 사용
		for(String temp : set) {
			System.out.println(temp);
		}
		set.remove("java");
		set.remove("myBatis");
		
		System.out.println("--------------------------------------------");
		System.out.println("삭제 후 size : " + set.size());
		iter = set.iterator();
		while(iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);
		}
		System.out.println("--------------------------------------------");
		set.clear();
		if(set.isEmpty()) System.out.println("자료가 비어있습니다.");
		
		//-------------------------------------------------------------
		Set<MemberVo> memberSet = new HashSet<MemberVo>();
		memberSet.add(new MemberVo("a001", "1111", "hong", "010-1234")); // 기준
		memberSet.add(new MemberVo("a002", "1111", "hong", "010-1234")); // 아이디가 다름 , 출력 가능
		memberSet.add(new MemberVo("a002", "1111", "hong", "010-0000")); // 연락처 다름 , 출력가능
		
		memberSet.add(new MemberVo("a002", "2222", "kim", "010-1234")); // 이름만 다르고 아이디, 연락처 같음 , 출력 안됨
		
		// MemberVo 클레스의 Hash생성자와 equals 생성자에서 아이디와 연락처가 같으면 같은 객체라고 정의되어있다.
		// 아이디랑 연락처가 같고, 다른 항목들이 모두 달라도 같은 객체리고 생각하여 저장이 안됨
		
		System.out.println("memberSet size : " + memberSet.size());
		
		Iterator<MemberVo> iter2 = memberSet.iterator();
		while(iter2.hasNext()) {
			MemberVo vo = iter2.next();
			System.out.print(vo);
		}
		// 데이터 삭제 
		// 수정데이터가 없어 삭제 후 다시 추가 해야한다.
		MemberVo delvo = new MemberVo("a002", "1111", "hong", "010-0000");
		memberSet.remove(delvo);
		
		System.out.println("--------------------------------------------");
		//향상된 for문
		for( MemberVo vo : memberSet ) {
			System.out.print(vo);
		}
		
	}
}