/*
 * 2019.12.05 이현경
 * 
 * */
package d_array;

import java.util.Scanner;

public class ArrayExam4 { 
	// 필드 영역안에서 배열을 선언
	// 클래스 영억에서만 안 벗어난다면 어디든지 필드영역이어서 배열 선언 가능
	// 하지만 필드를 중간중간에 선언해서 사용하지 않는다.
	// 필드는 특별한 이유가 없는 한 맨 위에 작성
	// 선언한 변수가 특정 메소드 안에서만 쓴다면 메소드 안에, 다른 메소드에서도 쓴다면 필드에 선언
	String[] n = new String[10];
	int[][] s = new int [10][2];
	int count = 0; // 배열에 입력된 자료의 갯수 
	
	
	// 생성자의 역할은 무한 루프를 돌면서 메뉴를 출력
	ArrayExam4() {	
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		// 샘플용 데이터를 배열에 저장
		n[0] = "kim";
		n[1] = "hong";
		n[2] = "park";
		n[3] = "lee";
		s[0][0] = 90; s[0][1] = 80;
		s[1][0] = 70; s[1][1] = 30;
		s[2][0] = 60; s[2][1] = 20;
		s[3][0] = 50; s[3][1] = 10;
		
		count = 4;
		
		while(run) {
		   System.out.println("-------------------------------------------------");
		   System.out.println("1. 입력 | 2. 수정 | 3. 조회 및 출력 | 4. 종료");
		   System.out.println("-------------------------------------------------");
		   System.out.print("메뉴 선택 : ");
		   int menu=scanner.nextInt();
	    
		  switch(menu) {                           // if문으로 사용할 때 
		    case 1:                                    // if(menu==1) input()
			 this.input( );                           // else if(menu==2) modify()
			 break;                                   // else if(menu==3) search()
		   case 2:
			 this.modify( );
			 break;
		   case 3:
			 this.search( );
			 break;
		   case 4:
			  run = false;
			  break;
		   
		} // switch 문 끝
	  }  // while 문 끝
		System.out.println("프로그램이 종료되었습니다.");
   }
	// 학생의 성적 정보를 배열에 입력
   public void input() {	   
	   Scanner scanner = new Scanner(System.in);
	   String name = "";
	   int kor = 0;
	   int eng = 0;
	   int tot = 0;
	   double avg = 0;
	   System.out.print("성명 : ");
	    name = scanner.nextLine();
	   System.out.print("국어 점수 : ");
	    kor = scanner.nextInt();
	   System.out.print("영어 점수 : ");
	    eng = scanner.nextInt();	   
	     
	   tot = kor+eng;
	   avg = (double) tot/2;
	   
	   System.out.print(" 총점 : " + tot);
	   System.out.println("평균 : " + avg);
	   
	   n[count] = name;
	   s[count][0] = kor;
	   s[count][1] = eng;
	   count++;
	   
   }
   // 학생의 성적 정보를 수정
   // 1. 수정할 학생명을 입력받아 검색
   // 2. 검색된 정보를 표시
   // 3. 수정
   // 4. 배열 정보 수정
   public void modify() {	  
	   Scanner scanner = new Scanner(System.in);
	  String findName = "";
	  System.out.print("검색할 학생명은?");
	  findName = scanner.nextLine();
	   
	   for(int i=0 ; i<count ; i++) {
		   if(n[i].equals(findName)) {			   
			   System.out.println("성명 : " + n[i]);
			   System.out.println("국어 점수 : " + s[i][0]);
			   System.out.println("영어 점수 : " + s[i][1]);
			   
			   System.out.println("성적을 수정하세요");
			   System.out.print("국어 점수 : ");
			   s[i][0] =scanner.nextInt();
			   
			   System.out.print("영어점수 : ");
			   s[i][1] = scanner.nextInt();			   
		   } // end if
	   } // end for
	   
//     내가 작성한 코드	   
//	   System.out.print("수정할 학생 명은?");
//	   String findName = scanner.nextLine();
//	   
//	   for(int i=0 ; i<count ; i++) {
//		   if(n[i].equals (findName)) {
//			 int  kor = s[i][0];
//			 int eng = s[i][1];
//			 int tot = 0;
//			 double avg =0; 		
//			 
//			 System.out.print("국어 점수 : ");
//			 kor = scanner.nextInt();
//			 System.out.print("영어점수 : ");
//			 eng = scanner.nextInt();
//			 
//			 tot = kor+eng;
//			 avg =(double)tot/2; 	
//			 System.out.println("총점 : " + tot);
//			 System.out.println("평균 : " + avg);	
//			 
//			 String editName = scanner.nextLine();
//			    n[i] = editName;			
//			  System.out.print(n[i] + " ");
//			  System.out.print(s[i][0]+" ");
//			  System.out.print(s[i][1]+" ");
//			 
// 		   } 
//	   }	   
   }
   // 학생의 성적 정보를 조회 및 출력
   public void search() {	   
	   Scanner scanner = new Scanner(System.in);
	   System.out.print("검색할 성명은?");
	   String findName = scanner.nextLine();
	   
	   for(int i=0 ; i<count ; i++) {
		   if(n[ i ].equals (findName) || findName.equals("")) {
			  int tot = 0;
			  double avg =0;
	
		   System.out.print(n[i] + " ");
		   System.out.print(s[i][0] + " ");
		   System.out.print(s[i][1]  + " ");
		   //TODO(총점, 평균을 계산하여 출력)
		   tot = s[i][0] + s[i][1];
		   avg = (double) tot/2;
		   System.out.print(tot + " ");
		   System.out.printf("%5.1f",avg);		   
		   System.out.println();
	   }
	 }
   }
   public static void main(String[] args) {
	   new ArrayExam4();
   }
}
