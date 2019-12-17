package h_api;

import java.util.Arrays;
import java.util.Objects;

import h_api2.Student;
import h_api2.StudentComp;

public class SortExam {
	
	// 숫자형 배열값을 오름차순으로 정렬
	public void numberSort() {
		int[] n = {23,235,234,254,3634,456546,54656,76787,3,4545};
		
		System.out.println("정렬전 : ");
		System.out.println(Arrays.toString(n));
		
		int temp = 0; // 대피소 변수
		
		// for문 두개 (기준, 비교 대상)
		for(int i=0; i<n.length-1; i++) { // 기준 for문 // 비교 기준 값을 제외하고 비교를 해야하기 때문에 n.length -1 만큼 비교
			for(int j =( i+1); j<n.length; j++) { // 비교 대상 for문 // 비교 기준 값 다음부터 비교를 해야하기 때문에 j = i+1
				if(n[i]>n[j]) { // swap // 등호만 반대로 바꿔주면 내림차순정렬 
					temp = n[i]; // 대피소에 n[i]값을 저장
					n[i] = n[j]; // 비어있는 n[i]에 n[j]의 값을 넣음
					n[j] = temp;// 대피시켜 놓았던 n[i]값을 비어있는 n[j]에 넣음
				}//if
			}// j
		} //i
		System.out.println("정렬후 : ");
		System.out.println(Arrays.toString(n));
		
	}
	
	// 문자열형 배열값을 오름차순으로 정렬(문자열 비교 : equals, compare to)
	public void strSort() {
		String[] n = new String[] {
				"sdfsdfs","sdghdg","werwt","ruughf","3","가나다","홍길동","2423523","gesf342","324dsfsd"
		};
		String temp = ""; // 기준값이 대피해야할 변수
		for(int i=0; i<n.length-1;i++) {
			for(int j=(i+1); j<n.length; j++) {
				if(n[i].compareTo(n[j]) > 0 ) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}// if
			}// j
		}// i
		System.out.println();
		System.out.println(Arrays.toString(n));
			// 문자열은 왼쪽부터 비교(그래서 3이 234보다 크다고 정렬)
	}
	
	public void objSort() { // 성적을 저장하는 배열 앞에 static을 붙이면 StudentApp.n 이라고 하면 사용 가능 

		 Student[] n = new Student [] {
				
			 new Student(10,"hong",60),
			 new Student(1,"kim",90),
			 new Student(3, "park", 40),
			 new Student(8, "lee",99),
			 new Student(2,"hong",66),
			 
		};
		
//		System.out.println(Arrays.toString(n));
		
		// 학번순 또는 선적순으로 정렬(Class - StudentComp에서 변경 가능)
		Student temp = null;
		for(int i = 0; i<n.length-1; i++) { // 기준
			for(int j =( i+1); j<n.length; j++) { // 비교 대상
				int result = Objects.compare(n[i], n[j], new StudentComp());
				if(result>0) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if
			} // j
		} // i
		
		for(int i=0; i<n.length; i++) {
			System.out.println(n[i]); // 한명씩 출력
		}
	}

	public static void main(String[] args) {
		SortExam se = new SortExam();
//		se.numberSort();
//		se.strSort();
		se.objSort();
	}

}
