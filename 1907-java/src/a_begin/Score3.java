package a_begin;

public class Score3 {
  Score3 (){
 int kor = 95;
 int eng = 80;
 int total = kor+eng;
 double pg = (double) total/2; // pg = total/2.0;
 
 System.out.println("------------------");
 System.out.println("성적 처리 결과");
 System.out.println("------------------");
 System.out.println("작성일자 : 2019.11.27(수)");
 System.out.println("작성자 : 이현경");
 System.out.println("국어 : " + kor);
 System.out.println("영어 : " + eng);
 System.out.println("합계 : " + total);
 System.out.println("평균 : " + pg);
 System.out.println("--------------------");
  }
  
public static void main(String[]  args) {
      new Score3();
}
}