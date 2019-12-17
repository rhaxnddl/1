package d_array;

  import java.util.Scanner;

public class ArrayExam3 {
	
	//메서드 기본 구조 : 접근자 반환형 메서드명(매개변수){...}
	// 접근자는 생략 가능
	// 생성자가 아닌 메소드는 무조건 호출 당해야 한다.
	// 같은 class안에서는 this,test1로 호출 (같은 멤버들 사이에서 호출 할 떼는 이름만 불르면 호출 가능
	// 메서드 안에서는 메서드 선언 불가
	//class 밖에서는 메서드 선언 불가. 만약 선언한다면 반드시 객체를 먼저 생성하고 호출해야 한다.
	
	// 정수형 2차원 배열을 선언하고, 초기값을 4행 3열의 데이터를 대입
	public void test1() {
     int[ ][ ] s = new int[ ][ ] {
    	 { 1, 2, 2 },
    	 { 4, 2, 4 },
    	 { 4, 5, 4 },
    	 { 7, 8, 2 }
     }; // 이런형태가 4행 3열
     
     // 배열의 행수
     System.out.println("행수 : " + s.length);
     //첫번째행의 열수 
     System.out.println("첫번째행의 열 수 : " + s[0].length);
     //두번째행의 3번째열의 값은?
     System.out.println("두번째행의 세번째열의 값 : " + s[1][2]);
     // 첫번째행의 값들의 합계
     int hap = s[0][0] + s[0][1] + s[0][2];
     System.out.println("첫번째행의 합계 : " + hap);
     // 첫번째열의 합계
      hap = s[0][0] +s[1][0] + s[2][0] + s[3][0];
     System.out.println("첫번째열의 합계 : " + hap);
     // 두번째행의 값들중 짝수만 출력
     if(s[1][0]%2==0) { System.out.print( s[1][0] ) ; } 
     if(s[1][1]%2==0) { System.out.print( s[1][1] ) ; }  
     if(s[1][2]%2==0) { System.out.print( s[1][2] ) ; }
     System.out.println(" ");
     System.out.println("_________________________________________ ");
     //세번째열의 짝수의 평균을 출력 
        hap = 0;
        int count = 0;
        double avg = 0;
        
     for( int i=0; i<s.length; i++) {
    	 if(s[i][2]%2==0) {    
    		 hap= hap+s[i][2];
    		 count++;
    	     }
    	 } if(count>0) {
        avg= (double)hap/count;
        System.out.println("합계 : " + hap);
        System.out.println("짝수의 개수 : " + count);
        System.out.println("평균 : " + avg);
        }    	 
    	 System.out.println("________________________________________ ");
     }
	public int test2() {
		// 문자열 1차원배열(names)에 임의의 성명 5개를 대입
		// 정수형 2차원배열(s)에 5명의 국어, 영어 성적을 대입
		String[ ] names = {"a","b","c","d","e" };
		 int[ ][ ] s =  {
				 {10,20},
				 {20,30},
				 {30,40},
				 {50,60},
				 {60,70}
		 };
		 int tot = 0;
		 double avg = 0;
		 // 배열의 첫번째 학생의 이름과 성적및 총점, 평균을 출력하시오.
		 tot = s[0][0]+s[0][1];
		 avg = (double) tot/s[0].length;
		 
		 System.out.println("이름 : " + names[0]);
		 System.out.println("국어 성적 : " + s[0][0]);
		 System.out.println("영어성적 : " + s[0][1]);
		 System.out.println("총점 : " + tot);
		 System.out.println("평균 : " + avg);
		 System.out.println("____________________________________________");
		 
		 // 세번째 학생의 국어점수를 100점으로 수정
		 s[2][0] = 100;
		 // 세번째 학생의 이름과 국어성적을 출력
		 System.out.println("이름 : " + names[2]);
		 System.out.println("국어 성적 : " + s[2][0]);
		 System.out.println("____________________________________________");
		
		 // 학생명이 "d"인 사람의 국어, 영어성적과 총점과 평균을 계산하여 출력
		 // 출력하되 없으면 "자료없음"을 출력
		 // 검색어를 입력하여 검색하요 검색을 중지하려면 "quit"을
		 //입력하도록 프로그램을 수정하시오
		 
		 
		 
		 
		 Scanner scanner = new Scanner(System.in);
		 String findStr = " ";		 
		 
		 while ( !findStr.equals ("quit"))	 {
				 System.out.println ("검색할 이름은?");
				 findStr = scanner.nextLine (); // findStr은 반환형이 String타입이기 때문에 사용
		 		
		 int p = -1;		 
	    for(int i=0; i<names.length; i++) {
			 if(names[i].equals(findStr)) { 
				 p =  i;
				 tot = s[i][0] + s[i][1];
				 avg = (double)tot /s[i].length; // avg = tot / 2.0;
				 System.out.println("---------검색결과---------------");
				 System.out.println("이름 : " + names[i]);
				 System.out.println("국어 성적 : " + s[i][0]);
				 System.out.println("영어 성적 : " + s[i][1]);
				 System.out.println("총점 : " + tot );
				 System.out.println("평균 : " + avg);
				 break; // 만약 동명이인이 있다면 break 생략 
			    } 	    		  			 
	    	 }
		    if (p==-1) { // (p<0) 
			    System.out.println("자료 없음");	}
          }
		   return 0;
	  }
	public static void main(String[] args) {
       ArrayExam3 a3 = new ArrayExam3();
       // 생성자를 생략하고 사용하면 가상머신이 생성자를 가져와서 사용
       // 가상 머신이 생성자를 가지고 온다면 매개변수는 비어있다.
     //  a3.test1(); 
       a3.test2();
  }  
}
