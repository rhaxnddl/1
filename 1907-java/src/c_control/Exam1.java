/*
 * 2019.12.02 이현경
 * 예제 1
 * */
package c_control;

public class Exam1 {
 Exam1 (){
	 String name = "이현경";
	 String address = "서울시 은평구";
	 String phone = "010-3590-****";
	  
	 int kor = 90;
	 int eng = 90;
	 int mat = 80;
	 
	 int tot = kor + eng + mat;
	 double avg = tot/3;
	 
	 char grade;
	 
	 if(avg>=90)      { grade = 'A'; } 
	 else if(avg>=80) { grade = 'B'; } 
	 else if(avg>=70) { grade = 'c'; } 
	 else if(avg>=60) { grade = 'D'; }
	 else             { grade = 'F'; }
	 
	 String msg = "성명 : " + name;
	   msg +="\n주소 : " + address;
	   msg +="\n연락처 : " + phone;
	   msg +="\n국어 : " + kor;
	   msg +="\n영어 : " + eng;
	   msg +="\n수학 : " + mat;
	   msg +="\n총점 : " + tot;
	   msg +="\n평균 : " + avg;
	   msg +="\n학점 : " + grade;
	 
	 System.out.println(msg);	   	 
	 System.out.println("------------------------------------");
	 System.out.println("성적 처리 결과");
	 System.out.println("------------------------------------");
	 System.out.println("성명 : " + name);
	 System.out.println("주소 : " + address);
	 System.out.println("연락처 : "+ phone);
	 System.out.println("국어 : " + kor);
	 System.out.println("영어 : " + eng);
	 System.out.println("수학 : " + mat);
	 System.out.println("총점 : " + tot);
	 System.out.println("평균 : " + avg);
	 System.out.println("학점 : " + grade);
	 System.out.println("------------------------------------");
 }
  public static void main(String[] args){
	 new Exam1 ();
 }
}
