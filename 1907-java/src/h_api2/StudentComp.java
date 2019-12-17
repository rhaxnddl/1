package h_api2;

import java.util.Comparator;

public class StudentComp implements Comparator<Student> {	
  char flag = 'n'; // n이면 학번순, 's'이면 성적순으로 정렬	
 
  public StudentComp(char flag) {
	this.flag = flag;
}
	@Override
	public int compare(Student s1, Student s2) {
		int result = 0;
		if(flag == 'n') {
			result = s1.sno - s2.sno;
		}else {
			result = s1.score - s2.score;
		}
		return result;
	}
}

//	    return s1.sno - s2.sno; // 학번순으로 오름차순 정렬
//		return s1.score - s2.score; // 성적순으로 오름차순 정렬

// 만약 <Student>를 빼고 싶다면 사용 가능한 코드
//
// public class StudentComp implements Comparator{	
//	
//	 @Override
//	 public int compare(Student s1, Student s2) {
//		Student s1 = (Student)o1;
//		Student s2 = (Student)o2;
//      return s1.sno - s2.sno; // 학번순으로 오름차순 정렬
//		return s1.score - s2.score; // 성적순으로 오름차순 정렬
//	 }