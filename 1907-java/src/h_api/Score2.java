// 2019.12.16

package h_api;

public class Score2 implements Comparable<Score2>{
	int kor;
	
	Score2(int kor) {
		this.kor = kor;
	}

	@Override
	public int compareTo(Score2 o) {
		return this.kor-o.kor;
	}
}
