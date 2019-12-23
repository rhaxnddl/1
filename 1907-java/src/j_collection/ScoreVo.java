package j_collection;

public class ScoreVo {
	String sno;
	String mName;
	String exam;
	int grade;
	int kor;
	int eng;
	int mat;
	int tot = (kor+eng+mat);
	double avg = (tot/3);
	
	public ScoreVo
	(String sno, String mName, String exam, int grade, int kor, int eng, int mat) {
		this.sno = sno;
		this.mName = mName;
		this.exam = exam;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	@Override
	public boolean equals(Object obj) {
		boolean r = false;
		if(obj instanceof ScoreVo) {
			ScoreVo svo = (ScoreVo)obj;
			if(sno == svo.sno) {
				r = true;
			}else
				r = false;
		}
		return r;
	}
	@Override
	public int hashCode() {
		int code = sno.hashCode();
		return code;
	}
//	@Override
//	public String toString() {
//		String 
//	}
//	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
