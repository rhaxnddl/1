// 2019.12.12 이현경
// HashCode
package h_api;

import java.util.HashMap;

public class KeyExam {

	public static void main(String[] args) {
		HashMap<Key, String>hashMap = new HashMap<Key, String>();
			
		hashMap.put(new Key(1), "이현경");
		hashMap.put(new Key(2), "홍길동");
		
		
		hashMap.put(new Key(1), "일지매"); 
		
		String value = hashMap.get(new Key(1));
		
		System.out.println(value);

	}

}
