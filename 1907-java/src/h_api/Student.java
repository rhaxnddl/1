// 2019.12.19
package h_api;

public class Student {
	public int sno;
	public String name;
	public int score;
		
	Student(int sno) {
		this.sno = sno;
	}
	Student(int sno, String name, int score) {
		this.sno = sno;
		this.name = name;
		this.score = score;
	} // SortExam에서 사용할 생성자
	
		@Override
	public String toString() {
		return "\t"+sno + "\t" + name + "\t" + "\t" + score;
	}
}
