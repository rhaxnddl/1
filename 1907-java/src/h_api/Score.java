// 2019.12.17

package h_api;

public class Score  implements Comparable<Score>{
	int kor;
	
	Score(String kor) {
		this.kor = Integer.parseInt(kor);
	}

	@Override
	public int compareTo (Score o) {
		int r = 0;

		if(this.kor>o.kor) 	r = 1;
		else if(this.kor<o.kor) r = -1;
		else r = 0;

		return r;	
	}
	
	@Override
	public String toString() {
	return this.kor+ "\n";
	}
}
